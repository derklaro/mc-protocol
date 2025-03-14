/*
 * This file is part of mc-protocol-generator, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2023 - 2024 Pasqual K. and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package dev.derklaro.protocolgenerator.protocol;

import dev.derklaro.reflexion.Reflexion;
import dev.derklaro.reflexion.matcher.FieldMatcher;
import dev.derklaro.reflexion.matcher.MethodMatcher;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import lombok.NonNull;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

final class McProtocolsDecoder {

  // matcher for the UnboundProtocol constants in XXXProtocols classes
  private static final FieldMatcher PROTOCOL_INFO_MATCHER = FieldMatcher.newMatcher()
    .hasModifier(Modifier.STATIC)
    .and(field -> {
      var typeName = field.getType().getCanonicalName();
      return typeName.endsWith(".UnboundProtocol") || typeName.endsWith(".SimpleUnboundProtocol");
    });

  // matcher to find the listPackets(PacketVisitor) method in ProtocolInfo$Details
  private static final MethodMatcher LIST_PACKETS_MATCHER = MethodMatcher.newMatcher()
    .parameterCount(1)
    .hasName("listPackets");

  // matcher for InvokeDynamicInsnNode that constructs the info for a protocol
  private static final Predicate<InvokeDynamicInsnNode> PROTOCOL_LAMBDA_BUILDER_FILTER = node -> {
    var bsmArgs = node.bsmArgs;
    return bsmArgs != null
      && bsmArgs.length == 3
      && bsmArgs[2] instanceof Type type
      && type.getArgumentCount() == 1
      && type.getReturnType() == Type.VOID_TYPE
      && type.getArgumentTypes()[0].getClassName().endsWith(".ProtocolInfoBuilder");
  };

  private static final String STREAM_CODEC_DESC = "Lnet/minecraft/network/codec/StreamCodec;";
  private static final String PACKET_TYPE_DESC = "Lnet/minecraft/network/protocol/PacketType;";

  private final Class<?> targetClass;
  private final ClassLoader mcClassLoader;

  public McProtocolsDecoder(@NonNull Class<?> targetClass, @NonNull ClassLoader mcClassLoader) {
    this.targetClass = targetClass;
    this.mcClassLoader = mcClassLoader;
  }

  public @NonNull Map<McPacketFlow, Map<Object, Class<?>>> decodeAssociatedPackets() throws Exception {
    // decode the target class, find the static initializer & all static lambda methods
    var decodedClass = this.decodeTargetClass();
    var clinit = this.findClinit(decodedClass);
    var staticLambdas = this.resolveLambdaMethods(decodedClass);
    if (clinit == null) {
      return Map.of();
    }

    // there can be two calls: one for serverbound, one for clientbound
    var firstInvokeDynamic = this.findNodeOfType(
      InvokeDynamicInsnNode.class,
      clinit,
      null,
      PROTOCOL_LAMBDA_BUILDER_FILTER);
    var secondInvokeDynamic = this.findNodeOfType(
      InvokeDynamicInsnNode.class,
      clinit,
      firstInvokeDynamic,
      PROTOCOL_LAMBDA_BUILDER_FILTER);

    // resolve the protocol info (ProtocolInfoBuilder type -> Invocation Target for configuration)
    var firstProtocolInfo = this.resolveProtocolInvocationInfo(clinit, firstInvokeDynamic);
    var secondProtocolInfo = this.resolveProtocolInvocationInfo(clinit, secondInvokeDynamic);

    // do the actual type mapping for (flow -> (type -> class))
    Map<McPacketFlow, Map<Object, Class<?>>> result = new EnumMap<>(McPacketFlow.class);
    this.doMapTypes(staticLambdas, firstProtocolInfo, result);
    this.doMapTypes(staticLambdas, secondProtocolInfo, result);

    return result;
  }

  public @NonNull Map<McPacketFlow, Map<Object, Integer>> resolvePacketIds(@NonNull Class<?> packetVisitorClass) {
    Map<McPacketFlow, Map<Object, Integer>> result = new EnumMap<>(McPacketFlow.class);

    // resolve the packet ids from the constants in the given class
    var protocolInfoFields = Reflexion.on(this.targetClass).findFields(PROTOCOL_INFO_MATCHER);
    for (var protocolInfoField : protocolInfoFields) {
      // get the details from the protocol info
      var protocolInfo = protocolInfoField.getValue().get();
      var details = Reflexion.onBound(protocolInfo)
        .findMethod("details")
        .flatMap(accessor -> accessor.invoke().asOptional())
        .orElseThrow();

      // resolve the packet list debug method & flow method
      var detailsReflexion = Reflexion.onBound(details);
      var listPacketsMethod = detailsReflexion.findMethod(LIST_PACKETS_MATCHER).orElseThrow();
      var flow = detailsReflexion
        .findMethod("flow")
        .flatMap(accessor -> accessor.invoke().asOptional())
        .orElseThrow();

      // convert the packet flow, register the packet type to id mapping for the flow
      var convertedFlow = this.resolveFlowFromBuilderType(flow.toString());
      if (convertedFlow != null) {
        var typeToId = new HashMap<Object, Integer>();
        var packetVisitorImplGenerator = new PacketVisitorImplGenerator(packetVisitorClass, typeToId);
        var packetVisitorImpl = packetVisitorImplGenerator.generatePacketVisitor();
        var ignored = listPacketsMethod.invokeWithArgs(packetVisitorImpl).getOrThrow();
        result.put(convertedFlow, typeToId);
      }
    }

    return result;
  }

  private void doMapTypes(
    @NonNull Map<String, MethodNode> lambdas,
    @Nullable Map.Entry<String, String> protocolInfo,
    @NonNull Map<McPacketFlow, Map<Object, Class<?>>> target
  ) throws Exception {
    if (protocolInfo != null) {
      var lambda = lambdas.get(protocolInfo.getValue());
      var flow = this.resolveFlowFromBuilderType(protocolInfo.getKey());
      if (flow != null && lambda != null) {
        var packetTypeMappings = this.resolvePacketTypes(lambda);
        target.put(flow, packetTypeMappings);
      }
    }
  }

  private @NonNull Map<Object, Class<?>> resolvePacketTypes(@NonNull MethodNode methodNode) throws Exception {
    var instructions = methodNode.instructions;
    Map<Object, Class<?>> packetTypes = new IdentityHashMap<>();

    var bundle = false; // bundle packets are registered differently
    Class<?> currentPacketClass = null;

    var current = instructions.getLast();
    while (current != null) {
      var currentlyBundle = bundle;
      switch (current) {
        case FieldInsnNode fn when fn.desc.equals(STREAM_CODEC_DESC) ->
          // first call must be the call to the codec in the packet class
          currentPacketClass = this.loadClassByInternalName(fn.owner);

        case FieldInsnNode fn when fn.desc.equals(PACKET_TYPE_DESC) -> {
          // second call must be to the packet type associated with the packet class
          Objects.requireNonNull(currentPacketClass, "found packet type access without packet class before");

          var typeHolderClass = this.loadClassByInternalName(fn.owner);
          var typeField = typeHolderClass.getField(fn.name);
          var packetType = typeField.get(null);

          packetTypes.put(packetType, currentPacketClass);
          bundle = false;
          currentPacketClass = null;
        }

        case MethodInsnNode mn when mn.name.equals("withBundlePacket") ->
          // special case: bundle packets are registered differently into the builder
          // than normal packets, set this marker to notify other handlers
          bundle = true;

        case MethodInsnNode mn when mn.name.equals("<init>") && currentlyBundle -> {
          // when a bundle is registered, a special packet construction is made to the packet that indicates
          // to the client that a bundle starts. This is the packet we're recording here which needs to be
          // registered separately as the packet type never shows up elsewhere after.
          // The class has a type() method which we can use to get the packet type from the class
          var bundleDelimiterClass = this.loadClassByInternalName(mn.owner);
          var bundleDelimiterPacketType = this.findPacketTypeOfPacket(mn.owner);
          packetTypes.put(bundleDelimiterPacketType, bundleDelimiterClass);
        }

        case InvokeDynamicInsnNode idn when idn.name.equals("apply") && currentlyBundle -> {
          // bundle packet type are registered with a function to construct the target packet type
          // therefore the information about the target packet class is directly encoded into the
          // target handle of the invokedynamic instruction, just resolve the class from that
          var invokeHandle = this.findHandle(idn);
          Objects.requireNonNull(invokeHandle, "unable to find target packet handle during bundle registration");
          currentPacketClass = this.loadClassByInternalName(invokeHandle.getOwner());
        }

        default -> {
          // ignored node
        }
      }

      current = current.getPrevious();
    }

    return packetTypes;
  }

  private @Nullable Map.Entry<String, String> resolveProtocolInvocationInfo(
    @NonNull MethodNode owner,
    @Nullable InvokeDynamicInsnNode node
  ) {
    if (node == null) {
      return null;
    }

    // invoke target not found
    var invokeTarget = this.findHandle(node);
    if (invokeTarget == null) {
      return null;
    }

    // next token should be the invocation of the ProtocolInfoBuilder.xxx method
    var invokingMethod = this.findNodeOfType(MethodInsnNode.class, owner, node);
    if (invokingMethod == null) {
      return null;
    }

    // map method name and invoke target name
    var methodName = invokingMethod.name;
    var invokeTargetName = invokeTarget.getName();
    return Map.entry(methodName, invokeTargetName);
  }

  private @NonNull Object findPacketTypeOfPacket(@NonNull String internalPacketClassName) throws Exception {
    var classNode = this.decodeClassByInternalName(internalPacketClassName);
    for (var method : classNode.methods) {
      if (method.name.equals("type") && method.desc.startsWith("()")) {
        var fieldInsnNode = this.findNodeOfType(FieldInsnNode.class, method, null);
        if (fieldInsnNode != null) {
          var typeHolderClass = this.loadClassByInternalName(fieldInsnNode.owner);
          var typeField = typeHolderClass.getField(fieldInsnNode.name);
          return typeField.get(null);
        }
      }
    }

    throw new IllegalStateException("cannot resolve packet type from packet class " + internalPacketClassName);
  }

  private @NonNull ClassNode decodeTargetClass() throws IOException {
    var classFileName = this.targetClass.getName().replace('.', '/');
    return this.decodeClassByInternalName(classFileName);
  }

  private @NonNull ClassNode decodeClassByInternalName(@NonNull String internalName) throws IOException {
    try (var classFileStream = this.mcClassLoader.getResourceAsStream(internalName + ".class")) {
      Objects.requireNonNull(classFileStream, "Class file not found: " + internalName);
      var reader = new ClassReader(classFileStream);

      var classNode = new ClassNode();
      reader.accept(classNode, 0);
      return classNode;
    }
  }

  private @Nullable MethodNode findClinit(@NonNull ClassNode classNode) {
    for (var method : classNode.methods) {
      if (method.name.equals("<clinit>")) {
        return method;
      }
    }

    return null;
  }

  private @Nullable McPacketFlow resolveFlowFromBuilderType(@NonNull String name) {
    var lower = name.toLowerCase(Locale.ROOT);
    if (lower.contains("serverbound")) {
      return McPacketFlow.SERVERBOUND;
    }
    if (lower.contains("clientbound")) {
      return McPacketFlow.CLIENTBOUND;
    }

    return null;
  }

  private @NonNull Map<String, MethodNode> resolveLambdaMethods(@NonNull ClassNode classNode) {
    Map<String, MethodNode> lambdaMethods = new HashMap<>();
    for (var method : classNode.methods) {
      if (method.name.startsWith("lambda$static$")) {
        lambdaMethods.put(method.name, method);
      }
    }

    return lambdaMethods;
  }

  private @Nullable <T extends AbstractInsnNode> T findNodeOfType(
    @NonNull Class<T> type,
    @NonNull MethodNode methodNode,
    @Nullable AbstractInsnNode after
  ) {
    return this.findNodeOfType(type, methodNode, after, ignored -> true);
  }

  private @Nullable <T extends AbstractInsnNode> T findNodeOfType(
    @NonNull Class<T> type,
    @NonNull MethodNode methodNode,
    @Nullable AbstractInsnNode after,
    @NonNull Predicate<T> filter
  ) {
    // either start from the top or from the next node of the insn we want to start after
    AbstractInsnNode start;
    if (after == null) {
      start = methodNode.instructions.getFirst();
    } else {
      start = after.getNext();
    }

    AbstractInsnNode current = start;
    do {
      // either because current.next is null or after.next was null
      if (current == null) {
        return null;
      }

      if (current.getClass() == type) {
        var node = type.cast(current);
        if (filter.test(node)) {
          return node;
        }
      }

      current = current.getNext();
    } while (true);
  }

  private @Nullable Handle findHandle(@NonNull InvokeDynamicInsnNode node) {
    for (var arg : node.bsmArgs) {
      if (arg instanceof Handle handle) {
        return handle;
      }
    }
    return null;
  }


  private @NonNull Class<?> loadClassByInternalName(@NonNull String internalName) throws Exception {
    var javaClassName = internalName.replace('/', '.');
    return Class.forName(javaClassName, true, this.mcClassLoader);
  }
}

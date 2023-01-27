/*
 * This file is part of mc-protocol-generator, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2023 Pasqual K. and contributors
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

import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import dev.derklaro.reflexion.Reflexion;
import dev.derklaro.reflexion.matcher.MethodMatcher;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.Collection;
import java.util.LinkedHashMap;
import lombok.NonNull;

public final class ProtocolInfoCollector {

  private static final MethodMatcher OPPOSITE_FLOW_GETTER = MethodMatcher.newMatcher().hasName("getOpposite");

  private final Path remappedJarPath;

  public ProtocolInfoCollector(@NonNull Path remappedJarPath) {
    this.remappedJarPath = remappedJarPath;
  }

  private static @NonNull Object resolveOppositeFlow(@NonNull Object packetFlow) {
    // get the method to resolve the opposite
    var oppositeAccessor = Reflexion.onBound(packetFlow)
      .findMethod(OPPOSITE_FLOW_GETTER)
      .orElseThrow(() -> new IllegalStateException("Unknown: PacketFlow#getOpposite: PacketFlow"));

    // get the opposite flow
    return oppositeAccessor.invoke().getOrThrow();
  }

  public @NonNull Table<String, String, Collection<PacketClassInfo>> collectAllPacketInfos() throws Exception {
    // build a class loader which is aware of the remapped jar
    var remappedJarUrl = this.remappedJarPath.toUri().toURL();
    var loader = new URLClassLoader(new URL[]{remappedJarUrl}, ClassLoader.getSystemClassLoader());

    // resolve the connection protocol and packet flow class
    var packetFlowClass = Class.forName(McClassNames.PACKET_FLOW, true, loader);
    var connectionProtocolClass = Class.forName(McClassNames.CONNECTION_PROTOCOL, true, loader);

    // resolve all enum constants for later use
    var packetFlows = packetFlowClass.getEnumConstants();
    var connectionProtocols = connectionProtocolClass.getEnumConstants();

    // collect all packets for all protocols & flows
    Table<String, String, Collection<PacketClassInfo>> packetClassInfos = Tables.newCustomTable(
      new LinkedHashMap<>(),
      LinkedHashMap::new);
    for (var connectionProtocol : connectionProtocols) {
      // construct the protocol scanner once for the protocol
      var protocolName = EnumSupport.resolveEnumConstantName(connectionProtocol);
      var protocolScanner = new ConnectionProtocolScanner(connectionProtocol);

      for (var packetFlow : packetFlows) {
        // get the original name and the normalized name of this flow
        var flowName = EnumSupport.resolveEnumConstantName(packetFlow);
        var normalizedFlowName = EnumSupport.normalizeEnumConstantName(packetFlow);

        // get the normalized name of the opposite flow
        var oppositeFlow = resolveOppositeFlow(packetFlow);
        var oppositeFlowName = EnumSupport.normalizeEnumConstantName(oppositeFlow);

        // get all packets
        var packets = protocolScanner.scanPackets(packetFlow, oppositeFlowName, normalizedFlowName);
        packetClassInfos.put(protocolName, flowName, packets);
      }
    }

    // return the created table
    return packetClassInfos;
  }
}

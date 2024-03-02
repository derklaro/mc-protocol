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

import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import lombok.NonNull;

public final class ProtocolInfoCollector {

  private final Path remappedJarPath;
  private final ClassLoader libraryClassLoader;

  public ProtocolInfoCollector(@NonNull Path remappedJarPath, @NonNull ClassLoader libraryClassLoader) {
    this.remappedJarPath = remappedJarPath;
    this.libraryClassLoader = libraryClassLoader;
  }

  public @NonNull Table<String, String, Collection<PacketClassInfo>> collectAllPacketInfos() throws Exception {
    // build a class loader which is aware of the remapped jar
    var remappedJarUrl = this.remappedJarPath.toUri().toURL();
    var loader = new URLClassLoader(new URL[]{remappedJarUrl}, this.libraryClassLoader);

    // important first step: initialize minecraft registries
    var mcInitializer = new McInit(loader);
    mcInitializer.init();

    // collect all packets for all protocols & flows
    // protocol -> flow -> info
    Table<String, String, Collection<PacketClassInfo>> result
      = Tables.newCustomTable(new LinkedHashMap<>(), LinkedHashMap::new);
    for (var state : McProtocolStates.values()) {
      // resolve packet information
      var protocolsClass = Class.forName(state.protocolsClass(), true, loader);
      var infoDecoder = new McProtocolsDecoder(protocolsClass, loader);
      var typeToPacketClassPerFlow = infoDecoder.decodeAssociatedPackets();
      var typeToPacketIdPerFlow = infoDecoder.resolvePacketIds();

      // register for each flow (if present)
      for (var flow : McPacketFlow.values()) {
        var idMapping = typeToPacketIdPerFlow.get(flow);
        var classMapping = typeToPacketClassPerFlow.get(flow);
        if (idMapping != null && classMapping != null) {
          var idEntries = new ArrayList<>(idMapping.entrySet());
          idEntries.sort(Map.Entry.comparingByValue());

          for (var entry : idEntries) {
            var packetId = entry.getValue();
            var packetType = entry.getKey();
            var packetClass = classMapping.get(packetType);
            Objects.requireNonNull(packetClass, "class for packet type missing " + packetType);

            // construct the base packet info
            var externalName = this.externalizePacketClassName(flow, packetClass.getSimpleName());
            var baseInfo = new PacketClassInfo(packetId, externalName, flow.sender().name(), flow.name());
            var fieldScanner = new PacketClassFieldScanner(packetClass, baseInfo);
            fieldScanner.scanAndRegisterClassFields();

            // register the packet
            var packetInfos = result.get(state.displayName(), flow.name());
            if (packetInfos == null) {
              packetInfos = new LinkedList<>();
              result.put(state.displayName(), flow.name(), packetInfos);
            }
            packetInfos.add(baseInfo);
          }
        }
      }
    }

    return result;
  }

  /* example: ClientboundSetSimulationDistancePacket -> Set Simulation Distance */
  private @NonNull String externalizePacketClassName(@NonNull McPacketFlow flow, @NonNull String packetName) {
    // remove the flow name from the packet class name
    var lowerName = packetName.toLowerCase(Locale.ROOT);
    var lowerFlowName = flow.name().toLowerCase(Locale.ROOT);
    if (lowerName.startsWith(lowerFlowName)) {
      packetName = packetName.substring(lowerFlowName.length());
    }

    // remove the packet suffix
    if (lowerName.endsWith("packet")) {
      packetName = packetName.substring(0, packetName.length() - 6);
    }

    // insert space before each upper-camel char
    var splitAtCamel = packetName.split("(?=\\p{Lu})");
    return String.join(" ", splitAtCamel);
  }
}

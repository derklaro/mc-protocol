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

import dev.derklaro.reflexion.Reflexion;
import dev.derklaro.reflexion.matcher.MethodMatcher;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lombok.NonNull;

final class ConnectionProtocolScanner {

  private static final MethodMatcher GET_PACKETS_BY_ID_MATCHER = MethodMatcher.newMatcher()
    .parameterCount(1)
    .hasName("getPacketsByIds")
    .derivedType(Method::getReturnType, Map.class);

  private final Object connectionProtocol;

  public ConnectionProtocolScanner(@NonNull Object connectionProtocol) {
    this.connectionProtocol = connectionProtocol;
  }

  public @NonNull Collection<PacketClassInfo> scanPackets(
    @NonNull Object packetFlow,
    @NonNull String sourceFlowName,
    @NonNull String targetFlowName
  ) {
    // resolve the method to invoke to get the packets
    var packetsByIdMethod = Reflexion.onBound(this.connectionProtocol)
      .findMethod(GET_PACKETS_BY_ID_MATCHER)
      .orElseThrow(() -> new IllegalStateException("Unknown: ConnectionProtocol#getPacketsByIds(PacketFlow): Map"));

    // get the packets of the connection protocol for the current packet flow
    var packets = packetsByIdMethod.<Map<Integer, Class<?>>>invokeWithArgs(packetFlow).getOrThrow();

    // map each packet
    List<PacketClassInfo> packetClassInfos = new LinkedList<>();
    for (var entry : packets.entrySet()) {
      // normalize the packet class name
      var normalizedName = entry.getValue().getSimpleName().replaceFirst(sourceFlowName, "");
      var fullName = String.join(" ", normalizedName.split("(?=\\p{Lu})"));

      // build a packet class info
      var packetClassInfo = new PacketClassInfo(entry.getKey(), fullName, sourceFlowName, targetFlowName);
      packetClassInfos.add(packetClassInfo);

      // resolve all fields in the packet class
      var fieldScanner = new PacketClassFieldScanner(entry.getValue(), packetClassInfo);
      fieldScanner.scanAndRegisterClassFields();
    }

    // sort & return the collected class infos
    Collections.sort(packetClassInfos);
    return packetClassInfos;
  }
}

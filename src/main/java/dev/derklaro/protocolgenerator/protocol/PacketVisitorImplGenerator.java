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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;
import lombok.NonNull;

final class PacketVisitorImplGenerator {

  private final Class<?> packetVisitorClass;
  private final Map<Object, Integer> targetPacketTypeToIdMap;

  public PacketVisitorImplGenerator(
    @NonNull Class<?> packetVisitorClass,
    @NonNull Map<Object, Integer> targetPacketTypeToIdMap
  ) {
    this.packetVisitorClass = packetVisitorClass;
    this.targetPacketTypeToIdMap = targetPacketTypeToIdMap;
  }

  public @NonNull Object generatePacketVisitor() {
    InvocationHandler packetVisitorHandler = (ignored, method, args) -> {
      // accept(PacketType, int)
      if (method.getName().equals("accept")
        && method.getParameterCount() == 2
        && method.getReturnType() == void.class) {
        var packetType = args[0];
        var packetId = (Integer) args[1];
        this.targetPacketTypeToIdMap.put(packetType, packetId);
        return null;
      }

      // unknown method
      throw new UnsupportedOperationException("Called unsupported method: " + method.getName() + " on proxy");
    };
    return Proxy.newProxyInstance(
      this.packetVisitorClass.getClassLoader(),
      new Class<?>[]{this.packetVisitorClass},
      packetVisitorHandler);
  }
}

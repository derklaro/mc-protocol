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
import dev.derklaro.reflexion.matcher.MethodMatcher;
import lombok.NonNull;

final class McUnboundProtocolBinder {

  private final Object protocolInfo;
  private final ClassLoader mcClassLoader;

  public McUnboundProtocolBinder(@NonNull Object protocolInfo, @NonNull ClassLoader mcClassLoader) {
    this.protocolInfo = protocolInfo;
    this.mcClassLoader = mcClassLoader;
  }

  public static boolean isUnbound(@NonNull Class<?> clazz) {
    // check if the given type directly is an unbound protocol info
    var name = clazz.getName();
    if (name.endsWith(".ProtocolInfo$Unbound")) {
      return true;
    }

    // check if the class implements the unbound interface
    var interfaces = clazz.getInterfaces();
    for (var implementingInterface : interfaces) {
      if (isUnbound(implementingInterface)) {
        return true;
      }
    }

    return false;
  }

  public @NonNull Object bind() {
    var emptyRegistry = Reflexion.find(McClassNames.REGISTRY_ACCESS, this.mcClassLoader)
      .flatMap(reflexion -> reflexion.findField("EMPTY"))
      .flatMap(accessor -> accessor.getValue().asOptional())
      .orElseThrow();

    var registryFriendlyBB = Reflexion.find(McClassNames.REGISTRY_FRIENDLY_BB, this.mcClassLoader)
      .flatMap(reflexion -> reflexion.findMethod(MethodMatcher.newMatcher()
        .parameterCount(1)
        .hasName("decorator")
        .and(method -> {
          var firstParamType = method.getParameterTypes()[0];
          return firstParamType.getName().equals(McClassNames.REGISTRY_ACCESS);
        })))
      .flatMap(accessor -> accessor.invoke(null, emptyRegistry).asOptional())
      .orElseThrow();

    return Reflexion.on(this.protocolInfo)
      .findMethod(MethodMatcher.newMatcher()
        .hasName("bind")
        .parameterCount(1))
      .flatMap(accessor -> accessor.invoke(this.protocolInfo, registryFriendlyBB).asOptional())
      .orElseThrow();
  }
}

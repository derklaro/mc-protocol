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

import java.lang.reflect.Modifier;
import lombok.NonNull;

final class PacketClassFieldScanner {

  private final Class<?> packetClass;
  private final PacketClassInfo baseInfo;

  public PacketClassFieldScanner(@NonNull Class<?> packetClass, @NonNull PacketClassInfo baseInfo) {
    this.packetClass = packetClass;
    this.baseInfo = baseInfo;
  }

  public void scanAndRegisterClassFields() {
    // walk up the class tree
    var currentClass = this.packetClass;
    do {
      var fields = currentClass.getDeclaredFields();
      for (var field : fields) {
        var fieldModifiers = field.getModifiers();
        if (!Modifier.isStatic(fieldModifiers)) {
          var fieldInfo = PacketClassInfo.FieldInfo.ofReflectField(field);
          this.baseInfo.registerField(fieldInfo);
        }
      }

    } while ((currentClass = currentClass.getSuperclass()) != Object.class);
  }
}

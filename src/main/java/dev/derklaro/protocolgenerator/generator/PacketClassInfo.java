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

package dev.derklaro.protocolgenerator.generator;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lombok.NonNull;

record PacketClassInfo(
  int packetId,
  @NonNull String name,
  @NonNull String source,
  @NonNull String target,
  @NonNull Map<Class<?>, List<FieldInfo>> fields
) {

  public PacketClassInfo(int packetId, @NonNull String name, @NonNull String source, @NonNull String target) {
    this(packetId, name, source, target, new LinkedHashMap<>());
  }

  public void registerField(@NonNull FieldInfo fieldInfo) {
    var info = this.fields.computeIfAbsent(fieldInfo.rawType(), $ -> new LinkedList<>());
    info.add(fieldInfo);
  }

  public record FieldInfo(@NonNull String name, @NonNull Class<?> rawType, @NonNull Type genericType) {

    public static @NonNull FieldInfo ofReflectField(@NonNull Field field) {
      return new FieldInfo(field.getName(), field.getType(), field.getGenericType());
    }
  }
}

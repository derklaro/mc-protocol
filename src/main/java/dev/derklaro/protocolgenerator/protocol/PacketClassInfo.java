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

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import lombok.NonNull;

public record PacketClassInfo(
  int packetId,
  @NonNull String name,
  @NonNull String source,
  @NonNull String target,
  @NonNull List<FieldInfo> fields
) implements Comparable<PacketClassInfo> {

  public PacketClassInfo(int packetId, @NonNull String name, @NonNull String source, @NonNull String target) {
    this(packetId, name, source, target, new LinkedList<>());
  }

  public void registerField(@NonNull FieldInfo fieldInfo) {
    this.fields.add(fieldInfo);
  }

  @Override
  public int compareTo(@NonNull PacketClassInfo other) {
    return Integer.compare(this.packetId(), other.packetId());
  }

  public record FieldInfo(@NonNull String name, @NonNull Class<?> rawType, @NonNull Type genericType) {

    public static @NonNull FieldInfo ofReflectField(@NonNull Field field) {
      return new FieldInfo(field.getName(), field.getType(), field.getGenericType());
    }
  }
}

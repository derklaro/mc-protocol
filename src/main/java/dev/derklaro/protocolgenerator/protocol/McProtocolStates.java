/*
 * This file is part of mc-protocol-generator, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2024 Pasqual K. and contributors
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

import lombok.NonNull;

enum McProtocolStates {

  /* state order here reflects into the field order of the final output */

  HANDSHAKING("handshake"),
  STATUS("status"),
  LOGIN("login"),
  CONFIGURATION("configuration"),
  PLAY("game");

  private static final String PKG_PREFIX_BASE = "net.minecraft.network.protocol.%s";

  private final String pkg;
  private final String displayName;

  McProtocolStates(@NonNull String name) {
    this(name, String.format(PKG_PREFIX_BASE, name));
  }

  McProtocolStates(@NonNull String name, @NonNull String pkg) {
    this.pkg = pkg;

    var firstChar = Character.toUpperCase(name.charAt(0));
    this.displayName = String.format("%c%s", firstChar, name.substring(1));
  }

  public @NonNull String displayName() {
    return this.displayName;
  }

  public @NonNull String protocolsClass() {
    return String.format("%s.%sProtocols", this.pkg, this.displayName);
  }
}

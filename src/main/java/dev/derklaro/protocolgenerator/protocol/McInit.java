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

final class McInit {

  private final ClassLoader classLoader;

  public McInit(@NonNull ClassLoader classLoader) {
    this.classLoader = classLoader;
  }

  public void init() throws Exception {
    // detect running version
    var sharedConstantsClass = Class.forName(McClassNames.SHARED_CONSTANTS, true, this.classLoader);
    var tryDetectVersionMethod = sharedConstantsClass.getMethod("tryDetectVersion");
    tryDetectVersionMethod.invoke(null);

    // bootstrap registries
    var bootstrapClass = Class.forName(McClassNames.BOOTSTRAP, true, this.classLoader);
    var bootStrapMethod = bootstrapClass.getMethod("bootStrap");
    bootStrapMethod.invoke(null);
  }
}

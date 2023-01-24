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

package dev.derklaro.protocolgenerator.remap;

import io.github.lxgaming.reconstruct.common.Reconstruct;
import io.github.lxgaming.reconstruct.common.configuration.Config;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;
import lombok.NonNull;

public final class JarRemapper {

  private static final Supplier<Config> RECONSTRUCT_CONFIG_FACTORY = ReconstructConfig::new;

  private final Path inputJarFile;
  private final Path mappingsPath;

  public JarRemapper(@NonNull Path inputJarFile, @NonNull Path mappingsPath) {
    this.inputJarFile = inputJarFile;
    this.mappingsPath = mappingsPath;
  }

  public @NonNull Path remap() throws IOException {
    // construct a reconstruct config and set the supplied values
    var reconstructConfig = RECONSTRUCT_CONFIG_FACTORY.get();
    reconstructConfig.setInputPath(this.inputJarFile);
    reconstructConfig.setMappingPath(this.mappingsPath);

    // generate a temp output file to write the reconstructed value to
    var outputPath = Files.createTempFile("reconstructed-jar", null);
    reconstructConfig.setOutputPath(outputPath);

    // execute the remap process
    var reconstruct = new Reconstruct(reconstructConfig);
    reconstruct.load();

    // return the constructed temp path
    return outputPath;
  }
}

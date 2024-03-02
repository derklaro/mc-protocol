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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;
import lombok.NonNull;
import net.minecraftforge.fart.api.IdentifierFixerConfig;
import net.minecraftforge.fart.api.Renamer;
import net.minecraftforge.fart.api.SignatureStripperConfig;
import net.minecraftforge.fart.api.SourceFixerConfig;
import net.minecraftforge.fart.api.Transformer;
import net.minecraftforge.srgutils.IMappingFile;

public final class JarRemapper {

  private static final Consumer<String> NO_OP_LOGGER = __ -> {
  };

  private final Path inputJarFile;
  private final Path mappingsPath;

  public JarRemapper(@NonNull Path inputJarFile, @NonNull Path mappingsPath) {
    this.inputJarFile = inputJarFile;
    this.mappingsPath = mappingsPath;
  }

  public void remap(@NonNull Path outputPath) throws IOException {
    try (var mappingsStream = Files.newInputStream(this.mappingsPath)) {
      var mappings = IMappingFile.load(mappingsStream).reverse();
      var renamerBuilder = Renamer.builder()
        .logger(NO_OP_LOGGER)
        .add(Transformer.renamerFactory(mappings, false))
        .add(Transformer.parameterAnnotationFixerFactory())
        .add(Transformer.recordFixerFactory())
        .add(Transformer.identifierFixerFactory(IdentifierFixerConfig.ALL))
        .add(Transformer.sourceFixerFactory(SourceFixerConfig.JAVA))
        .add(Transformer.signatureStripperFactory(SignatureStripperConfig.ALL));
      try (var renamer = renamerBuilder.build()) {
        renamer.run(this.inputJarFile.toFile(), outputPath.toFile());
      }
    }
  }
}

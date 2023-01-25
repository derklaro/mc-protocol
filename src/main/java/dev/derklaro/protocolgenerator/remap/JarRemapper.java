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

import cuchaz.enigma.Enigma;
import cuchaz.enigma.ProgressListener;
import cuchaz.enigma.classprovider.ClasspathClassProvider;
import cuchaz.enigma.translation.mapping.serde.MappingFormat;
import cuchaz.enigma.translation.mapping.serde.MappingParseException;
import java.io.IOException;
import java.nio.file.Path;
import lombok.NonNull;

public final class JarRemapper {

  private static final ProgressListener PROGRESS_LISTENER = ProgressListener.none(); // todo maybe add a real progress listener?

  private final Path inputJarFile;
  private final Path mappingsPath;

  public JarRemapper(@NonNull Path inputJarFile, @NonNull Path mappingsPath) {
    this.inputJarFile = inputJarFile;
    this.mappingsPath = mappingsPath;
  }

  public void remap(@NonNull Path outputPath) throws IOException, MappingParseException {
    // read the jar file
    var enigma = Enigma.create();
    var project = enigma.openJar(this.inputJarFile, new ClasspathClassProvider(), PROGRESS_LISTENER);

    // read and set the mappings
    var saveParameters = enigma.getProfile().getMappingSaveParameters();
    var mappingTree = MappingFormat.PROGUARD.read(this.mappingsPath, PROGRESS_LISTENER, saveParameters);
    project.setMappings(mappingTree);

    // export the jar file
    var jarExport = project.exportRemappedJar(PROGRESS_LISTENER);
    jarExport.write(outputPath, PROGRESS_LISTENER);
  }
}

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

package dev.derklaro.protocolgenerator.gameversion;

import dev.derklaro.protocolgenerator.gson.GsonProvider;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.jar.JarFile;
import lombok.NonNull;

public final class JarGameVersionParser {

  private static final String VERSION_JSON_FILE_NAME = "version.json";

  private final Path gameJarPath;

  public JarGameVersionParser(@NonNull Path gameJarPath) {
    this.gameJarPath = gameJarPath;
  }

  public @NonNull GameVersion readGameVersion() throws IOException {
    try (var jarFile = new JarFile(this.gameJarPath.toFile())) {
      // get the version json entry
      var versionJsonEntry = jarFile.getEntry(VERSION_JSON_FILE_NAME);
      var versionJsonStream = jarFile.getInputStream(versionJsonEntry);

      // read the file
      try (var reader = new InputStreamReader(versionJsonStream, StandardCharsets.UTF_8)) {
        return GsonProvider.ISO_8601_DATE_TIME_GSON.fromJson(reader, GameVersion.class);
      }
    }
  }
}

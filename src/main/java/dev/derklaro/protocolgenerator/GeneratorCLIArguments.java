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

package dev.derklaro.protocolgenerator;

import dev.derklaro.protocolgenerator.cli.CliArgParser;
import dev.derklaro.protocolgenerator.manifest.McManifestVersionType;
import lombok.NonNull;
import net.sourceforge.argparse4j.impl.Arguments;

final class GeneratorCLIArguments {

  private GeneratorCLIArguments() {
    throw new UnsupportedOperationException();
  }

  public static void registerDefaultArguments(@NonNull CliArgParser argParser) {
    // argument to set the version type to fetch
    argParser.registerArgument("-vt", "--version-type")
      .setDefault(McManifestVersionType.LATEST)
      .help("Sets the argument type to download and parse the protocol of")
      .type(Arguments.caseInsensitiveEnumType(McManifestVersionType.class));

    // the final output file name
    argParser.registerArgument("-of", "--output-file")
      .setDefault("readme.md")
      .help("The name of the output file to export to (the parent directory need to exist)");

    // if a file with the generated version should be created
    argParser.registerArgument("-vf", "--version-file")
      .help("Sets an optional file path to dump the target Minecraft version version to");
  }
}

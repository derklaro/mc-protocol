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

package dev.derklaro.protocolgenerator.downloader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.HexFormat;
import lombok.NonNull;

final class Sha1DownloadValidator implements FileDownloadValidator {

  private final String sha1Hex;

  public Sha1DownloadValidator(@NonNull String sha1Hex) {
    this.sha1Hex = sha1Hex;
  }

  @Override
  @SuppressWarnings("StatementWithEmptyBody")
  public boolean validate(@NonNull Path downloadPath) throws Exception {
    var sha1Digest = MessageDigest.getInstance("SHA-1");
    try (
      var fileStream = Files.newInputStream(downloadPath);
      var digestStream = new DigestInputStream(fileStream, sha1Digest)
    ) {
      // read all bytes provided by the stream
      var buffer = new byte[1024];
      while (digestStream.read(buffer) != -1) {
      }

      // compute the hex of the stream & validate it against the provided hex
      var digest = sha1Digest.digest();
      var hexDigest = HexFormat.of().formatHex(digest);
      return this.sha1Hex.equals(hexDigest);
    }
  }
}

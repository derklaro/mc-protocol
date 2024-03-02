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

package dev.derklaro.protocolgenerator.http;

import dev.derklaro.protocolgenerator.util.CatchingFunction;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;

public final class HttpFileDownloader {

  private HttpFileDownloader() {
    throw new UnsupportedOperationException();
  }

  public static @NonNull CompletableFuture<Void> downloadFile(@NonNull String url, @NonNull Path filePath) {
    try (var httpClient = HttpClientProvider.provideClient()) {
      var request = HttpRequest.newBuilder(URI.create(url)).build();
      return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofInputStream())
        .thenApply(BodyParser.bodyExtractorIfOk())
        .thenApply(CatchingFunction.asJavaUtil(stream -> {
          var parent = filePath.getParent();
          if (parent != null) {
            Files.createDirectories(parent);
          }

          try (stream) {
            Files.copy(stream, filePath, StandardCopyOption.REPLACE_EXISTING);
            return null;
          }
        }, "Unable to download file from " + url + " to " + filePath));
    }
  }
}

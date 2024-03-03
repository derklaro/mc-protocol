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

import dev.derklaro.protocolgenerator.http.BodyParser;
import dev.derklaro.protocolgenerator.http.HttpClientProvider;
import dev.derklaro.protocolgenerator.util.CatchingFunction;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.CompletableFuture;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import lombok.NonNull;

public final class FileDownloader {

  private static final CompletableFuture<Void> V_COMPLETED_FUTURE = CompletableFuture.completedFuture(null);

  private final URI uri;
  private final Path target;
  private final FileDownloadValidator validator;

  public FileDownloader(@NonNull URI uri, @NonNull Path target) {
    this(uri, target, null);
  }

  public FileDownloader(@NonNull String uri, @NonNull Path target) {
    this(URI.create(uri), target);
  }

  private FileDownloader(@NonNull URI uri, @NonNull Path target, @Nullable FileDownloadValidator validator) {
    this.uri = uri;
    this.target = target;
    this.validator = validator;
  }

  @CheckReturnValue
  public @NonNull FileDownloader withValidator(@NonNull FileDownloadValidator validator) {
    return new FileDownloader(this.uri, this.target, validator);
  }

  public @NonNull CompletableFuture<Void> executeDownload() {
    return this.validateOrDownload(0);
  }

  private @NonNull CompletableFuture<Void> downloadAndValidate(int retryCount) {
    try (var httpClient = HttpClientProvider.provideClient()) {
      var req = HttpRequest.newBuilder(this.uri).build();
      return httpClient.sendAsync(req, HttpResponse.BodyHandlers.ofInputStream())
        .thenApply(BodyParser.bodyExtractorIfOk())
        .thenApply(CatchingFunction.asJavaUtil(stream -> {
          // create parent directory if necessary
          var parent = this.target.getParent();
          if (parent != null) {
            Files.createDirectories(parent);
          }

          // copy the result to the target location
          try (stream) {
            Files.copy(stream, this.target, StandardCopyOption.REPLACE_EXISTING);
            return null;
          }
        }, "Unable to download file from " + this.uri + " to " + this.target))
        .thenCompose(__ -> this.validateOrDownload(retryCount));
    }
  }

  private @NonNull CompletableFuture<Void> validateOrDownload(int retryCount) {
    var validationResult = this.validateDownload();
    if (validationResult) {
      return V_COMPLETED_FUTURE;
    } else if (retryCount <= 3) {
      return this.downloadAndValidate(retryCount + 1);
    } else {
      return CompletableFuture.failedFuture(
        new IllegalStateException("Download from" + this.uri + " failed multiple times, aborting"));
    }
  }

  private boolean validateDownload() {
    if (this.validator == null || Files.notExists(this.target)) {
      // no validator / download -> download is valid
      return false;
    }

    try {
      return this.validator.validate(this.target);
    } catch (Exception exception) {
      return false;
    }
  }
}

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

package dev.derklaro.protocolgenerator.library;

import dev.derklaro.protocolgenerator.http.HttpFileDownloader;
import dev.derklaro.protocolgenerator.manifest.McManifestVersionData;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;

public final class McLibraryLoader {

  private static final String LIB_ARTIFACT_DOWNLOAD_KEY = "artifact";

  private final Path libraryDirectory;
  private final List<URL> libraries = new ArrayList<>();

  public McLibraryLoader(@NonNull Path libraryDirectory) {
    this.libraryDirectory = libraryDirectory;
  }

  public @NonNull CompletableFuture<Void> loadLibrary(@NonNull McManifestVersionData.Library library) {
    var download = library.downloads().get(LIB_ARTIFACT_DOWNLOAD_KEY);
    if (download != null) {
      var localPath = this.libraryDirectory.resolve(download.pathName());
      return HttpFileDownloader.downloadFile(download.downloadUrl(), localPath).thenRun(() -> {
        try {
          var url = localPath.toUri().toURL();
          this.libraries.add(url);
        } catch (IOException exception) {
          throw new IllegalStateException("error converting path to url", exception);
        }
      });
    } else {
      return CompletableFuture.completedFuture(null);
    }
  }

  public @NonNull ClassLoader provideClassLoader() {
    var urls = this.libraries.toArray(URL[]::new);
    return new URLClassLoader(urls, ClassLoader.getSystemClassLoader());
  }
}

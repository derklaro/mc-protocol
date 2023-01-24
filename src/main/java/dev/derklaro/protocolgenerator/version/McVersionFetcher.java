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

package dev.derklaro.protocolgenerator.version;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import dev.derklaro.protocolgenerator.http.BodyParser;
import dev.derklaro.protocolgenerator.http.HttpClientProvider;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;

public final class McVersionFetcher {

  private static final URI VERSION_MANIFEST_URI = URI.create(
    "https://piston-meta.mojang.com/mc/game/version_manifest_v2.json");
  private static final Type COLLECTION_MC_VERSION = TypeToken.getParameterized(Set.class, McVersion.class).getType();

  public @NonNull CompletableFuture<Collection<McVersion>> resolveMcVersions() {
    var httpClient = HttpClientProvider.provideClient();
    var request = HttpRequest.newBuilder(VERSION_MANIFEST_URI).build();

    return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofInputStream())
      .thenApply(BodyParser.bodyExtractorIfOk())
      .thenApply(BodyParser.toJsonObject())
      .thenApply(fullJsonElement -> {
        // get the releases section
        var versionsSection = fullJsonElement.get("versions");
        return McVersion.VERSION_GSON.fromJson(versionsSection, COLLECTION_MC_VERSION);
      });
  }

  public @NonNull CompletableFuture<JsonObject> parseVersionData(@NonNull McVersion version) {
    var httpClient = HttpClientProvider.provideClient();
    var request = HttpRequest.newBuilder(version.uri()).build();

    return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofInputStream())
      .thenApply(BodyParser.bodyExtractorIfOk())
      .thenApply(BodyParser.toJsonObject());
  }
}

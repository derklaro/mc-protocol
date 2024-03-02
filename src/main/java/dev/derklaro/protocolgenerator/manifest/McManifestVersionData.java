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

package dev.derklaro.protocolgenerator.manifest;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public record McManifestVersionData(
  @JsonProperty("id") String id,
  @JsonProperty("type") McManifestVersionType type,
  @JsonProperty("libraries") List<Library> libraries,
  @JsonProperty("releaseTime") OffsetDateTime releaseTime,
  @JsonProperty("minimumLauncherVersion") int minLauncherVersion,
  @JsonProperty("downloads") Map<String, FileDownload> fileDownloads
) {

  public record Library(
    @JsonProperty("name") String id,
    @JsonProperty("downloads") Map<String, LibraryDownload> downloads
  ) {

  }

  public record LibraryDownload(
    @JsonProperty("path") String pathName,
    @JsonProperty("sha1") String sha1,
    @JsonProperty("url") String downloadUrl
  ) {

  }

  public record FileDownload(
    @JsonProperty("sha1") String sha1,
    @JsonProperty("url") String downloadUrl
  ) {

  }
}

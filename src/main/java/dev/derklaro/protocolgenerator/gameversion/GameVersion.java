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

import com.google.gson.annotations.SerializedName;
import java.time.OffsetDateTime;
import lombok.NonNull;

public record GameVersion(
  @NonNull String id,
  @NonNull String name,
  @NonNull @SerializedName("series_id") String series,
  @NonNull @SerializedName("build_time") OffsetDateTime buildTime,
  @NonNull @SerializedName("pack_version") PackVersion packVersion,
  @NonNull @SerializedName("java_component") String javaComponent,
  @SerializedName("java_version") int javaVersion,
  @SerializedName("protocol_version") int protocolVersion,
  @SerializedName("world_version") int worldVersion,
  boolean stable
) {

  public record PackVersion(int resource, int data) {

  }
}

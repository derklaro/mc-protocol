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

package dev.derklaro.protocolgenerator.http;

import com.fasterxml.jackson.databind.JsonNode;
import dev.derklaro.protocolgenerator.jackson.JacksonSupport;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;
import lombok.NonNull;

public final class BodyParser {

  private static final Function<InputStream, JsonNode> TO_JSON_OBJECT = stream -> {
    try (var reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
      return JacksonSupport.OBJECT_MAPPER.readTree(reader);
    } catch (IOException exception) {
      throw new IllegalStateException("Unable to parse json input", exception);
    }
  };

  private static final Function<? extends HttpResponse<?>, ?> BODY_EXTRACTOR = response -> {
    var statusCode = response.statusCode();
    if (statusCode == /* HTTP-OK */ 200) {
      return response.body();
    } else {
      throw new IllegalStateException("Expected status 200 (OK), got: " + statusCode);
    }
  };

  private BodyParser() {
    throw new UnsupportedOperationException();
  }

  public static @NonNull Function<InputStream, JsonNode> toJsonObject() {
    return TO_JSON_OBJECT;
  }

  @SuppressWarnings("unchecked")
  public static @NonNull <T> Function<HttpResponse<T>, T> bodyExtractorIfOk() {
    return (Function<HttpResponse<T>, T>) BODY_EXTRACTOR;
  }
}

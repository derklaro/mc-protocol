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

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import lombok.NonNull;

public final class HttpClientProvider {

  private static final Duration DEFAULT_CONNECT_TIMEOUT = Duration.ofSeconds(15);
  private static final HttpClient.Redirect REDIRECT_POLICY = HttpClient.Redirect.NORMAL;

  private static final Executor REQUEST_EXECUTOR = Executors.newCachedThreadPool(new ThreadFactoryBuilder()
    .setDaemon(true)
    .setNameFormat("http-request-executor-%d")
    .setThreadFactory(Executors.defaultThreadFactory())
    .build());

  private HttpClientProvider() {
    throw new UnsupportedOperationException();
  }

  public static @NonNull HttpClient provideClient() {
    return HttpClient.newBuilder()
      .executor(REQUEST_EXECUTOR)
      .followRedirects(REDIRECT_POLICY)
      .connectTimeout(DEFAULT_CONNECT_TIMEOUT)
      .build();
  }
}

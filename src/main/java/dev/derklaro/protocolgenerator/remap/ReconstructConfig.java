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

package dev.derklaro.protocolgenerator.remap;

import io.github.lxgaming.reconstruct.common.configuration.Config;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Set;
import lombok.NonNull;

final class ReconstructConfig implements Config {

  private static final Set<String> EXCLUDED_PACKAGES = Set.of("net.", "com.");
  private static final int RECONSTRUCT_THREADS = Runtime.getRuntime().availableProcessors();

  private Path inputPath;
  private Path outputPath;
  private Path mappingPath;

  private int reconstructThreads = RECONSTRUCT_THREADS;

  @Override
  public boolean isDebug() {
    return false;
  }

  @Override
  public boolean isTrace() {
    return false;
  }

  @Override
  public int getThreads() {
    return this.reconstructThreads;
  }

  @Override
  public void setThreads(int threads) {
    this.reconstructThreads = threads;
  }

  @Override
  public @NonNull Collection<String> getTransformers() {
    return Set.of();
  }

  @Override
  public @NonNull Path getInputPath() {
    return this.inputPath;
  }

  @Override
  public void setInputPath(@NonNull Path inputPath) {
    this.inputPath = inputPath;
  }

  @Override
  public Path getMappingPath() {
    return this.mappingPath;
  }

  @Override
  public void setMappingPath(Path mappingPath) {
    this.mappingPath = mappingPath;
  }

  @Override
  public Path getOutputPath() {
    return this.outputPath;
  }

  @Override
  public void setOutputPath(Path outputPath) {
    this.outputPath = outputPath;
  }

  @Override
  public @NonNull Collection<String> getExcludedPackages() {
    return EXCLUDED_PACKAGES;
  }
}

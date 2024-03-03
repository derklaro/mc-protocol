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

package dev.derklaro.protocolgenerator;

import dev.derklaro.protocolgenerator.cli.CliArgParser;
import dev.derklaro.protocolgenerator.downloader.FileDownloadValidator;
import dev.derklaro.protocolgenerator.downloader.FileDownloader;
import dev.derklaro.protocolgenerator.gameversion.JarGameVersionParser;
import dev.derklaro.protocolgenerator.library.McLibraryLoader;
import dev.derklaro.protocolgenerator.manifest.McManifestVersionFetcher;
import dev.derklaro.protocolgenerator.manifest.McManifestVersionType;
import dev.derklaro.protocolgenerator.manifest.McVersionDumper;
import dev.derklaro.protocolgenerator.markdown.MarkdownFormatter;
import dev.derklaro.protocolgenerator.markdown.MarkdownGenerator;
import dev.derklaro.protocolgenerator.protocol.ProtocolInfoCollector;
import dev.derklaro.protocolgenerator.remap.JarRemapper;
import dev.derklaro.protocolgenerator.util.CatchingFunction;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import lombok.NonNull;

public final class GeneratorEntrypoint {

  private static final Path LIB_DIR_PATH = Path.of("client_libs");
  private static final Path MAPPING_PATH = Path.of("mappings.tmp");
  private static final Path CLIENT_JAR_PATH = Path.of("client.tmp");
  private static final Path REMAPPED_JAR_PATH = Path.of("client_remapped.tmp");

  public static void main(@NonNull String[] args) throws IOException {
    // parse the cli arguments
    var cliArgumentParser = new CliArgParser("ProtocolGenerator");
    GeneratorCLIArguments.registerDefaultArguments(cliArgumentParser);
    var cliNamespace = cliArgumentParser.parseCommandLine(args);

    // resolve all client versions
    var versionFetcher = new McManifestVersionFetcher();
    var clientVersions = versionFetcher.resolveMcVersions();

    // search the requested version
    McManifestVersionType versionType = cliNamespace.get("version_type");
    var latestVersionOfType = clientVersions
      .thenApply(versions -> versions.stream()
        .filter(version -> versionType == McManifestVersionType.LATEST || version.type() == versionType)
        .sorted()
        .findFirst())
      .thenApply(optional -> {
        Supplier<RuntimeException> versionNotFoundExceptionSupplier =
          () -> new IllegalStateException("Unable to find a version with type " + versionType);
        return optional.orElseThrow(versionNotFoundExceptionSupplier);
      });

    // deserialize version data
    var versionData = latestVersionOfType.thenCompose(versionFetcher::parseVersionData);

    // download the client and client mappings of the version
    var versionTypeDownloads = versionData.thenCompose(data -> {
      var clientDownloadInfo = data.fileDownloads().get("client");
      var mappingsDownloadInfo = data.fileDownloads().get("client_mappings");

      // no null check here as we just require the downloads to present
      // in all other cases we cannot proceed anyway
      var clientDownload = new FileDownloader(clientDownloadInfo.downloadUrl(), CLIENT_JAR_PATH)
        .withValidator(FileDownloadValidator.ofSha1(clientDownloadInfo.sha1()))
        .executeDownload();
      var clientMappingsDownload = new FileDownloader(mappingsDownloadInfo.downloadUrl(), MAPPING_PATH)
        .withValidator(FileDownloadValidator.ofSha1(mappingsDownloadInfo.sha1()))
        .executeDownload();

      // combine both futures
      return CompletableFuture.allOf(clientDownload, clientMappingsDownload);
    });

    // download all required client libraries
    var libraryLoader = new McLibraryLoader(LIB_DIR_PATH);
    var libraryLoading = versionData.thenCompose(data -> {
      List<CompletableFuture<Void>> libDownloadFutures = new ArrayList<>();
      for (var library : data.libraries()) {
        var downloadFuture = libraryLoader.loadLibrary(library);
        libDownloadFutures.add(downloadFuture);
      }

      var futures = libDownloadFutures.toArray(CompletableFuture[]::new);
      return CompletableFuture.allOf(futures);
    });

    // combine the loading of the client and the loading of the required libraries
    var downloadFuture = CompletableFuture.allOf(versionTypeDownloads, libraryLoading);

    // remap the client jar
    var remapper = new JarRemapper(CLIENT_JAR_PATH, MAPPING_PATH);
    var remapOutput = downloadFuture.thenApply(CatchingFunction.asJavaUtil(ignored -> {
      remapper.remap(REMAPPED_JAR_PATH);
      return null;
    }, "Unable to remap client"));

    // get the game version from the jar
    var gameVersion = remapOutput
      .thenApply(CatchingFunction.asJavaUtil(ignored -> {
        var versionParser = new JarGameVersionParser(CLIENT_JAR_PATH);
        return versionParser.readGameVersion();
      }, "Unable to read game version of remapped jar"))
      .join();

    // collect the protocol information
    var protocolInfos = remapOutput
      .thenApply(CatchingFunction.asJavaUtil(ignored -> {
        var protocolInfoGenerator = new ProtocolInfoCollector(REMAPPED_JAR_PATH, libraryLoader.provideClassLoader());
        return protocolInfoGenerator.collectAllPacketInfos();
      }, "Unable to resolve packet information"))
      .join();

    // build the final markdown info from the information
    var markdownGenerator = new MarkdownGenerator();
    var protocolMarkdown = markdownGenerator.generateProtocolMarkdown(gameVersion, protocolInfos);

    // get the output path to dump the protocol to
    var outputFileName = cliNamespace.getString("output_file");
    var outputFilePath = Path.of(outputFileName);

    // format & write the final markdown file
    var markdownFormatter = new MarkdownFormatter(protocolMarkdown);
    markdownFormatter.writeTo(outputFilePath);

    // dump the version information into the requested file (if any)
    var versionFilePath = cliNamespace.getString("version_file");
    if (versionFilePath != null) {
      var versionDumper = new McVersionDumper(latestVersionOfType.join());
      versionDumper.writeTo(Path.of(versionFilePath));
    }
  }
}

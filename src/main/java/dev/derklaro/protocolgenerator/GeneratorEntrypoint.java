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

package dev.derklaro.protocolgenerator;

import dev.derklaro.protocolgenerator.cli.CliArgParser;
import dev.derklaro.protocolgenerator.gameversion.JarGameVersionParser;
import dev.derklaro.protocolgenerator.http.HttpFileDownloader;
import dev.derklaro.protocolgenerator.manifest.McManifestVersion;
import dev.derklaro.protocolgenerator.manifest.McManifestVersionFetcher;
import dev.derklaro.protocolgenerator.markdown.MarkdownFormatter;
import dev.derklaro.protocolgenerator.markdown.MarkdownGenerator;
import dev.derklaro.protocolgenerator.protocol.ProtocolInfoCollector;
import dev.derklaro.protocolgenerator.remap.JarRemapper;
import dev.derklaro.protocolgenerator.util.CatchingFunction;
import dev.derklaro.protocolgenerator.util.FileUtil;
import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import lombok.NonNull;

public final class GeneratorEntrypoint {

  private static final Path MAPPING_PATH = Path.of("mappings.tmp");
  private static final Path CLIENT_JAR_PATH = Path.of("client.tmp");

  public static void main(@NonNull String[] args) throws IOException {
    // parse the cli arguments
    var cliArgumentParser = new CliArgParser("ProtocolGenerator");
    GeneratorCLIArguments.registerDefaultArguments(cliArgumentParser);
    var cliNamespace = cliArgumentParser.parseCommandLine(args);

    // resolve all client versions
    var versionFetcher = new McManifestVersionFetcher();
    var clientVersions = versionFetcher.resolveMcVersions();

    // search the requested version
    McManifestVersion.VersionType versionType = cliNamespace.get("version_type");
    var latestVersionOfType = clientVersions
      .thenApply(versions -> versions.stream().filter(version -> version.type() == versionType).sorted().findFirst())
      .thenApply(optional -> {
        Supplier<RuntimeException> versionNotFoundExceptionSupplier =
          () -> new IllegalStateException("Unable to find a version with type " + versionType);
        return optional.orElseThrow(versionNotFoundExceptionSupplier);
      });

    // fetch the version data of the latest version
    var versionTypeDownloads = latestVersionOfType
      .thenCompose(versionFetcher::parseVersionData)
      .thenApply(data -> data.get("downloads").getAsJsonObject())
      .thenCompose(downloads -> {
        // extract the client downloads
        var clientUrl = downloads.get("client").getAsJsonObject().get("url").getAsString();
        var clientMappings = downloads.get("client_mappings").getAsJsonObject().get("url").getAsString();

        // download both files
        var clientDownload = HttpFileDownloader.downloadFile(clientUrl, CLIENT_JAR_PATH);
        var clientMappingsDownload = HttpFileDownloader.downloadFile(clientMappings, MAPPING_PATH);

        // combine both futures
        return CompletableFuture.allOf(clientDownload, clientMappingsDownload);
      });

    // remap the client jar
    var remapper = new JarRemapper(CLIENT_JAR_PATH, MAPPING_PATH);
    var remapOutput = versionTypeDownloads
      .thenApply(CatchingFunction.asJavaUtil(ignored -> remapper.remap(), "Unable to remap client"));

    // get the game version from the jar
    var gameVersion = remapOutput
      .thenApply(CatchingFunction.asJavaUtil(remappedJarPath -> {
        var versionParser = new JarGameVersionParser(remappedJarPath);
        return versionParser.readGameVersion();
      }, "Unable to read game version of remapped jar"))
      .join();

    // collect the protocol information
    var protocolInfos = remapOutput
      .thenApply(CatchingFunction.asJavaUtil(remappedJarPath -> {
        var protocolInfoGenerator = new ProtocolInfoCollector(remappedJarPath);
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

    // remove unneeded temp files
    FileUtil.deleteFileSilently(MAPPING_PATH);
    FileUtil.deleteFileSilently(CLIENT_JAR_PATH);
  }
}

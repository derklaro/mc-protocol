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

package dev.derklaro.protocolgenerator.markdown;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Table;
import dev.derklaro.protocolgenerator.gameversion.GameVersion;
import dev.derklaro.protocolgenerator.protocol.PacketClassInfo;
import dev.derklaro.protocolgenerator.reflect.TypeHelper;
import fun.mingshan.markdown4j.Markdown;
import fun.mingshan.markdown4j.type.block.StringBlock;
import fun.mingshan.markdown4j.type.block.TableBlock;
import fun.mingshan.markdown4j.type.block.TitleBlock;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lombok.NonNull;

public final class MarkdownGenerator {

  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

  private static final List<String> FIELD_TABLE_HEADERS = List.of(
    "Index",
    "Type Index",
    "Name",
    "Raw Type",
    "Full Type");
  private static final List<String> METADATA_TABLE_HEADERS = List.of(
    "Series",
    "Java Version",
    "Protocol Version",
    "World Version",
    "Pack Resource Version",
    "Pack Data Version",
    "Built at (UTC)");

  public @NonNull Markdown generateProtocolMarkdown(
    @NonNull GameVersion currentGameVersion,
    @NonNull Table<String, String, Collection<PacketClassInfo>> packetInfos
  ) {
    var markdownBuilder = Markdown.builder().name("protocol");

    // append the game version info
    this.appendGameVersion(markdownBuilder, currentGameVersion);

    // append each packet information
    this.dumpPacketInfos(markdownBuilder, packetInfos);

    // build the final markdown
    return markdownBuilder.build();
  }

  private void appendGameVersion(@NonNull Markdown.MarkdownBuilder markdownBuilder, @NonNull GameVersion gameVersion) {
    // append the top-level title
    var titleContent = "%s (%s)".formatted(gameVersion.name(), gameVersion.stable() ? "Stable" : "Snapshot");
    markdownBuilder.block(TitleBlock.builder().level(TitleBlock.Level.FIRST).content(titleContent).build());

    // metadata table row values
    List<String> metadataRowValues = List.of(
      gameVersion.series(),
      "%s %d".formatted(gameVersion.javaComponent(), gameVersion.javaVersion()),
      Integer.toString(gameVersion.protocolVersion()),
      Integer.toString(gameVersion.worldVersion()),
      Integer.toString(gameVersion.packVersion().resource()),
      Integer.toString(gameVersion.packVersion().data()),
      DATE_TIME_FORMATTER.format(gameVersion.buildTime()));

    // build the row block
    var tableRow = new TableBlock.TableRow();
    tableRow.setRows(metadataRowValues);

    // build and append the table
    var tableBlock = TableBlock.builder().titles(METADATA_TABLE_HEADERS).rows(List.of(tableRow)).build();
    markdownBuilder.block(tableBlock);
  }

  private void dumpPacketInfos(
    @NonNull Markdown.MarkdownBuilder markdownBuilder,
    @NonNull Table<String, String, Collection<PacketClassInfo>> packetInfos
  ) {
    var cellSet = packetInfos.cellSet();
    for (var cell : cellSet) {
      // normalize the name of the connection protocol and connection flow
      var normalizedPacketFlow = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, cell.getColumnKey());
      var normalizedConnectionProtocol = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, cell.getRowKey());

      // append the protocol and flow information
      var flowContent = "%s (%s)".formatted(normalizedConnectionProtocol, normalizedPacketFlow);
      markdownBuilder.block(TitleBlock.builder().level(TitleBlock.Level.SECOND).content(flowContent).build());

      // append the information of each packet
      for (var packetClassInfo : cell.getValue()) {
        // begin the packet info
        var titleContent = "0x%s - %s (%c ➔ %c)".formatted(
          "%02X".formatted(0xFF & packetClassInfo.packetId()),
          packetClassInfo.name(),
          packetClassInfo.source().charAt(0),
          packetClassInfo.target().charAt(0));
        markdownBuilder.block(TitleBlock.builder().level(TitleBlock.Level.FOURTH).content(titleContent).build());

        // check if the packet has fields to dump
        var fields = packetClassInfo.fields();
        if (fields.isEmpty()) {
          var noFieldContent = "Packet has no fields";
          markdownBuilder.block(StringBlock.builder().content(noFieldContent).build());
        } else {
          // keep track of the field index we're giving out
          var overallIndex = 0;
          Map<Class<?>, Integer> indexPerType = new HashMap<>();

          // dump all packet fields
          List<TableBlock.TableRow> fieldTableRows = new LinkedList<>();
          for (var field : fields) {
            // get the field index
            var overallFieldIndex = overallIndex++;
            var fieldTypeIndex = indexPerType.merge(field.rawType(), 1, Integer::sum);

            // get the nice information of the field type
            var niceRawType = TypeHelper.toPrettyString(field.rawType());
            var niceGenericType = TypeHelper.toPrettyString(field.genericType());

            // build the table row values
            List<String> rowValues = List.of(
              Integer.toString(overallFieldIndex), // no need to subtract, we start at 0
              Integer.toString(fieldTypeIndex - 1), // -1 here as this counter starts at 1
              field.name(),
              niceRawType,
              niceGenericType);

            // register the row
            var tableRow = new TableBlock.TableRow();
            tableRow.setRows(rowValues);
            fieldTableRows.add(tableRow);
          }

          // add the final table
          var table = TableBlock.builder().titles(FIELD_TABLE_HEADERS).rows(fieldTableRows).build();
          markdownBuilder.block(table);
        }

        // add a single black line below
        markdownBuilder.block(StringBlock.builder().content(" ").build());
      }
    }
  }
}

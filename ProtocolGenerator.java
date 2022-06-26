package dev.derklaro.protocol;

import com.google.common.base.CaseFormat;
import fun.mingshan.markdown4j.Markdown;
import fun.mingshan.markdown4j.Markdown.MarkdownBuilder;
import fun.mingshan.markdown4j.constant.FlagConstants;
import fun.mingshan.markdown4j.type.block.StringBlock;
import fun.mingshan.markdown4j.type.block.TableBlock;
import fun.mingshan.markdown4j.type.block.TableBlock.TableRow;
import fun.mingshan.markdown4j.type.block.TitleBlock;
import fun.mingshan.markdown4j.type.block.TitleBlock.Level;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import net.minecraft.SharedConstants;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.protocol.PacketFlow;

public class ProtocolGenerator {

	// pull changes from remote and create tag for new minecraft version:
	// git fetch && git pull && git tag -a 1.19-pre5 -m "1.19-pre5" && git push --tags

	// install remapped client jar into local repository:
	// mvn install:install-file -Dfile=client.jar -DgroupId=net.minecraft -DartifactId=client -Dversion=1.19-pre1 -Dpackaging=jar -DgeneratePom=true

	// launcher meta: https://piston-meta.mojang.com/mc/game/version_manifest_v2.json
	// remapper: https://github.com/FabricMC/Enigma

	public static void main(String[] args) throws IOException {
		// begin the markdown formatting
		MarkdownBuilder markdown = Markdown.builder()
				.name("protocol")
				.block(TitleBlock.builder()
						.level(Level.FIRST)
						.content(getNiceVersionTitle())
						.build());

		// dump all protocol packets
		for (ConnectionProtocol value : ConnectionProtocol.values()) {
			dumpPackets(value, markdown);
			markdown.block(StringBlock.builder().content("").build());
		}

		// finish up
		writeToFile(markdown.build());
	}

	private static void dumpPackets(ConnectionProtocol protocol, MarkdownBuilder target) {
		dumpPackets(protocol, PacketFlow.CLIENTBOUND, target);
		dumpPackets(protocol, PacketFlow.SERVERBOUND, target);
	}

	private static void dumpPackets(ConnectionProtocol protocol, PacketFlow packetFlow, MarkdownBuilder target) {
		// CLIENTBOUND -> Clientbound
		String normalizedFlowName = normalizeUpperUnderscore(packetFlow.name());
		String normalizedProtocolName = normalizeUpperUnderscore(protocol.name());

		// dump all packets, sorted by their id
		// example 1 -> Spawn Entity Player
		Map<Integer, Entry<String, Set<Field>>> sorted = new TreeMap<>();
		protocol
				.getPacketsByIds(packetFlow)
				.forEach((id, packet) -> sorted.put(
						id,
						Map.entry(
								String.join(" ", packet.getSimpleName().replaceFirst(normalizedFlowName, "").split("(?=\\p{Lu})")),
								getFields(packet))));

		// add the title followed by an empty line
		target
				.block(TitleBlock.builder()
						.level(Level.SECOND)
						.content("%s (%s -> %s)".formatted(
								normalizedProtocolName,
								normalizeUpperUnderscore(packetFlow.getOpposite().name()).replace("bound", ""),
								normalizedFlowName.replace("bound", "")))
						.build())
				.block(StringBlock.builder().content("").build());

		// dump the packet
		sorted.forEach((id, packet) -> {
			// title - packet id + name
			target.block(TitleBlock.builder()
					.level(Level.FOURTH)
					.content("0x%s - %s".formatted("%02X".formatted(0xFF & id), packet.getKey()))
					.build());

			// add the table with the field types
			target.block(TableBlock.builder()
					.titles(List.of("Type", "Name"))
					.rows(packet.getValue().stream()
							.map(field -> {
								// extract information
								String type = extractFriendlyTypeInfo(field.getGenericType());
								String name = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field.getName()).replace('_', ' ');

								// convert to table row
								return List.of(type, name);
							})
							.map(row -> {
								TableRow tableRow = new TableRow();
								tableRow.setRows(row);
								return tableRow;
							})
							.toList())
					.build());

			// add a single space below the table
			target.block(StringBlock.builder().content("").build());
		});

		// add one more empty line after the last packet
		target.block(StringBlock.builder().content("").build());
	}

	private static Set<Field> getFields(Class<?> clazz) {
		Set<Field> result = new HashSet<>();
		do {
			result.addAll(Arrays.stream(clazz.getDeclaredFields())
					.filter(field -> !Modifier.isStatic(field.getModifiers()))
					.toList());
		} while ((clazz = clazz.getSuperclass()) != Object.class);
		return result;
	}

	private static String normalizeUpperUnderscore(String in) {
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, in);
	}

	@SuppressWarnings("deprecation") // idk why mojang did that
	private static String getNiceVersionTitle() {
		if (SharedConstants.SNAPSHOT) {
			return "Snapshot %s (%s), Protocol %d (%d), Release Protocol: %d".formatted(
					SharedConstants.VERSION_STRING,
					SharedConstants.RELEASE_TARGET,
					SharedConstants.SNAPSHOT_NETWORK_PROTOCOL_VERSION,
					SharedConstants.getProtocolVersion(),
					SharedConstants.RELEASE_NETWORK_PROTOCOL_VERSION);
		} else {
			return "Release %s, Protocol %d".formatted(
					SharedConstants.VERSION_STRING,
					SharedConstants.getProtocolVersion());
		}
	}

	private static void writeToFile(Markdown markdown) throws IOException {
		StringBuilder builder = new StringBuilder();
		markdown.getBlocks().forEach(block -> builder
				.append(String.join("\n", block.toMd().split(FlagConstants.LINE_BREAK)))
				.append("\n"));

		Files.writeString(Path.of("protocol.md"), builder.toString());
	}

	private static String extractFriendlyTypeInfo(Type input) {
		// class / arrays first
		if (input instanceof Class<?> clz) {
			// simple name will end with [] if it is an array
			return clz.getSimpleName();
		}

		// parameterized types
		if (input instanceof ParameterizedType parameterized) {
			var friendlyOwner = extractFriendlyTypeInfo(parameterized.getRawType());
			var friendlyArguments = Arrays.stream(parameterized.getActualTypeArguments())
					.map(WebServer::extractFriendlyTypeInfo)
					.collect(Collectors.joining(", "));

			return String.format("%s\\<%s\\>", friendlyOwner, friendlyArguments);
		}

		// wildcard types
		if (input instanceof WildcardType wildcard) {
			var builder = new StringBuilder();

			// extract the bounds information
			var lowerBounds = wildcard.getLowerBounds();
			var upperBounds = wildcard.getUpperBounds();

			// check if there are any lower bounds
			if (lowerBounds.length > 0) {
				builder.append("? super ");
			} else if (upperBounds.length > 0 && !upperBounds[0].equals(Object.class)) {
				// has upper bounds (because the top-most entry is not object)
				lowerBounds = upperBounds;
				builder.append("? extends ");
			} else {
				// there are no bounds - just a general wildcard
				return "?";
			}

			// append the bound information
			builder.append(Arrays.stream(lowerBounds)
					.map(WebServer::extractFriendlyTypeInfo)
					.collect(Collectors.joining(" & ")));

			return builder.toString();
		}

		throw new UnsupportedOperationException("Unhandled type: " + input.getClass().getName());
	}
}

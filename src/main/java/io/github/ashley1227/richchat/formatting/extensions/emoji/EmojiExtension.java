package io.github.ashley1227.richchat.formatting.extensions.emoji;

import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataHolder;

/**
 * A flexmark Java extension to support the usage of @Code("||") as markdown syntax for spoilered text in Minecraft
 */
public class EmojiExtension implements Parser.ParserExtension {

	private EmojiExtension() {

	}

	@Override
	public void parserOptions(MutableDataHolder options) {

	}

	@Override
	public void extend(Parser.Builder parserBuilder) {
		parserBuilder.customDelimiterProcessor(new EmojiNode.SpoilerDelimiterProcessor());
	}

	public static EmojiExtension create() {
		return new EmojiExtension();
	}
}

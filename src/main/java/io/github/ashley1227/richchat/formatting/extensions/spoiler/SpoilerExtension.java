package io.github.ashley1227.richchat.formatting.extensions.spoiler;

import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataHolder;

/**
 * A flexmark Java extension to support the usage of @Code("||") as markdown syntax for spoilered text in Minecraft
 */
public class SpoilerExtension implements Parser.ParserExtension {

	private SpoilerExtension() {

	}

	@Override
	public void parserOptions(MutableDataHolder options) {

	}

	@Override
	public void extend(Parser.Builder parserBuilder) {
		parserBuilder.customDelimiterProcessor(new SpoilerNode.SpoilerDelimiterProcessor());
	}

	public static SpoilerExtension create() {
		return new SpoilerExtension();
	}
}

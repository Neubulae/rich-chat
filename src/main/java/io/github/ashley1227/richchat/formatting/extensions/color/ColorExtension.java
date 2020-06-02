package io.github.ashley1227.richchat.formatting.extensions.color;

import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataHolder;

/**
 * A flexmark Java extension to support the usage of @Code("&") as markdown syntax for coloring text in Minecraft
 */
public class ColorExtension implements Parser.ParserExtension {

	private ColorExtension() {
		super();
	}

	@Override
	public void parserOptions(MutableDataHolder options) {

	}

	@Override
	public void extend(Parser.Builder parserBuilder) {
//		parserBuilder.customDelimiterProcessor(new Colored.ColoredDelimiterProcessor());
		parserBuilder.customInlineParserExtensionFactory(new ColoredInlineParserExtension.Factory());
	}

	public static ColorExtension create() {
		return new ColorExtension();
	}
}

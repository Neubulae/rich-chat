package io.github.ashley1227.richchat.formatting.extensions.underline;

import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataHolder;

/**
 * A flexmark Java extension to support the usage of @Code("__") as markdown syntax for underlined text in Minecraft
 */
public class UnderlineExtension implements Parser.ParserExtension {

	private UnderlineExtension() {

	}

	@Override
	public void parserOptions(MutableDataHolder options) {

	}

	@Override
	public void extend(Parser.Builder parserBuilder) {
		parserBuilder.customDelimiterProcessor(new UnderlineNode.UnderlineDelimiterProcessor());
	}

	public static UnderlineExtension create() {
		return new UnderlineExtension();
	}
}

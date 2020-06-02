package io.github.ashley1227.richchat.formatting.extensions.mention;

import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataHolder;

/**
 * A flexmark Java extension to support the usage of @Code("@") as markdown syntax for mentioning people in Minecraft
 */
public class MentionExtension implements Parser.ParserExtension {

	private MentionExtension() {
		super();
	}

	@Override
	public void parserOptions(MutableDataHolder options) {

	}

	@Override
	public void extend(Parser.Builder parserBuilder) {
//		parserBuilder.customDelimiterProcessor(new Colored.ColoredDelimiterProcessor());
		parserBuilder.customInlineParserExtensionFactory(new MentionInlineParserExtension.Factory());
	}

	public static MentionExtension create() {
		return new MentionExtension();
	}
}

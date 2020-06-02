package io.github.ashley1227.richchat.formatting.extensions.obfuscation;

import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataHolder;

/**
 * A flexmark Java extension to support the usage of @Code("??") as markdown syntax for obfuscated text in Minecraft
 */
public class ObfuscatedExtension implements Parser.ParserExtension {

	private ObfuscatedExtension() {

	}

	@Override
	public void parserOptions(MutableDataHolder options) {

	}

	@Override
	public void extend(Parser.Builder parserBuilder) {
		parserBuilder.customDelimiterProcessor(new ObfuscatedNode.ObfuscatedDelimiterProcessor());
	}

	public static ObfuscatedExtension create() {
		return new ObfuscatedExtension();
	}
}

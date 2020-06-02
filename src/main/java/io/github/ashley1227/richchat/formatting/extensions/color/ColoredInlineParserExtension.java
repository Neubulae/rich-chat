package io.github.ashley1227.richchat.formatting.extensions.color;

import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.parser.InlineParserExtension;
import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
import com.vladsch.flexmark.parser.LightInlineParser;
import com.vladsch.flexmark.util.sequence.BasedSequence;

import java.util.Set;
import java.util.regex.Pattern;

public class ColoredInlineParserExtension implements InlineParserExtension {
	static Pattern PATTERN = Pattern.compile("&[a-zA-Z0-9_]+ ?");


	@Override
	public void finalizeDocument(InlineParser inlineParser) {

	}

	@Override
	public void finalizeBlock(InlineParser inlineParser) {

	}

	@Override
	public boolean parse(LightInlineParser inlineParser) {
		BasedSequence match = inlineParser.match(PATTERN);

		if (match != null) {
			BasedSequence name = match.midSequence(1).replace(" ", "");

			System.out.println(name);
			ColorNode colorNode = new ColorNode(name);
			inlineParser.flushTextNode();
			inlineParser.getBlock().appendChild(colorNode);

			return true;
		}

		return false;
	}
	public static class Factory implements InlineParserExtensionFactory {
		@Override
		public Set<Class<?>> getAfterDependents() {
			return null;
		}

		@Override
		public CharSequence getCharacters() {
			return "&";
		}

		@Override
		public Set<Class<?>> getBeforeDependents() {
			return null;
		}

		@Override
		public InlineParserExtension apply(LightInlineParser lightInlineParser) {
			return new ColoredInlineParserExtension();
		}

		@Override
		public boolean affectsGlobalScope() {
			return false;
		}
	}
}

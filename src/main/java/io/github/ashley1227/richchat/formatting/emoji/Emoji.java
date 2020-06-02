package io.github.ashley1227.richchat.formatting.emoji;

import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Emoji {
	private String key;
	private List<String> aliases;

	private final String name;
	private String prefix;
	private String suffix;

	public Emoji(String name, String key) {
		this.name = name;
		this.key = key;

		this.aliases = new ArrayList<>();
		this.aliases.add(key);

		this.prefix = "";
		this.suffix = Formatting.RESET.toString();
	}
	public String getKey() {
		return key;
	}
	public List<String> getAliases() {
		return aliases;
	}

	public Emoji addAliases(String... aliases) {
		this.aliases.addAll(Arrays.asList(aliases));
		return this;
	}

	public Emoji addPrefixes(String... prefixes) {
		StringBuilder builder = new StringBuilder(this.prefix);
		for (String prefix : prefixes)
			builder.append(prefix);
		this.prefix = builder.toString();
		return this;
	}

	public Emoji addPrefixes(Formatting... prefixes) {
		StringBuilder builder = new StringBuilder(this.prefix);
		for (Formatting formatting : prefixes)
			builder.append(formatting.toString());
		this.prefix = builder.toString();
		return this;
	}

	public Emoji addSuffixes(String... suffixes) {
		StringBuilder builder = new StringBuilder(this.suffix);
		for (String suffix : suffixes)
			builder.append(suffix);
		this.suffix = builder.toString();
		return this;
	}

	public Emoji addSuffixes(Formatting... suffixes) {
		StringBuilder builder = new StringBuilder(this.suffix);
		for (Formatting formatting : suffixes)
			builder.append(formatting.toString());
		this.suffix = builder.toString();
		return this;
	}

	public String getName() {
		return name;
	}

	public String formatted() {
		return this.prefix + this.name + this.suffix;
	}

	@Override
	public String toString() {
		return this.formatted();
	}
}

package io.github.ashley1227.richchat.formatting.color;

import java.util.ArrayList;
import java.util.Iterator;

public class ColorCode implements Iterable<String> {

	private String key;
	private String formatted;

	private ArrayList<String> aliases;

	public ColorCode(String key, String formatted) {
		this.key = key;
		this.formatted = formatted;

		this.aliases = new ArrayList<>();
		this.aliases.add(key);
	}
	public ArrayList<String> getAliases() {
		return aliases;
	}
	public ColorCode addAlias(String alias) {
		this.aliases.add(alias);
		return this;
	}

	public String getKey() {
		return this.key;
	}

	public String formatted() {
		return this.formatted;
	}

	public String toString() {
		return this.getKey();
	}

	@Override
	public Iterator<String> iterator() {
		return aliases.iterator();
	}
}

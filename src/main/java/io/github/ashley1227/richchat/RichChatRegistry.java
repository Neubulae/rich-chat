package io.github.ashley1227.richchat;

import io.github.ashley1227.richchat.formatting.color.ColorCode;
import io.github.ashley1227.richchat.formatting.emoji.Emoji;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class RichChatRegistry extends Registry<Emoji> {
	public static final Registry<Emoji> EMOJIS = create(new Identifier(RichChatMod.MODID, "emoji"));
	public static final Registry<ColorCode> COLOR_CODES = create(new Identifier(RichChatMod.MODID, "color_codes"));

	private static <T> Registry<T> create(Identifier identifier) {
		return putDefaultEntry(identifier, new SimpleRegistry());
	}

	private static <T> DefaultedRegistry<T> create(Identifier identifier, String string2) {
		return (DefaultedRegistry) putDefaultEntry(identifier, new DefaultedRegistry(string2));
	}

	private static <T, R extends MutableRegistry<T>> R putDefaultEntry(Identifier identifier, R mutableRegistry) {
		return (R) Registry.REGISTRIES.add(identifier, mutableRegistry);
	}
}

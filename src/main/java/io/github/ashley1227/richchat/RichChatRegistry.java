package io.github.ashley1227.richchat;

import com.mojang.serialization.Lifecycle;
import io.github.ashley1227.richchat.formatting.color.ColorCode;
import io.github.ashley1227.richchat.formatting.emoji.Emoji;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class RichChatRegistry extends Registry<Emoji> {
	public static final Registry<Emoji> EMOJIS = create(new Identifier(RichChatMod.MODID, "emoji"));
	public static final Registry<ColorCode> COLOR_CODES = create(new Identifier(RichChatMod.MODID, "color_codes"));

	protected RichChatRegistry(RegistryKey<? extends Registry<Emoji>> key, Lifecycle lifecycle) {
		super(key, lifecycle);
	}

	private static <T> Registry<T> create(Identifier identifier) {
		return putDefaultEntry(identifier, new SimpleRegistry<>(RegistryKey.ofRegistry(identifier), Lifecycle.stable()));
	}

	private static <T> DefaultedRegistry<T> create(Identifier identifier, String string2) {
		return putDefaultEntry(identifier, new DefaultedRegistry<>(string2, RegistryKey.ofRegistry(identifier), Lifecycle.stable()));
	}

	private static <T, R extends MutableRegistry<T>> R putDefaultEntry(Identifier identifier, R mutableRegistry) {
		return (R) ((MutableRegistry) Registry.REGISTRIES).add(RegistryKey.ofRegistry(identifier), mutableRegistry, Lifecycle.stable());
	}
}

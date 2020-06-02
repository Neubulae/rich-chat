package io.github.ashley1227.richchat.formatting.emoji;

import io.github.ashley1227.richchat.RichChatRegistry;
import net.minecraft.util.registry.Registry;

import static net.minecraft.util.Formatting.*;

public class Emojis {

	public static Emoji HEART = new Emoji("❤", "heart").addPrefixes(RED);
	public static Emoji FLOWER = new Emoji("✿", "flower").addPrefixes(WHITE);
	public static Emoji FLOWER2 = new Emoji("❀", "flower2").addPrefixes(WHITE);

	public static Emoji NO = new Emoji("✘", "no").addAliases("x", "cross").addPrefixes(DARK_RED);
	public static Emoji YES = new Emoji("✔", "yes").addAliases("check", "check_mark").addPrefixes(DARK_GREEN);


	public static Emoji SMILE = new Emoji("☺", "smile").addAliases("smiley");

	public static Emoji MARS = new Emoji("♂", "mars").addAliases("male").addPrefixes(AQUA);
	public static Emoji VENUS = new Emoji("♀", "venus").addAliases("female").addPrefixes(LIGHT_PURPLE);


	public static Emoji NUMBER = new Emoji("№", "number");

	public static Emoji INVALID = new Emoji("[?]", "");


	public static void register() {
		Registry.register(RichChatRegistry.EMOJIS, "rich_chat:heart", HEART);
		Registry.register(RichChatRegistry.EMOJIS, "rich_chat:flower", FLOWER);
		Registry.register(RichChatRegistry.EMOJIS, "rich_chat:flower2", FLOWER2);

		Registry.register(RichChatRegistry.EMOJIS, "rich_chat:no", NO);
		Registry.register(RichChatRegistry.EMOJIS, "rich_chat:yes", YES);

		Registry.register(RichChatRegistry.EMOJIS, "rich_chat:smile", SMILE);

		Registry.register(RichChatRegistry.EMOJIS, "rich_chat:mars", MARS);
		Registry.register(RichChatRegistry.EMOJIS, "rich_chat:venus", VENUS);

		Registry.register(RichChatRegistry.EMOJIS, "rich_chat:number", NUMBER);
	}

	public static Emoji getEmoji(String str) {
		for (Emoji emoji : RichChatRegistry.EMOJIS) {
			for (String alias : emoji.getAliases()) {
				if (alias.equals(str))
					return emoji;
			}
		}
		return INVALID;
	}
}

package io.github.ashley1227.richchat.command.commands;

import com.mojang.brigadier.CommandDispatcher;
import io.github.ashley1227.richchat.RichChatRegistry;
import io.github.ashley1227.richchat.formatting.emoji.Emoji;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;

public class EmojisCommand {
	private static ArrayList<Text> feedback;

	public static void reload() {
		feedback = new ArrayList<>();
		regenText();
	}
	protected static void regenText() {
		feedback.add(new LiteralText("颜色").formatted(Formatting.UNDERLINE));
		feedback.add(new LiteralText("§o使用/formatting或者/emojis以查看文本格式和可用表情！"));
		feedback.add(new LiteralText(""));
		for(Emoji e : RichChatRegistry.EMOJIS) {
			LiteralText t = new LiteralText("    ");
			t.append(":" + e.getKey() + ":");
			t.append(" (");
			for(int i = 0; i < e.getAliases().size() - 1; i++) {
				t.append(e.getAliases().get(i));
				t.append(", ");
			}
			t.append(e.getAliases().get(e.getAliases().size() - 1));
			t.append("): ");
			t.append(e.formatted());
			feedback.add(t);
		}
	}
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("emojis")
				.executes(ctx -> {
					for(Text t : feedback) {
						ctx.getSource().sendFeedback(t, false);
					}
					return 1;
				})
		);

	}
}

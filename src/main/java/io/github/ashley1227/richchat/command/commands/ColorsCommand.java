package io.github.ashley1227.richchat.command.commands;

import com.mojang.brigadier.CommandDispatcher;
import io.github.ashley1227.richchat.RichChatRegistry;
import io.github.ashley1227.richchat.formatting.color.ColorCode;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;

public class ColorsCommand {
	private static ArrayList<Text> feedback = new ArrayList<>();
	public static void reload() {
		feedback = new ArrayList<>();
		regenText();
	}
	protected static void regenText() {
		feedback.add(new LiteralText("颜色").formatted(Formatting.UNDERLINE));
		feedback.add(new LiteralText("§o使用/formatting或者/emojis以查看文本格式和可用表情！"));
		feedback.add(new LiteralText(""));
		for(ColorCode c : RichChatRegistry.COLOR_CODES) {
			LiteralText t = new LiteralText("    ");
			t.append("&" + c.getKey());
			t.append(" (");
			for(int i = 0; i < c.getAliases().size() - 1; i++) {
				t.append(c.getAliases().get(i));
				t.append(", ");
			}
			t.append(c.getAliases().get(c.getAliases().size() - 1));
			t.append("): ");
			t.append(c.formatted() + c.getKey());
			feedback.add(t);
		}
	}
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("colors")
			.executes(ctx -> {
				for(Text t : feedback) {
					ctx.getSource().sendFeedback(t, false);
				}
				return 1;
			})
		);

	}
}

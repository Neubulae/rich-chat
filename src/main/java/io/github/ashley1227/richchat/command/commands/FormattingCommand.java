package io.github.ashley1227.richchat.command.commands;

import com.mojang.brigadier.CommandDispatcher;
import io.github.ashley1227.richchat.formatting.Formatter;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class FormattingCommand {
	private static Formatter formatter = new Formatter();

	private static Text[] feedback = {
			new LiteralText("文本格式").formatted(Formatting.UNDERLINE),
			new LiteralText("§o使用/colors或/emojis以查看可文本颜色与可用表情"),
			new LiteralText(""),
			new LiteralText("    **文字**: §l文字"),
			new LiteralText("    *文字*: §o文字"),
			new LiteralText("    ***文字***: §o§l文字"),
			new LiteralText("    __文字__: §n文字"),
			new LiteralText("    ~~文字~~: §m文字"),
			new LiteralText("    ??文字??: §k文字"),
			new LiteralText("    ||文字||: ").append(formatter.format("||文字||").get(0)).append(" <- 用鼠标悬浮上去看看")
	};
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("formatting")
			.executes(ctx -> {
				for(Text t : feedback) {
					ctx.getSource().sendFeedback(t, false);
				}
				return 1;
			})
		);

	}
}

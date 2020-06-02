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
			new LiteralText("Formatting").formatted(Formatting.UNDERLINE),
			new LiteralText("§oTry /colors or /emojis to see a list of colors or emojis"),
			new LiteralText(""),
			new LiteralText("    **text**: §ltext"),
			new LiteralText("    *text*: §otext"),
			new LiteralText("    ***text***: §o§ltext"),
			new LiteralText("    __text__: §ntext"),
			new LiteralText("    ~~text~~: §mtext"),
			new LiteralText("    ??text??: §ktext"),
			new LiteralText("    ||text||: ").append(formatter.format("||text||").get(0)).append(" <- Hover")
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

package io.github.ashley1227.richchat.command;

import com.mojang.brigadier.CommandDispatcher;
import io.github.ashley1227.richchat.command.commands.ColorsCommand;
import io.github.ashley1227.richchat.command.commands.EmojisCommand;
import io.github.ashley1227.richchat.command.commands.FormattingCommand;
import net.minecraft.server.command.ServerCommandSource;

public class RichChatCommands {
	public static void register(CommandDispatcher<ServerCommandSource> serverCommandSourceCommandDispatcher, boolean b) {
		FormattingCommand.register(serverCommandSourceCommandDispatcher);
		ColorsCommand.reload();
		ColorsCommand.register(serverCommandSourceCommandDispatcher);
		EmojisCommand.reload();
		EmojisCommand.register(serverCommandSourceCommandDispatcher);
	}
}

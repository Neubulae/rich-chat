package io.github.ashley1227.richchat;

import io.github.ashley1227.richchat.command.RichChatCommands;
import io.github.ashley1227.richchat.formatting.color.ColorCodes;
import io.github.ashley1227.richchat.formatting.emoji.Emojis;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class RichChatMod implements ModInitializer {

	public static String MODID = "rich_chat";

	@Override
	public void onInitialize() {
		Emojis.register();
		ColorCodes.register();

		CommandRegistrationCallback.EVENT.register(RichChatCommands::register);
	}
	public static void playNotificationSound(MinecraftServer server, String string) {
		ServerPlayerEntity player = server.getPlayerManager().getPlayer(string);
		if(player == null)
			return;
		playNotificationSound(player);
	}
	public static void playNotificationSound(ServerPlayerEntity player) {
		player.playSound(SoundEvents.BLOCK_NOTE_BLOCK_XYLOPHONE, SoundCategory.MASTER, 2, 1);
	}
}

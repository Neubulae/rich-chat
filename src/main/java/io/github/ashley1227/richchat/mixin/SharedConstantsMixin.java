package io.github.ashley1227.richchat.mixin;

import net.minecraft.SharedConstants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SharedConstants.class)
public abstract class SharedConstantsMixin {
	@Inject(
			at = @At("HEAD"),
			method = "Lnet/minecraft/SharedConstants;isValidChar(C)Z",
			cancellable = true
	)
	private static void isValidChar(char ch, CallbackInfoReturnable<Boolean> info) {
		if (ch == 167)
			info.setReturnValue(true);
	}
}

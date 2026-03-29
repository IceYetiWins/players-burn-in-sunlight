package com.iceyetiwins.playersburninsunlight.mixin;

import com.iceyetiwins.playersburninsunlight.ModConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.iceyetiwins.playersburninsunlight.OnPlayerUpdate;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	@Inject(at = @At("RETURN"), method = "tick")
	private void init(CallbackInfo ci) {
		LivingEntity livingEntity = (LivingEntity) (Object) this;
		if (livingEntity instanceof Player player && ModConfig.enabled) {
			OnPlayerUpdate.onPlayerUpdate(player);
		}
	}
}
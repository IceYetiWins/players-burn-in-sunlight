package com.iceyetiwins.playersburninsunlight.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.iceyetiwins.playersburninsunlight.OnPlayerUpdate;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	@Inject(at = @At("RETURN"), method = "tick")
	private void init(CallbackInfo ci) {
		LivingEntity livingEntity = (LivingEntity) (Object) this;
		if (livingEntity instanceof PlayerEntity player) {
			OnPlayerUpdate.onPlayerUpdate(player);
		}
	}
}
package com.iceyetiwins.playersburninsunlight;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

public class OnPlayerUpdate {
	public static void onPlayerUpdate(PlayerEntity player){
		
		BlockPos blockPos = BlockPos.ofFloored(player.getX(), player.getEyeY(), player.getZ());

		long currentTime = player.getWorld().getTimeOfDay();

		while (currentTime >= 24000) {
			currentTime -= 24000;
		}

		if (currentTime < 12542 || currentTime > 23460) {
			if (player.getWorld().isSkyVisible(blockPos) && !player.isWet() && !player.inPowderSnow && !player.wasInPowderSnow && !player.isSleeping()){
				player.setOnFireFor(8);
			}
		}
	}
}
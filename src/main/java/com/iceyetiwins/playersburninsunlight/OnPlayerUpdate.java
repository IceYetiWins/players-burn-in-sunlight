package com.iceyetiwins.playersburninsunlight;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.Biome.Precipitation;

public class OnPlayerUpdate {
	public static void onPlayerUpdate(PlayerEntity player){
		
		BlockPos pos = BlockPos.ofFloored(player.getX(), player.getEyeY(), player.getZ());
		
		Biome biome = player.getWorld().getBiome(pos).value();
		boolean isRainingOrSnowing = false;

		long currentTime = player.getWorld().getTimeOfDay();

		while (currentTime >= 24000) {
			currentTime -= 24000;
		}
		
		if (player.getWorld().isRaining() && ((biome.getPrecipitation(pos) == Precipitation.RAIN) || (biome.getPrecipitation(pos) == Precipitation.SNOW))){
			isRainingOrSnowing = true;
		} else {
			isRainingOrSnowing = false;
		}
		
		if ((currentTime < 12542 || currentTime > 23460) && player.getWorld().isSkyVisible(pos) && !player.isWet() && !isRainingOrSnowing && !player.inPowderSnow && !player.wasInPowderSnow && !player.isSleeping()){
			player.setOnFireFor(8);
		}
	}
}
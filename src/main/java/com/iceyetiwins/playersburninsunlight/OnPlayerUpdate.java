package com.iceyetiwins.playersburninsunlight;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.Biome.Precipitation;

public class OnPlayerUpdate {
    public static void onPlayerUpdate(PlayerEntity player){

        BlockPos pos = BlockPos.ofFloored(player.getX(), player.getEyeY(), player.getZ());

        Biome biome = player.getEntityWorld().getBiome(pos).value();
        boolean isRainingOrSnowing = false;

        long currentTime = player.getEntityWorld().getTimeOfDay();

        while (currentTime >= 24000) {
            currentTime -= 24000;
        }

        isRainingOrSnowing = player.getEntityWorld().isRaining() && ((biome.getPrecipitation(pos, player.getEntityWorld().getSeaLevel()) == Precipitation.RAIN) || (biome.getPrecipitation(pos, player.getEntityWorld().getSeaLevel()) == Precipitation.SNOW));

        if ((currentTime < 12542 || currentTime > 23460) && player.getEntityWorld().isSkyVisible(pos) && !player.isTouchingWaterOrRain() && !isRainingOrSnowing && !player.inPowderSnow && !player.wasInPowderSnow && !player.isSleeping()){
            player.setOnFireFor(8);
        }
    }
}
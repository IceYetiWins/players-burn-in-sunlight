package com.iceyetiwins.playersburninsunlight;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.Precipitation;

public class OnPlayerUpdate {
    public static void onPlayerUpdate(Player player){

        BlockPos pos = BlockPos.containing(player.getX(), player.getEyeY(), player.getZ());

        Biome biome = player.level().getBiome(pos).value();
        boolean isRainingOrSnowing = false;

        long currentTime = player.level().getOverworldClockTime();

        while (currentTime >= 24000) {
            currentTime -= 24000;
        }

        isRainingOrSnowing = player.level().isRaining() && ((biome.getPrecipitationAt(pos, player.level().getSeaLevel()) == Precipitation.RAIN) || (biome.getPrecipitationAt(pos, player.level().getSeaLevel()) == Precipitation.SNOW));

        if ((currentTime < 12542 || currentTime > 23460) && player.level().canSeeSky(pos) && !player.isInWaterOrRain() && !isRainingOrSnowing && !player.isInPowderSnow && !player.wasInPowderSnow && !player.isSleeping()){
            player.igniteForSeconds(8);
        }
    }
}
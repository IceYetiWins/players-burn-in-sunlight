package com.iceyetiwins.playersburninsunlight;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;
import net.minecraft.commands.execution.CustomCommandExecutor;
import net.minecraft.network.chat.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayersBurnInSunlight implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("players-burn-in-sunlight");

	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(Commands.literal("toggleburninsunlight")
					.executes(context -> {
						ModConfig.enabled = !ModConfig.enabled;
						context.getSource().sendSuccess(() -> Component.literal("Burning in sunlight enabled: " + ModConfig.enabled), true);
						return CustomCommandExecutor.CommandAdapter.SINGLE_SUCCESS;
					})
			);
		});
	}
}
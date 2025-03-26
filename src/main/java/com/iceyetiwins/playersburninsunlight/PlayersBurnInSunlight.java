package com.iceyetiwins.playersburninsunlight;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.ControlFlowAware;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayersBurnInSunlight implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("players-burn-in-sunlight");

	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(CommandManager.literal("toggleburninsunlight")
					.executes(context -> {
						ModConfig.enabled = !ModConfig.enabled;
						context.getSource().sendFeedback(() -> Text.literal("Burning in sunlight enabled: " + ModConfig.enabled), true);
						return ControlFlowAware.Command.SINGLE_SUCCESS;
					})
			);
		});
	}
}
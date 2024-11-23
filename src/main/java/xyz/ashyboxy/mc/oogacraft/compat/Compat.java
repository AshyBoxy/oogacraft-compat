package xyz.ashyboxy.mc.oogacraft.compat;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Compat implements ModInitializer {
	public static final String MOD_ID = "oogacraft-compat";

	public static final Logger LOGGER = LoggerFactory.getLogger("Oogacraft Compat");

	@Override
	public void onInitialize() {
		LOGGER.info("Giving British Steve Headpats...");
	}
}
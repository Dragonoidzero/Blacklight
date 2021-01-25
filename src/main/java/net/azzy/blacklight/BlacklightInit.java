package net.azzy.blacklight;

import net.azzy.blacklight.block.BlacklightBlocks;
import net.azzy.blacklight.fluid.BlacklightFluids;
import net.azzy.blacklight.item.BlacklightItems;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BlacklightInit implements ModInitializer {

	public static final String MODID = "blacklight";
	public static final Logger BLACKLIGHT_LOG = LogManager.getLogger(MODID);

	@Override
	public void onInitialize() {
		BlacklightItems.init();
		BlacklightFluids.init();
		BlacklightBlocks.init();
	}
}

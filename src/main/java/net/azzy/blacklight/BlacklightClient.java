package net.azzy.blacklight;

import net.azzy.blacklight.fluid.FluidRenderInit;
import net.fabricmc.api.ClientModInitializer;

public class BlacklightClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FluidRenderInit.init();
    }
}

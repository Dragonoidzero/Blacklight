package net.azzy.blacklight.fluid;

import net.azzy.blacklight.BlacklightInit;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlacklightFluids {

    public static void init(){}

    public static final Fluid STILL_WORLD_BLOOD = register("primeval_blood", new WorldBloodFluid.Still());
    public static final Fluid FLOWING_WORLD_BLOOD = register("primeval_blood_flowing", new WorldBloodFluid.Flowing());

    private static Fluid register(String name, Fluid fluid) {
        return Registry.register(Registry.FLUID, new Identifier(BlacklightInit.MODID, name), fluid);
    }
}

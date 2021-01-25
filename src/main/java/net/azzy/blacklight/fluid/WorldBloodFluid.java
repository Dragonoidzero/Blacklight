package net.azzy.blacklight.fluid;

import net.azzy.blacklight.block.BlacklightBlocks;
import net.azzy.blacklight.item.BlacklightItems;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.world.WorldView;

public abstract class WorldBloodFluid extends BaseFluid {

    @Override
    public Fluid getStill()
    {
        return BlacklightFluids.STILL_WORLD_BLOOD;
    }

    @Override
    public Fluid getFlowing()
    {
        return BlacklightFluids.FLOWING_WORLD_BLOOD;
    }

    @Override
    public Item getBucketItem()
    {
        return BlacklightItems.WORLD_BLOOD_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState)
    {
        // method_15741 converts the LEVEL_1_8 of the fluid state to the LEVEL_15 the fluid block uses
        return BlacklightBlocks.WORLD_BLOOD_BLOCK.getDefaultState().with(Properties.LEVEL_15, method_15741(fluidState));
    }

    @Override
    public int getTickRate(WorldView worldView) {
        return 8;
    }

    public static class Flowing extends WorldBloodFluid
    {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder)
        {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState)
        {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState)
        {
            return false;
        }
    }

    public static class Still extends WorldBloodFluid
    {
        @Override
        public int getLevel(FluidState fluidState)
        {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState)
        {
            return true;
        }
    }
}

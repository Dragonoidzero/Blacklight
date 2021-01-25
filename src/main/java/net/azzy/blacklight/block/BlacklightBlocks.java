package net.azzy.blacklight.block;

import net.azzy.blacklight.BlacklightInit;
import net.azzy.blacklight.fluid.BlacklightFluids;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class BlacklightBlocks {

    public static void init(){}

    public static final Block WORLD_BLOOD_BLOCK = registerBlock("primeval_blood", new FluidBlock((FlowableFluid) BlacklightFluids.STILL_WORLD_BLOOD, FabricBlockSettings.copyOf(Blocks.WATER).postProcess((state, world, pos) -> true).emissiveLighting((state, world, pos) -> true)){});

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(BlacklightInit.MODID, name), block);
    }

    private  static <T extends BlockEntity> BlockEntityType<T> registerEntity(String name, FabricBlockEntityTypeBuilder.Factory<T> factory, Block... blocks) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(BlacklightInit.MODID, name), FabricBlockEntityTypeBuilder.create(factory, blocks).build());
    }
}

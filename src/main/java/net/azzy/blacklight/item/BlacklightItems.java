package net.azzy.blacklight.item;

import net.azzy.blacklight.BlacklightInit;
import net.azzy.blacklight.fluid.BlacklightFluids;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlacklightItems {

    public static void init(){}

    public static final Item WORLD_BLOOD_BUCKET = register("primeval_blood_bucket", new BucketItem(BlacklightFluids.STILL_WORLD_BLOOD, bucketSettings()));

    private static FabricItemSettings bucketSettings() {
        return new FabricItemSettings().maxCount(1).recipeRemainder(Items.BUCKET);
    }

    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(BlacklightInit.MODID, name), item);
    }
}

package net.evilcult.scenic.registry;

import net.evilcult.scenic.Scenic;
import net.evilcult.scenic.ScenicItemGroups;
import net.evilcult.scenic.utils.VanillaUtils;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Scenic Items
 * Scenic-Mod - net.evilcult.scenic.registry.AestheticsItems
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-1.0.2
 * @since 2020-04-25
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ScenicItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Scenic.MODID);

    public static final RegistryObject<Item> GRASS_TUFT = ITEMS.register("grass_tuft",
            () -> new BlockItem(ScenicBlocks.GRASS_TUFT.get(), defaultProperties()));

    public static final RegistryObject<Item> GRASS_SHORT = ITEMS.register("grass_short",
            () -> new BlockItem(ScenicBlocks.GRASS_SHORT.get(), defaultProperties()));

    public static final RegistryObject<Item> ROOTS = ITEMS.register("roots",
            () -> new BlockItem(ScenicBlocks.ROOTS.get(), defaultProperties()));

    public static final RegistryObject<Item> ROOTS_LONG = ITEMS.register("roots_long",
            () -> new BlockItem(ScenicBlocks.ROOTS_LONG.get(), defaultProperties()));

    public static final RegistryObject<Item> ROOTS_GROUND = ITEMS.register("roots_ground",
            () -> new BlockItem(ScenicBlocks.ROOTS_GROUND.get(), defaultProperties()));

    public static final RegistryObject<Item> ROCKY_DIRT = ITEMS.register("rocky_dirt",
            () -> new BlockItem(ScenicBlocks.ROCKY_DIRT.get(), defaultProperties()));

    public static final RegistryObject<Item> MOSSY_GRAVEL = ITEMS.register("mossy_gravel",
            () -> new BlockItem(ScenicBlocks.MOSSY_GRAVEL.get(), defaultProperties()));

    public static final RegistryObject<Item> MOSSY_ROCKY_DIRT = ITEMS.register("mossy_rocky_dirt",
            () -> new BlockItem(ScenicBlocks.MOSSY_ROCKY_DIRT.get(), defaultProperties()));

    public static final RegistryObject<Item> CRACKED_BRICKS = ITEMS.register("cracked_bricks",
            () -> new BlockItem(ScenicBlocks.CRACKED_BRICKS.get(), defaultProperties()));

    public static final RegistryObject<Item> MOSSY_BRICKS = ITEMS.register("mossy_bricks",
            () -> new BlockItem(ScenicBlocks.MOSSY_BRICKS.get(), defaultProperties()));

    public static final RegistryObject<Item> TREASURE_POT = ITEMS.register("treasure_pot",
            () -> new BlockItem(ScenicBlocks.TREASURE_POT.get(), defaultProperties()));

    public static final RegistryObject<Item> ROCK = ITEMS.register("rock",
            () -> new BlockNamedItem(ScenicBlocks.ROCK_PILE.get(), defaultProperties()));

    public static final RegistryObject<Item> STALAGMITE = ITEMS.register("stalagmite",
            () -> new BlockItem(ScenicBlocks.STALAGMITE.get(), defaultProperties()));

    public static final RegistryObject<Item> STALACTITE = ITEMS.register("stalactite",
            () -> new BlockItem(ScenicBlocks.STALACTITE.get(), defaultProperties()));

    public static final RegistryObject<Item> FISH_BONES = ITEMS.register("fish_bones",
            () -> new BlockItem(ScenicBlocks.FISH_BONES.get(), defaultProperties()));


    public static final RegistryObject<Item> WHITE_STAINED_GLASS_LANTERN = ITEMS.register("white_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.WHITE_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static final RegistryObject<Item> ORANGE_STAINED_GLASS_LANTERN = ITEMS.register("orange_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.ORANGE_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static final RegistryObject<Item> MAGENTA_STAINED_GLASS_LANTERN = ITEMS.register("magenta_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.MAGENTA_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static final RegistryObject<Item> LIGHT_BLUE_STAINED_GLASS_LANTERN = ITEMS.register("light_blue_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.LIGHT_BLUE_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static final RegistryObject<Item> YELLOW_STAINED_GLASS_LANTERN = ITEMS.register("yellow_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.YELLOW_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static final RegistryObject<Item> LIME_STAINED_GLASS_LANTERN = ITEMS.register("lime_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.LIME_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static final RegistryObject<Item> PINK_STAINED_GLASS_LANTERN = ITEMS.register("pink_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.PINK_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static final RegistryObject<Item> GRAY_STAINED_GLASS_LANTERN = ITEMS.register("gray_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.GRAY_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static final RegistryObject<Item> LIGHT_GRAY_STAINED_GLASS_LANTERN = ITEMS.register("light_gray_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.LIGHT_GRAY_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static final RegistryObject<Item> CYAN_STAINED_GLASS_LANTERN = ITEMS.register("cyan_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.CYAN_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static final RegistryObject<Item> PURPLE_STAINED_GLASS_LANTERN = ITEMS.register("purple_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.PURPLE_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static final RegistryObject<Item> BLUE_STAINED_GLASS_LANTERN = ITEMS.register("blue_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.BLUE_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static final RegistryObject<Item> BROWN_STAINED_GLASS_LANTERN = ITEMS.register("brown_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.BROWN_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static final RegistryObject<Item> GREEN_STAINED_GLASS_LANTERN = ITEMS.register("green_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.GREEN_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static final RegistryObject<Item> RED_STAINED_GLASS_LANTERN = ITEMS.register("red_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.RED_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static final RegistryObject<Item> BLACK_STAINED_GLASS_LANTERN = ITEMS.register("black_stained_glass_lantern",
            () -> new BlockItem(ScenicBlocks.BLACK_STAINED_GLASS_LANTERN.get(), defaultProperties()));

    public static Item.Properties defaultProperties() {
        return new Item.Properties().group(ScenicItemGroups.MAIN);
    }

    public static void registerCompostables() {
        VanillaUtils.registerCompostable(GRASS_TUFT.get(), 0.3f);
        VanillaUtils.registerCompostable(GRASS_SHORT.get(), 0.2f);
        VanillaUtils.registerCompostable(ROOTS.get(), 0.3f);
        VanillaUtils.registerCompostable(ROOTS_LONG.get(), 0.5f);
        VanillaUtils.registerCompostable(ROOTS_GROUND.get(), 0.3f);
    }
}
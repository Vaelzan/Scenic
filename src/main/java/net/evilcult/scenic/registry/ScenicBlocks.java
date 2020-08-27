package net.evilcult.scenic.registry;

import net.evilcult.scenic.Scenic;
import net.evilcult.scenic.block.*;
import net.evilcult.scenic.utils.VanillaUtils;
import net.minecraft.block.Block;
import net.minecraft.block.GravelBlock;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Scenic Blocks
 * Scenic-Mod - net.evilcult.scenic.registry.AestheticsBlocks
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-1.0.3
 * @since 2020-04-25
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ScenicBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Scenic.MODID);

    public static final RegistryObject<Block> GRASS_TUFT = BLOCKS.register("grass_tuft",
            () -> new FoliageBlock(Block.Properties.create(Material.TALL_PLANTS)
                    .doesNotBlockMovement()
                    .hardnessAndResistance(0f)
                    .sound(SoundType.PLANT)));

    public static final RegistryObject<Block> GRASS_SHORT = BLOCKS.register("grass_short",
            () -> new FoliageBlock(Block.Properties.create(Material.TALL_PLANTS)
                    .doesNotBlockMovement()
                    .hardnessAndResistance(0f)
                    .sound(SoundType.PLANT)));

    public static final RegistryObject<Block> ROOTS = BLOCKS.register("roots",
            () -> new HangingPlantBlock(Block.Properties.create(Material.PLANTS, MaterialColor.WOOD)
                    .doesNotBlockMovement()
                    .hardnessAndResistance(0f)
                    .sound(SoundType.PLANT)));

    public static final RegistryObject<Block> ROOTS_LONG = BLOCKS.register("roots_long",
            () -> new DoubleHangingPlantBlock(Block.Properties.create(Material.PLANTS, MaterialColor.WOOD)
                    .doesNotBlockMovement()
                    .hardnessAndResistance(0f)
                    .sound(SoundType.PLANT)));

    public static final RegistryObject<Block> ROOTS_GROUND = BLOCKS.register("roots_ground",
            () -> new PlantBlock(Block.Properties.create(Material.PLANTS, MaterialColor.WOOD)
                    .doesNotBlockMovement()
                    .hardnessAndResistance(0f)
                    .sound(SoundType.PLANT)));

    public static final RegistryObject<Block> ROCKY_DIRT = BLOCKS.register("rocky_dirt",
            () -> new SoilBlock(Block.Properties.create(Material.EARTH, MaterialColor.DIRT)
                    .hardnessAndResistance(0.9f, 4.0f)
                    .sound(SoundType.GROUND)
                    .harvestTool(ToolType.SHOVEL)
                    .harvestLevel(0)));

    public static final RegistryObject<Block> MOSSY_GRAVEL = BLOCKS.register("mossy_gravel",
            () -> new GravelBlock(Block.Properties.create(Material.SAND, MaterialColor.STONE)
                    .hardnessAndResistance(0.6f)
                    .sound(SoundType.GROUND)
                    .harvestTool(ToolType.SHOVEL)
                    .harvestLevel(0)));

    public static final RegistryObject<Block> MOSSY_ROCKY_DIRT = BLOCKS.register("mossy_rocky_dirt",
            () -> new SoilBlock(Block.Properties.create(Material.EARTH, MaterialColor.DIRT)
                    .hardnessAndResistance(0.9f, 4.0f)
                    .sound(SoundType.GROUND)
                    .harvestTool(ToolType.SHOVEL)
                    .harvestLevel(0)));

    public static final RegistryObject<Block> CRACKED_BRICKS = BLOCKS.register("cracked_bricks",
            () -> new SoilBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED)
                    .hardnessAndResistance(2.0F, 6.0F)
                    .sound(SoundType.STONE)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(1)));

    public static final RegistryObject<Block> MOSSY_BRICKS = BLOCKS.register("mossy_bricks",
            () -> new SoilBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED)
                    .hardnessAndResistance(2.0F, 6.0F)
                    .sound(SoundType.STONE)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(1)));

    public static final RegistryObject<Block> TREASURE_POT = BLOCKS.register("treasure_pot",
            () -> new TreasurePotBlock(Block.Properties.create(Material.CLAY, MaterialColor.ORANGE_TERRACOTTA)
                    .hardnessAndResistance(0.2F, 3.0F)
                    .notSolid()
                    .sound(SoundType.STONE)
                    .harvestLevel(0)));

    public static final RegistryObject<Block> ROCK_PILE = BLOCKS.register("rock_pile",
            () -> new RockPileBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)
                    .hardnessAndResistance(0.2F, 6.0F)
                    .doesNotBlockMovement()
                    .sound(SoundType.STONE)
                    .harvestLevel(0)));

    public static final RegistryObject<Block> SANDSTONE_ROCK_PILE = BLOCKS.register("sandstone_rock_pile",
            () -> new RockPileBlock(Block.Properties.create(Material.ROCK, MaterialColor.SAND)
                    .hardnessAndResistance(0.2F, 6.0F)
                    .doesNotBlockMovement()
                    .sound(SoundType.STONE)
                    .harvestLevel(0)));

    public static final RegistryObject<Block> STALAGMITE = BLOCKS.register("stalagmite",
            () -> new StalagmiteBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)
                    .hardnessAndResistance(2.0F, 6.0F)
                    .notSolid()
                    .sound(SoundType.STONE)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(1)));

    public static final RegistryObject<Block> STALACTITE = BLOCKS.register("stalactite",
            () -> new StalactiteBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)
                    .hardnessAndResistance(2.0F, 6.0F)
                    .notSolid()
                    .sound(SoundType.STONE)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(1)));

    public static final RegistryObject<Block> FISH_BONES = BLOCKS.register("fish_bones",
            () -> new FlatBlock(Block.Properties.create(Material.ROCK, MaterialColor.SAND)
                    .hardnessAndResistance(0.1f)
                    .doesNotBlockMovement()
                    .harvestLevel(0)));

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_LANTERN = BLOCKS.register("white_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_LANTERN = BLOCKS.register("orange_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_LANTERN = BLOCKS.register("magenta_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_LANTERN = BLOCKS.register("light_blue_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_LANTERN = BLOCKS.register("yellow_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static final RegistryObject<Block> LIME_STAINED_GLASS_LANTERN = BLOCKS.register("lime_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static final RegistryObject<Block> PINK_STAINED_GLASS_LANTERN = BLOCKS.register("pink_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_LANTERN = BLOCKS.register("gray_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_LANTERN = BLOCKS.register("light_gray_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_LANTERN = BLOCKS.register("cyan_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_LANTERN = BLOCKS.register("purple_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_LANTERN = BLOCKS.register("blue_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_LANTERN = BLOCKS.register("brown_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_LANTERN = BLOCKS.register("green_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static final RegistryObject<Block> RED_STAINED_GLASS_LANTERN = BLOCKS.register("red_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_LANTERN = BLOCKS.register("black_stained_glass_lantern",
            () -> new LanternBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightValue(15)
                    .notSolid()));

    public static void registerFlammables() {
        VanillaUtils.registerFlammable(GRASS_TUFT.get(), 5, 60);
        VanillaUtils.registerFlammable(GRASS_SHORT.get(), 5, 60);
        VanillaUtils.registerFlammable(ROOTS.get(), 5, 60);
        VanillaUtils.registerFlammable(ROOTS_GROUND.get(), 5, 60);
        VanillaUtils.registerFlammable(ROOTS_LONG.get(), 5, 60);
    }
}

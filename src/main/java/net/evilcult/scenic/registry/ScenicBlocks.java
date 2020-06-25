package net.evilcult.scenic.registry;

import net.evilcult.scenic.Scenic;
import net.evilcult.scenic.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.GravelBlock;
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
 * @version 1.15.2-0.1.2
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
                    .hardnessAndResistance(1.0F, 3.0F)
                    .notSolid()
                    .sound(SoundType.STONE)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(0)));

    public static final RegistryObject<Block> ROCK_PILE = BLOCKS.register("rock_pile",
            () -> new RockPileBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)
                    .hardnessAndResistance(2.0F, 6.0F)
                    .doesNotBlockMovement()
                    .sound(SoundType.STONE)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(1)));


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

}

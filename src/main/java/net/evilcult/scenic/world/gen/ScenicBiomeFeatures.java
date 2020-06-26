package net.evilcult.scenic.world.gen;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import net.evilcult.scenic.Scenic;
import net.evilcult.scenic.registry.ScenicBlocks;
import net.evilcult.scenic.registry.ScenicFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Scenic Biome Features
 * Scenic-Mod - net.evilcult.scenic.world.gen.ScenicBiomeFeatures
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-0.1.3
 * @since 2020-06-14
 */
public class ScenicBiomeFeatures {

    // Vanilla Blocks (used for some replacements)
    private static final BlockState DIRT = Blocks.DIRT.getDefaultState();
    private static final BlockState STONE = Blocks.STONE.getDefaultState();
    private static final BlockState COBBLESTONE = Blocks.COBBLESTONE.getDefaultState();
    private static final BlockState MOSSY_COBBLESTONE = Blocks.MOSSY_COBBLESTONE.getDefaultState();
    private static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
    private static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState();

    // Our Blocks
    private static final BlockState GRASS_SHORT = ScenicBlocks.GRASS_SHORT.get().getDefaultState();
    private static final BlockState GRASS_TUFT = ScenicBlocks.GRASS_TUFT.get().getDefaultState();

    private static final BlockState ROOTS = ScenicBlocks.ROOTS.get().getDefaultState();
    private static final BlockState ROOTS_LONG = ScenicBlocks.ROOTS_LONG.get().getDefaultState();
    private static final BlockState ROOTS_GROUND = ScenicBlocks.ROOTS_GROUND.get().getDefaultState();

    private static final BlockState ROCKY_DIRT = ScenicBlocks.ROCKY_DIRT.get().getDefaultState();
    private static final BlockState MOSSY_ROCKY_DIRT = ScenicBlocks.MOSSY_ROCKY_DIRT.get().getDefaultState();
    private static final BlockState MOSSY_GRAVEL = ScenicBlocks.MOSSY_GRAVEL.get().getDefaultState();

    private static final BlockState TREASURE_POT = ScenicBlocks.TREASURE_POT.get().getDefaultState();
    private static final BlockState ROCK_PILE = ScenicBlocks.ROCK_PILE.get().getDefaultState();
    private static final BlockState STALAGMITE = ScenicBlocks.STALAGMITE.get().getDefaultState();
    private static final BlockState STALACTITE = ScenicBlocks.STALACTITE.get().getDefaultState();

    private static final BlockState FISH_BONES = ScenicBlocks.FISH_BONES.get().getDefaultState();

    public static final BlockClusterFeatureConfig GRASS_SHORT_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GRASS_SHORT), new SimpleBlockPlacer())).tries(32).build();
    public static final BlockClusterFeatureConfig GRASS_TUFT_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GRASS_TUFT), new SimpleBlockPlacer())).tries(32).build();

    public static final BlockClusterFeatureConfig ROOTS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ROOTS), new SimpleBlockPlacer())).tries(16).build();
    public static final BlockClusterFeatureConfig ROOTS_LONG_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ROOTS_LONG), new DoublePlantBlockPlacer())).tries(16).build();
    public static final BlockClusterFeatureConfig ROOTS_GROUND_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ROOTS_GROUND), new SimpleBlockPlacer())).tries(8).build();

    public static final BlockClusterFeatureConfig FISH_BONES_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(FISH_BONES), new SimpleBlockPlacer())).tries(4).build();

    public static final CountConfig ROCK_PILE_CONFIG = (new CountConfig(20));

    public static final BlockClusterFeatureConfig STALAGMITE_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(STALAGMITE), new SimpleBlockPlacer())).tries(32).xSpread(20).zSpread(20).whitelist(ImmutableSet.of(STONE.getBlock())).func_227317_b_().build();
    public static final BlockClusterFeatureConfig STALACTITE_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(STALACTITE), new SimpleBlockPlacer())).tries(32).xSpread(20).zSpread(20).func_227317_b_().build();  //.whitelist(ImmutableSet.of(STONE.getBlock())) // (doesn't work with this placer, the whitelist checks below not above)

    public static final BlockClusterFeatureConfig TREASURE_POT_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TREASURE_POT), new SimpleBlockPlacer())).tries(128).whitelist(ImmutableSet.of(COBBLESTONE.getBlock(), MOSSY_COBBLESTONE.getBlock())).func_227317_b_().build();

    //public static final BlockClusterFeatureConfig MOSSY_GRAVEL_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GRASS_TUFT), new SimpleBlockPlacer())).tries(32).build();


    public static void addBiomeFeatures() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome.getCategory() == Biome.Category.NETHER || biome.getCategory() == Biome.Category.THEEND) {
                // Never place stuff in these biomes at the moment.
                continue;
            }

            // Underground features:
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ROCKY_DIRT, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 128))));

            // Rock Piles
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, ScenicFeatures.ROCK_PILE_FEATURE.get().withConfiguration(ROCK_PILE_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 60))));

            // Stalagmites, Stalactites.
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.withConfiguration(STALAGMITE_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 60))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.withConfiguration(STALACTITE_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 60))));

            // Treasure!
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.withConfiguration(TREASURE_POT_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 60))));

            if (biome.getCategory() == Biome.Category.RIVER || biome.getCategory() == Biome.Category.SWAMP) {
                // Add Mossy Gravel and Mossy Rocky Dirt to rivers and swamps.
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(MOSSY_GRAVEL, 4, 2, Lists.newArrayList(GRASS_BLOCK, DIRT, GRAVEL))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(MOSSY_ROCKY_DIRT, 3, 1, Lists.newArrayList(GRASS_BLOCK, DIRT))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
            }

            // Beach
            if (biome.getCategory() == Biome.Category.BEACH) {
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(FISH_BONES_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
            }

            if (biome.getCategory() == Biome.Category.PLAINS
                    || biome.getCategory() == Biome.Category.FOREST
                    || biome.getCategory() == Biome.Category.EXTREME_HILLS
                    || biome.getCategory() == Biome.Category.TAIGA
                    || biome.getCategory() == Biome.Category.SAVANNA
                    || biome.getCategory() == Biome.Category.JUNGLE) {

                // Note: Haven't decided if stuff should spawn in different temps / in dry / snowy areas.
                //if (biome.getTempCategory() == Biome.TempCategory.MEDIUM && biome.getPrecipitation() == Biome.RainType.RAIN) {

                // Our Grasses:
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_SHORT_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_TUFT_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));

                // And Hanging Roots:
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.withConfiguration(ROOTS_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(12, 0, 0, 64))));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.withConfiguration(ROOTS_LONG_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(15, 0, 0, 64))));

                if (biome.getCategory() == Biome.Category.FOREST
                        || biome.getCategory() == Biome.Category.TAIGA) {
                    // Ground roots look best if only in forests - they can appear a bit weird in wide open areas without many trees.
                    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(ROOTS_GROUND_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
                    // TODO: Figure out a way to specifically generate ground roots at the base of trees.
                }
            }
        }
    }
}

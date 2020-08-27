package net.evilcult.scenic.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import net.evilcult.scenic.block.RockPileBlock;
import net.evilcult.scenic.registry.ScenicBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SeaPickleBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.CountConfig;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.Function;

/**
 * Rock Pile Feature
 * Scenic-Mod - net.evilcult.scenic.world.gen.feature.RockPileFeature
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-1.0.3
 * @since 2020-06-24
 */
public class RockPileFeature extends Feature<RockPileConfig> {

    public RockPileFeature(Function<Dynamic<?>, ? extends RockPileConfig> config) {
        super(config);
    }

    @Override
    public boolean place(@Nonnull IWorld world, @Nonnull ChunkGenerator<?> generator, @Nonnull Random random, @Nonnull BlockPos chunkCorner, @Nonnull RockPileConfig config) {
        if (!(world.getDimension().getType() == config.dimensionType)) {
            return false;
        }

        int placed = 0;

        for(int i = 0; i < config.count; ++i) {
            int xRand = random.nextInt(config.radius) - random.nextInt(config.radius);
            int zRand = random.nextInt(config.radius) - random.nextInt(config.radius);

            int y = config.minHeight + random.nextInt(config.maxHeight - config.minHeight);
            BlockPos position = new BlockPos(chunkCorner.getX() + xRand, y, chunkCorner.getZ() + zRand);
            BlockState state = config.state.with(RockPileBlock.ROCKS, random.nextInt(7) + 1);
            if (world.isAirBlock(position) && state.isValidPosition(world, position)) {
                world.setBlockState(position, state, 2);
                placed++;
            } else if (world.getBlockState(position).getBlock() == Blocks.WATER && state.isValidPosition(world, position))  {
                world.setBlockState(position, state.with(RockPileBlock.WATERLOGGED, true), 2);
                placed++;
            }
        }

        return placed > 0;
    }
}

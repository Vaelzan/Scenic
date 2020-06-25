package net.evilcult.scenic.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import net.evilcult.scenic.block.RockPileBlock;
import net.evilcult.scenic.registry.ScenicBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SeaPickleBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
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
 * @version 1.15.2-0.1.2
 * @since 2020-06-24
 */
public class RockPileFeature extends Feature<CountConfig> {
    public RockPileFeature(Function<Dynamic<?>, ? extends CountConfig> config) {
        super(config);
    }

    @Override
    public boolean place(@Nonnull IWorld world, @Nonnull ChunkGenerator<?> generator, @Nonnull Random random, @Nonnull BlockPos chunkCorner, CountConfig countConfig) {
        int placed = 0;

        for(int i = 0; i < countConfig.count; ++i) {
            int xRand = random.nextInt(8) - random.nextInt(8);
            int zRand = random.nextInt(8) - random.nextInt(8);
            int y = random.nextInt(64); // Just pick a random height for now, should be configurable later.
            BlockPos position = new BlockPos(chunkCorner.getX() + xRand, y, chunkCorner.getZ() + zRand);
            BlockState state = ScenicBlocks.ROCK_PILE.get().getDefaultState().with(RockPileBlock.ROCKS, random.nextInt(7) + 1);
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

package net.evilcult.scenic.block;

import net.evilcult.scenic.registry.ScenicBlocks;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import java.util.Random;

/**
 * Hanging Plant Block
 * Scenic-Mod - net.evilcult.scenic.block.HangingPlantBlock
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-0.1.2
 * @since 2020-04-26
 */
public class HangingPlantBlock extends PlantBlock implements IGrowable {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2D, 3D, 2D, 14D, 16D, 14D);

    public HangingPlantBlock(Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos position, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public boolean canGrow(@Nonnull IBlockReader world, @Nonnull BlockPos position, @Nonnull BlockState state, boolean b) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(@Nonnull World world, @Nonnull Random random, @Nonnull BlockPos position, @Nonnull BlockState state) {
        return true;
    }

    @Override
    public void grow(@Nonnull ServerWorld world, @Nonnull Random random, @Nonnull BlockPos position, @Nonnull BlockState state) {
        if (this == ScenicBlocks.ROOTS.get()) {
            DoubleHangingPlantBlock block = ((DoubleHangingPlantBlock) ScenicBlocks.ROOTS_LONG.get());
            if(block.getDefaultState().isValidPosition(world, position) && world.isAirBlock(position.down())) {
                block.placeAt(world, position, 3);
            }
        }
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos position) {
        // This is the same as the regular check except that it checks the block above instead of the block below.
        BlockPos blockpos = position.up();
        if (state.getBlock() == this) {
            return world.getBlockState(blockpos).canSustainPlant(world, blockpos, Direction.UP, this);
        }
        return this.isValidGround(world.getBlockState(blockpos), world, blockpos);
    }
}

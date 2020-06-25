package net.evilcult.scenic.block;

import net.evilcult.scenic.registry.ScenicBlocks;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Foliage Block
 * Scenic-Mod - net.evilcult.scenic.block.FoliageBlock
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-0.1.2
 * @since 2020-04-25
 */
public class FoliageBlock extends TallGrassBlock {
    protected static final VoxelShape SHORT_SHAPE = Block.makeCuboidShape(1D, 0D, 1D, 13D, 7D, 13D);

    public FoliageBlock(Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if (this == ScenicBlocks.GRASS_SHORT.get()) {
            return SHORT_SHAPE;
        }

        return TallGrassBlock.SHAPE;
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IWorld world, BlockPos position, int fortune) {
        world.setBlockState(position, Blocks.AIR.getDefaultState(), 11);
        return Collections.singletonList(new ItemStack(this));
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader world, BlockPos position) {
        return Tags.Blocks.DIRT.contains(state.getBlock());
    }

    @Override
    public void grow(@Nonnull ServerWorld world, Random random, @Nonnull BlockPos position, BlockState state) {
        Block block = null;
        if (this == ScenicBlocks.GRASS_SHORT.get()) {
            block = ScenicBlocks.GRASS_TUFT.get();
        } else if (this == ScenicBlocks.GRASS_TUFT.get()) {
            block = Blocks.GRASS;
        }
        if (block != null) {
            if (block.getDefaultState().isValidPosition(world, position)) {
                world.setBlockState(position, block.getDefaultState());
            }
        }
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.Plains;
    }
}

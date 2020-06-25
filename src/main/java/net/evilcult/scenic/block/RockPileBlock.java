package net.evilcult.scenic.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

/**
 * Rock Pile Block
 * Scenic-Mod - net.evilcult.scenic.block.RockPileBlock
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-0.1.2
 * @since 2020-06-23
 */
public class RockPileBlock extends Block implements IWaterLoggable {
    public static final IntegerProperty ROCKS = IntegerProperty.create("rocks", 1, 7);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    // Actual shapes:
//    protected static final VoxelShape ONE_SHAPE = Block.makeCuboidShape(6d, 0d, 6d, 10d, 2d, 10d);
//    protected static final VoxelShape TWO_SHAPE = Block.makeCuboidShape(5d, 0d, 4d, 11d, 2d, 10d);
//    protected static final VoxelShape THREE_SHAPE = Block.makeCuboidShape(4d, 0d, 5d, 11d, 2d, 12d);
//    protected static final VoxelShape FOUR_SHAPE = Block.makeCuboidShape(5d, 0d, 4d, 12d, 2d, 11d);
//    protected static final VoxelShape FIVE_SHAPE = Block.makeCuboidShape(4d, 0d, 3d, 12d, 4d, 12d);
//    protected static final VoxelShape SIX_SHAPE = Block.makeCuboidShape(4d, 0d, 3d, 12d, 4d, 12d);
//    protected static final VoxelShape SEVEN_SHAPE = Block.makeCuboidShape(4d, 0d, 2d, 12d, 4d, 12d);

    // Symmetrical Versions:
    protected static final VoxelShape ONE_SHAPE = Block.makeCuboidShape(6d, 0d, 6d, 10d, 2d, 10d);
    protected static final VoxelShape TWO_SHAPE = Block.makeCuboidShape(4d, 0d, 4d, 12d, 2d, 12d);
    protected static final VoxelShape THREE_SHAPE = Block.makeCuboidShape(4d, 0d, 4d, 12d, 2d, 12d);
    protected static final VoxelShape FOUR_SHAPE = Block.makeCuboidShape(4d, 0d, 4d, 12d, 2d, 12d);
    protected static final VoxelShape FIVE_SHAPE = Block.makeCuboidShape(3d, 0d, 3d, 13d, 4d, 13d);
    protected static final VoxelShape SIX_SHAPE = Block.makeCuboidShape(3d, 0d, 3d, 13d, 4d, 13d);
    protected static final VoxelShape SEVEN_SHAPE = Block.makeCuboidShape(2d, 0d, 2d, 14d, 4d, 14d);

    public RockPileBlock(Properties properties) {
        super(properties);
        this.setDefaultState((this.stateContainer.getBaseState()).with(ROCKS, 1).with(WATERLOGGED, false));
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull IBlockReader world, @Nonnull BlockPos position, @Nonnull ISelectionContext context) {
        switch(state.get(ROCKS)) {
            case 1:
            default:
                return ONE_SHAPE;
            case 2:
                return TWO_SHAPE;
            case 3:
                return THREE_SHAPE;
            case 4:
                return FOUR_SHAPE;
            case 5:
                return FIVE_SHAPE;
            case 6:
                return SIX_SHAPE;
            case 7:
                return SEVEN_SHAPE;
        }
    }
//
//    @SuppressWarnings("deprecation")
//    @Nonnull
//    @Override
//    public VoxelShape getCollisionShape(@Nonnull BlockState state, @Nonnull IBlockReader world, @Nonnull BlockPos position, @Nonnull ISelectionContext context) {
//        return getShape(state, world, position, context);
//    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockState = context.getWorld().getBlockState(context.getPos());
        if (blockState.getBlock() == this) {
            return blockState.with(ROCKS, Math.min(7, blockState.get(ROCKS) + 1));
        } else {
            IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
            boolean isWaterLogged = fluidState.isTagged(FluidTags.WATER) && fluidState.getLevel() == 8;
            return Objects.requireNonNull(super.getStateForPlacement(context)).with(WATERLOGGED, isWaterLogged);
        }
    }

    protected boolean isValidGround(BlockState state, IBlockReader world, BlockPos position) {
        return !state.getCollisionShape(world, position).project(Direction.UP).isEmpty();
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos position) {
        BlockPos blockPos = position.down();
        return this.isValidGround(world.getBlockState(blockPos), world, blockPos);
    }

    @Nonnull
    @SuppressWarnings("deprecation")
    @Override
    public BlockState updatePostPlacement(BlockState state, Direction direction, BlockState facingState, IWorld world, BlockPos position, BlockPos facing) {
        if (!state.isValidPosition(world, position)) {
            return Blocks.AIR.getDefaultState();
        } else {
            if (state.get(WATERLOGGED)) {
                world.getPendingFluidTicks().scheduleTick(position, Fluids.WATER, Fluids.WATER.getTickRate(world));
            }

            return super.updatePostPlacement(state, direction, facingState, world, position, facing);
        }
    }

    @SuppressWarnings("deprecation")
    public boolean isReplaceable(BlockState state, BlockItemUseContext context) {
        return context.getItem().getItem() == this.asItem() && state.get(ROCKS) < 7 || super.isReplaceable(state, context);
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public IFluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(ROCKS, WATERLOGGED);
    }

    @Override
    public boolean propagatesSkylightDown(@Nonnull BlockState state, @Nonnull IBlockReader reader, @Nonnull BlockPos position) {
        return true;
    }
//
//    @SuppressWarnings("deprecation")
//    @Override
//    public boolean allowsMovement(@Nonnull BlockState state, @Nonnull IBlockReader world, @Nonnull BlockPos position, @Nonnull PathType type) {
//        return false;
//    }
//
    @SuppressWarnings("deprecation")
    @Override
    public boolean allowsMovement(@Nonnull BlockState state, @Nonnull IBlockReader world, @Nonnull BlockPos position, @Nonnull PathType type) {
        return type == PathType.AIR && !this.blocksMovement || super.allowsMovement(state, world, position, type);
    }
}

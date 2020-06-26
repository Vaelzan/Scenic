package net.evilcult.scenic.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DyeColor;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
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
 * Flat Block
 * Scenic-Mod - net.evilcult.scenic.block.FlatBlock
 *
 * To allow blocks using builtin/generated models to sit flat on the ground.
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-0.1.3
 * @since 2020-06-20
 */
public class FlatBlock extends Block implements IWaterLoggable {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
    protected static final Vec3d OFFSET = new Vec3d(0d, -0.46875d, 0d);
    public FlatBlock(Block.Properties properties) {
        super(properties);
        this.setDefaultState((this.stateContainer.getBaseState()).with(WATERLOGGED, false));
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @SuppressWarnings("deprecation")
    public boolean allowsMovement(@Nonnull BlockState state, @Nonnull IBlockReader world, @Nonnull BlockPos position, @Nonnull PathType type) {
        return type == PathType.AIR && !this.blocksMovement || super.allowsMovement(state, world, position, type);
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

    @Override
    public boolean propagatesSkylightDown(@Nonnull BlockState state, @Nonnull IBlockReader reader, @Nonnull BlockPos position) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public Vec3d getOffset(@Nonnull BlockState state, @Nonnull IBlockReader world, @Nonnull BlockPos position) {
        return OFFSET;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
        boolean isWaterLogged = fluidState.isTagged(FluidTags.WATER) && fluidState.getLevel() == 8;
        return Objects.requireNonNull(super.getStateForPlacement(context)).with(WATERLOGGED, isWaterLogged);
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public IFluidState getFluidState(@Nonnull BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(WATERLOGGED);
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

}

package net.evilcult.scenic.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Double Hanging Plant Block
 * Scenic-Mod - net.evilcult.scenic.block.DoubleHangingPlantBlock
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-0.1.2
 * @since 2020-04-26
 */
public class DoubleHangingPlantBlock extends DoublePlantBlock {
    public DoubleHangingPlantBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HALF, DoubleBlockHalf.UPPER));
    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     */
    @Nonnull
    @Override
    public BlockState updatePostPlacement(BlockState state, Direction facing, @Nonnull BlockState facingState, @Nonnull IWorld world, @Nonnull BlockPos currentPos, BlockPos facingPos) {
        //return state;
        DoubleBlockHalf doubleblockhalf = state.get(HALF);
        if (facing.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.UPPER != (facing == Direction.DOWN) || facingState.getBlock() == this && facingState.get(HALF) != doubleblockhalf) {
            return doubleblockhalf == DoubleBlockHalf.UPPER && facing == Direction.UP && !state.isValidPosition(world, currentPos) ? Blocks.AIR.getDefaultState() : state;
        } else {
            return Blocks.AIR.getDefaultState();
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@Nonnull BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        return blockpos.getY() < context.getWorld().getDimension().getHeight() - 1 && context.getWorld().getBlockState(blockpos.down()).isReplaceable(context) ? this.getDefaultState() : null;
    }

    /**
     * Called by ItemBlocks after a block is set in the world, to allow post-place logic
     */
    @Override
    public void onBlockPlacedBy(@Nonnull World world, @Nonnull BlockPos position, @Nonnull BlockState state, @Nonnull LivingEntity placer, @Nonnull ItemStack stack) {
        // Flags: 3 = 1 (Block Update) + 2 (Send to Client)
        world.setBlockState(position.down(), this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER), 3);
    }

    @Override
    public void placeAt(@Nonnull IWorld world, @Nonnull BlockPos position, int flags) {
        // As DoublePlantBlock except the other half grows down instead of up.
        world.setBlockState(position, this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER), flags);
        world.setBlockState(position.down(), this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER), flags);
    }

    @Override
    public boolean isValidPosition(@Nonnull BlockState state, @Nonnull IWorldReader world, @Nonnull BlockPos position) {
        if (state.get(HALF) != DoubleBlockHalf.LOWER) {
            // We're the upper half, so do a proper validation.
            return isValidPositionImpl(state, world, position);
        } else {
            if (state.getBlock() != this) {
                return isValidPositionImpl(state, world, position);
            }

            // We're the lower half, check if the upper half is there and of the same block type.
            BlockState blockstate = world.getBlockState(position.up());
            return blockstate.getBlock() == this && blockstate.get(HALF) == DoubleBlockHalf.UPPER;
        }
    }

    protected boolean isValidPositionImpl(BlockState state, IWorldReader world, BlockPos position) {
        BlockPos blockpos = position.up();
        return world.getBlockState(blockpos).canSustainPlant(world, blockpos, Direction.DOWN, this);
//        if (state.getBlock() == this) {
//            return world.getBlockState(blockpos).canSustainPlant(world, blockpos, Direction.UP, this);
//        }
//        return this.isValidGround(world.getBlockState(blockpos), world, blockpos);
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader world, BlockPos position) {
        return Tags.Blocks.DIRT.contains(state.getBlock());
    }

    /**
     * Spawns the block's drops in the world. By the time this is called the Block has possibly been set to air via
     * Block.removedByPlayer
     */
    @Override
    public void harvestBlock(@Nonnull World world, @Nonnull PlayerEntity player, @Nonnull BlockPos pos, BlockState state, @Nullable TileEntity te, @Nonnull ItemStack stack) {
        super.harvestBlock(world, player, pos, Blocks.AIR.getDefaultState(), te, stack);
    }

    /**
     * Called before the Block is set to air in the world. Called regardless of if the player's tool can actually collect
     * this block
     */
    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf doubleblockhalf = state.get(HALF);
        BlockPos blockpos = doubleblockhalf == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
        BlockState blockstate = world.getBlockState(blockpos);
        if (blockstate.getBlock() == this && blockstate.get(HALF) != doubleblockhalf) {
            world.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
            world.playEvent(player, 2001, blockpos, Block.getStateId(blockstate));
            if (!world.isRemote && !player.isCreative()) {
                spawnDrops(state, world, pos, (TileEntity)null, player, player.getHeldItemMainhand());
                spawnDrops(blockstate, world, blockpos, (TileEntity)null, player, player.getHeldItemMainhand());
            }
        }

        super.onBlockHarvested(world, pos, state, player);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HALF);
    }

    /**
     * Get the OffsetType for this Block. Determines if the model is rendered slightly offset.
     */
    @Override
    @Nonnull
    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.Plains;
    }
}

package net.evilcult.scenic.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.IFluidState;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nonnull;

/**
 * Soil Block
 * Scenic-Mod - net.evilcult.scenic.block.SoilBlock
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-0.1.2
 * @since 2020-06-15
 */
public class SoilBlock extends Block {
    public SoilBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSustainPlant(@Nonnull BlockState state, @Nonnull IBlockReader world, BlockPos pos, @Nonnull Direction facing, IPlantable plantable) {
        BlockState plant = plantable.getPlant(world, pos.offset(facing));
        net.minecraftforge.common.PlantType type = plantable.getPlantType(world, pos.offset(facing));
        switch (type) {
            case Cave:
            case Plains:
                return true;
            case Beach:
                // Sugar cane can be planted next to waterlogged or water blocks.
                for(Direction direction : Direction.Plane.HORIZONTAL) {
                    IFluidState fluidstate = world.getFluidState(pos.offset(direction));
                    if (fluidstate.isTagged(FluidTags.WATER)) {
                        return true;
                    }
                }
        }
        return false;
    }
}
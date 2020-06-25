package net.evilcult.scenic.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SphereReplaceConfig;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.Function;

/**
 * Cluster Replace Feature
 * Scenic-Mod - net.evilcult.scenic.world.gen.feature.ClusterReplaceFeature
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-0.1.2
 * @since 2020-06-20
 */
public class ClusterReplaceFeature extends Feature<ClusterReplaceConfig> {
    public ClusterReplaceFeature(Function<Dynamic<?>, ? extends ClusterReplaceConfig> p_i49885_1_) {
        super(p_i49885_1_);
    }

    public boolean place(IWorld worldIn, @Nonnull ChunkGenerator<? extends GenerationSettings> generator, @Nonnull Random random, @Nonnull BlockPos position, @Nonnull ClusterReplaceConfig config) {
        if (!worldIn.getFluidState(position).isTagged(FluidTags.WATER)) {
            return false;
        } else {
            int i = 0;
            int j = random.nextInt(config.radius - 2) + 2;

            for(int k = position.getX() - j; k <= position.getX() + j; ++k) {
                for(int l = position.getZ() - j; l <= position.getZ() + j; ++l) {
                    int i1 = k - position.getX();
                    int j1 = l - position.getZ();
                    if (i1 * i1 + j1 * j1 <= j * j) {
                        for(int k1 = position.getY() - config.ySize; k1 <= position.getY() + config.ySize; ++k1) {
                            BlockPos blockpos = new BlockPos(k, k1, l);
                            BlockState blockstate = worldIn.getBlockState(blockpos);

                            for(BlockState blockstate1 : config.targets) {
                                if (blockstate1.getBlock() == blockstate.getBlock()) {
                                    worldIn.setBlockState(blockpos, config.state, 2);
                                    ++i;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            return i > 0;
        }
    }
}
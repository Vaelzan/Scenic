package net.evilcult.scenic.world.gen.feature;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Scattered Sphere Replace Config
 * Scenic-Mod - net.evilcult.scenic.world.gen.feature.ScatteredSphereReplaceConfig
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-0.1.2
 * @since 2020-06-20
 */
public class ClusterReplaceConfig implements IFeatureConfig {
    public final BlockState state;
    public final int radius;
    public final int ySize;
    public final List<BlockState> targets;

    public ClusterReplaceConfig(BlockState state, int radiusIn, int ySizeIn, List<BlockState> targetsIn) {
        this.state = state;
        this.radius = radiusIn;
        this.ySize = ySizeIn;
        this.targets = targetsIn;
    }

    @Nonnull
    public <T> Dynamic<T> serialize(@Nonnull DynamicOps<T> ops) {
        return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(
                ops.createString("state"), BlockState.serialize(ops, this.state).getValue(),
                ops.createString("radius"), ops.createInt(this.radius),
                ops.createString("y_size"), ops.createInt(this.ySize),
                ops.createString("targets"), ops.createList(this.targets.stream().map((p_214692_1_) -> {
            return BlockState.serialize(ops, p_214692_1_).getValue();
        })))));
    }

    public static <T> ClusterReplaceConfig deserialize(Dynamic<T> p_214691_0_) {
        BlockState blockstate = p_214691_0_.get("state").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        int i = p_214691_0_.get("radius").asInt(0);
        int j = p_214691_0_.get("y_size").asInt(0);
        List<BlockState> list = p_214691_0_.get("targets").asList(BlockState::deserialize);
        return new ClusterReplaceConfig(blockstate, i, j, list);
    }
}
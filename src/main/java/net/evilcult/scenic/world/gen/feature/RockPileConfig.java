package net.evilcult.scenic.world.gen.feature;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.feature.IFeatureConfig;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

/**
 * Rock Pile Config
 * Scenic-Mod - net.evilcult.scenic.world.gen.feature.RockPileConfig
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-1.0.3
 * @since 2020-08-08
 */
public class RockPileConfig implements IFeatureConfig {

    public final BlockState state;
    public final int radius;
    public final int minHeight;
    public final int maxHeight;
    public final int count;
    public final DimensionType dimensionType;

    public RockPileConfig(BlockState state, int radius, int minHeight, int maxHeight, int count, DimensionType dimensionType) {
        this.state = state;
        this.radius = radius;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.count = count;
        this.dimensionType = dimensionType;
    }

    @Nonnull
    public <T> Dynamic<T> serialize(@Nonnull DynamicOps<T> ops) {
        ImmutableMap.Builder<T, T> builder = ImmutableMap.builder();
        builder.put(ops.createString("state"), BlockState.serialize(ops, this.state).getValue());
        builder.put(ops.createString("radius"), ops.createInt(this.radius));
        builder.put(ops.createString("min_height"), ops.createInt(this.minHeight));
        builder.put(ops.createString("max_height"), ops.createInt(this.maxHeight));
        builder.put(ops.createString("count"), ops.createInt(this.count));
        builder.put(ops.createString("dimension_type"), ops.createString(Objects.requireNonNull(this.dimensionType.getRegistryName()).getPath()));
        return new Dynamic<>(ops, ops.createMap(builder.build()));
    }

    public static <T> RockPileConfig deserialize(Dynamic<T> dynamic) {
        BlockState blockState = dynamic.get("state").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        int radius = dynamic.get("radius").asInt(0);
        int minHeight = dynamic.get("max_height").asInt(0);
        int maxHeight = dynamic.get("max_height").asInt(0);
        int count = dynamic.get("count").asInt(0);
        DimensionType dimensionType = DimensionType.byName(new ResourceLocation(dynamic.get("dimension_type").asString("")));
        return new RockPileConfig(blockState, radius, minHeight, maxHeight, count, dimensionType);
    }
}

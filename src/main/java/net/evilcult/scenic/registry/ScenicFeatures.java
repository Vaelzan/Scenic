package net.evilcult.scenic.registry;

import net.evilcult.scenic.Scenic;
import net.evilcult.scenic.world.gen.feature.ClusterReplaceConfig;
import net.evilcult.scenic.world.gen.feature.ClusterReplaceFeature;
import net.evilcult.scenic.world.gen.feature.RockPileFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.SphereReplaceFeature;
import net.minecraft.world.gen.placement.CountConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Scenic Features
 * Scenic-Mod - net.evilcult.scenic.registry.ScenicFeatures
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-1.0.2
 * @since 2020-06-20
 */
public class ScenicFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Scenic.MODID);

    public static final RegistryObject<Feature<ClusterReplaceConfig>> CLUSTER_REPLACE_FEATURE = register("scattered_disk", new ClusterReplaceFeature(ClusterReplaceConfig::deserialize));
    public static final RegistryObject<Feature<CountConfig>> ROCK_PILE_FEATURE = register("rock_pile", new RockPileFeature(CountConfig::deserialize));

    private static <T extends Feature<?>> RegistryObject<T> register(String name, T feature) {
        return FEATURES.register(name, () -> feature);
    }
}

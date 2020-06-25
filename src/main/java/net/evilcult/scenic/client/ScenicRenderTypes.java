package net.evilcult.scenic.client;

import net.evilcult.scenic.registry.ScenicBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Scenic Render Types
 * Scenic-Mod - net.evilcult.scenic.client.AestheticsRenderTypes
 *
 * Used to set the correct render types for our blocks.
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-0.1.2
 * @since 2020-06-14
 */
@OnlyIn(Dist.CLIENT)
public class ScenicRenderTypes {
    public static void setRenderTypes() {
        RenderType cutout = RenderType.getCutout();

        RenderTypeLookup.setRenderLayer(ScenicBlocks.GRASS_TUFT.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.GRASS_SHORT.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.ROOTS.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.ROOTS_LONG.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.ROOTS_GROUND.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.FISH_BONES.get(), cutout);

    }
}

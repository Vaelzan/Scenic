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
 * @version 1.15.2-1.0.1
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

        RenderTypeLookup.setRenderLayer(ScenicBlocks.BLACK_STAINED_GLASS_LANTERN.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.BLUE_STAINED_GLASS_LANTERN.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.BROWN_STAINED_GLASS_LANTERN.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.CYAN_STAINED_GLASS_LANTERN.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.GRAY_STAINED_GLASS_LANTERN.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.GREEN_STAINED_GLASS_LANTERN.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.LIGHT_BLUE_STAINED_GLASS_LANTERN.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.LIGHT_GRAY_STAINED_GLASS_LANTERN.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.LIME_STAINED_GLASS_LANTERN.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.MAGENTA_STAINED_GLASS_LANTERN.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.ORANGE_STAINED_GLASS_LANTERN.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.PINK_STAINED_GLASS_LANTERN.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.PURPLE_STAINED_GLASS_LANTERN.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.RED_STAINED_GLASS_LANTERN.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.WHITE_STAINED_GLASS_LANTERN.get(), cutout);
        RenderTypeLookup.setRenderLayer(ScenicBlocks.YELLOW_STAINED_GLASS_LANTERN.get(), cutout);
    }
}

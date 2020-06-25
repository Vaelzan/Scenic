package net.evilcult.scenic.client;

import net.evilcult.scenic.registry.ScenicBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Scenic Colours
 * Scenic-Mod - net.evilcult.scenic.client.AestheticsColours
 *
 * Handles setting the correct colours for grass and foliage in our blocks.
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-0.1.2
 * @since 2020-06-14
 */
@OnlyIn(Dist.CLIENT)
public class ScenicColours {
    public static void registerColours() {
        BlockColors blockColours = Minecraft.getInstance().getBlockColors();
        ItemColors itemColours = Minecraft.getInstance().getItemColors();

        // Grass Colouring
        blockColours.register((state, world, pos, tintIndex) -> {
            if (world != null && pos != null) {
                return BiomeColors.getGrassColor(world, pos);
            }
            return getDefaultGrassColour();
        }, ScenicBlocks.GRASS_SHORT.get(), ScenicBlocks.GRASS_TUFT.get());

        // Foliage Coloring
//        blockColours.register((state, world, pos, tintIndex) ->
//                        world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefault(),
//                BLOCKSHERE);

        //Block Item Colouring
        itemColours.register((stack, tintIndex) -> {
            BlockState state = ((BlockItem) stack.getItem()).getBlock().getDefaultState();
            return blockColours.getColor(state, null, null, tintIndex);
        }, ScenicBlocks.GRASS_SHORT.get(), ScenicBlocks.GRASS_TUFT.get());
    }

    private static int getDefaultGrassColour() {
        return GrassColors.get(0.5d, 1.0d);
    }

}

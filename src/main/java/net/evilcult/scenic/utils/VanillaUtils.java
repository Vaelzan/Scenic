package net.evilcult.scenic.utils;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.util.IItemProvider;

/**
 * Vanilla Utils
 * Scenic-Mod - net.evilcult.scenic.utils.VanillaUtils
 *
 * Utilities for interacting / compatibility with vanilla blocks.
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-1.0.2
 * @since 2020-07-16
 */
public class VanillaUtils {
    /**
     * Warning: Not thread-safe!
     * @param block The block to make flammable.
     * @param encouragement The speed of fire spread - eg. leaves are 30, logs and planks are 5.
     * @param flammability How flammable the block should be - eg. Leaves are 60, logs are 5, planks are 20..
     */
    public static void registerFlammable(Block block, int encouragement, int flammability) {
        ((FireBlock)Blocks.FIRE).setFireInfo(block, encouragement, flammability);
    }

    /**
     * Warning: Not thread-safe!
     * @param item The item to add to the composter.
     * @param chance Chance between 0.0f and 1.0f to add to the compost level.
     */
    public static void registerCompostable(IItemProvider item, float chance) {
        ComposterBlock.CHANCES.put(item.asItem(), chance);
    }
}

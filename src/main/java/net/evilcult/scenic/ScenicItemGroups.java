package net.evilcult.scenic;

import net.evilcult.scenic.registry.ScenicItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * Scenic Item Group
 * Scenic-Mod - net.evilcult.scenic.AestheticsItemGroup
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-0.1.2
 * @since 2020-04-25
 */
public class ScenicItemGroups {

    public static final ItemGroup MAIN = new ItemGroup(Scenic.MODID + "_main") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ScenicItems.ROCKY_DIRT.get());
        }
    };
}

package net.evilcult.scenic;

import net.evilcult.scenic.client.ScenicColours;
import net.evilcult.scenic.client.ScenicRenderTypes;
import net.evilcult.scenic.registry.ScenicBlocks;
import net.evilcult.scenic.registry.ScenicFeatures;
import net.evilcult.scenic.registry.ScenicItems;
import net.evilcult.scenic.world.gen.ScenicBiomeFeatures;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Scenic Main Class
 * Scenic-Mod - net.evilcult.scenic.Scenic
 *
 * @author Patrick "Vaelzan" Beasley (vaelzan@evilcult.net)
 * @version 1.15.2-1.0.2
 * @since 2020-04-25
 */
@Mod(Scenic.MODID)
public class Scenic {

    /**
     * Singleton instance of this mod.
     */
    public static Scenic INSTANCE;

    /**
     * Mod ID
     */
    public static final String MODID = "scenic";

    /**
     * Mod Event Bus
     */
    public static IEventBus MOD_EVENT_BUS;

    /**
     * Logger to use mod-wide.
     */
    public static final Logger LOGGER = LogManager.getLogger();

    /**
     * Constructor for Main Class.
     */
    public Scenic() {
        INSTANCE = this;
        MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        MOD_EVENT_BUS.addListener(this::commonSetup);

        //noinspection deprecation
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            MOD_EVENT_BUS.addListener(EventPriority.LOWEST, this::clientSetup);
        });

        ScenicItems.ITEMS.register(MOD_EVENT_BUS);
        ScenicBlocks.BLOCKS.register(MOD_EVENT_BUS);
        ScenicFeatures.FEATURES.register(MOD_EVENT_BUS);
    }

    /**
     * Common Setup
     * @param event FML Common Setup Event
     */
    @SuppressWarnings("deprecation") // DeferredWorkQueue is deprecated for some stupid reason.
    private void commonSetup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            ScenicBiomeFeatures.addBiomeFeatures();
            ScenicBlocks.registerFlammables();
            ScenicItems.registerCompostables();
        });
    }

    /**
     * Client Setup
     * @param event FML Client Setup Event
     */
    @SuppressWarnings("deprecation") // DeferredWorkQueue is deprecated for some stupid reason.
    private void clientSetup(final FMLClientSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            ScenicColours.registerColours();
            ScenicRenderTypes.setRenderTypes();
        });
    }
}

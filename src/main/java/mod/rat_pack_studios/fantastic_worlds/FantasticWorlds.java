package mod.rat_pack_studios.fantastic_worlds;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(FantasticWorlds.MOD_ID)
public class FantasticWorlds {

    public static final String MOD_ID = "fantastic_worlds";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FantasticWorlds() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);

        // Register config
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        // Register lifecycle event listeners
        modEventBus.addListener(this::commonSetup);

        // Client setup event is handled in the nested ClientModEvents class
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Performing common setup for Fantastic Worlds...");
        ChunkGenRegistry.perform();
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Server is starting...");
        // Add server startup logic here
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("Client setup for Fantastic Worlds...");
            // Client-side setup logic here
        }
    }
}

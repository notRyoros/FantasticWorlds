package mod.rat_pack_studios.fantastic_worlds;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FantasticWorlds implements ModInitializer
{
    public static final String MOD_ID = "fantastic_worlds";
    public static final Logger LOGGER = LoggerFactory.getLogger("FantasticWorlds");

    @Override
    public void onInitialize()
    {
        LOGGER.info("registering chunk generators.");
        ChunkGenRegistry.perform();
    }
}

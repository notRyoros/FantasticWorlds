package mod.rat_pack_studios.fantastic_worlds.forge;

import mod.rat_pack_studios.fantastic_worlds.common.CommonFW;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CommonFW.MODID)
public class ForgeFW
{
    public ForgeFW(FMLJavaModLoadingContext context)
    {
        CommonFW.LOGGER.info("Hello Minecraft!");
    }
}
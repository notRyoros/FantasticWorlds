package mod.rat_pack_studios.fantastic_worlds.fabric;
import mod.rat_pack_studios.fantastic_worlds.common.CommonFW;
import mod.rat_pack_studios.fantastic_worlds.common.CommonFWClient;
import net.fabricmc.api.ClientModInitializer;

public class FabricFWClient implements ClientModInitializer
{
    private static FabricFWClient instance;

    @Override
    public void onInitializeClient()
    {
        instance = this;
    }

    public static FabricFWClient getInstance()
    {
        return instance;
    }
}
package mod.rat_pack_studios.fantastic_worlds;

import mod.rat_pack_studios.fantastic_worlds.world.chunkgen.FantasticWorldsChunkGenEnd;
import mod.rat_pack_studios.fantastic_worlds.world.chunkgen.FantasticWorldsChunkGenNether;
import mod.rat_pack_studios.fantastic_worlds.world.chunkgen.FantasticWorldsChunkGenOverworld;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;


public class ChunkGenRegistry
{
    public static void perform()
    {
        Registry.register(BuiltInRegistries.CHUNK_GENERATOR, ResourceLocation.fromNamespaceAndPath(FantasticWorlds.MOD_ID, "fantastic_overworld"), FantasticWorldsChunkGenOverworld.CODEC);
        Registry.register(BuiltInRegistries.CHUNK_GENERATOR, ResourceLocation.fromNamespaceAndPath(FantasticWorlds.MOD_ID, "fantastic_nether"), FantasticWorldsChunkGenNether.CODEC);
        Registry.register(BuiltInRegistries.CHUNK_GENERATOR, ResourceLocation.fromNamespaceAndPath(FantasticWorlds.MOD_ID, "fantastic_end"), FantasticWorldsChunkGenEnd.CODEC);
    }
}

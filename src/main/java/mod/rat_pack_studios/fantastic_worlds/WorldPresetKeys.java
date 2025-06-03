package mod.rat_pack_studios.fantastic_worlds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.presets.WorldPreset;

public class WorldPresetKeys
{
    public static final ResourceKey<WorldPreset> FANTASTIC_OVERWORLD = ResourceKey.create(Registries.WORLD_PRESET, ResourceLocation.fromNamespaceAndPath(FantasticWorlds.MOD_ID, "fantastic_overworld.json"));
    public static final ResourceKey<WorldPreset> FANTASTIC_NETHER = ResourceKey.create(Registries.WORLD_PRESET, ResourceLocation.fromNamespaceAndPath(FantasticWorlds.MOD_ID, "fantastic_nether.json"));
    public static final ResourceKey<WorldPreset> FANTASTIC_END = ResourceKey.create(Registries.WORLD_PRESET, ResourceLocation.fromNamespaceAndPath(FantasticWorlds.MOD_ID, "fantastic_end.json"));
}

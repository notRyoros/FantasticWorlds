package mod.rat_pack_studios.fantastic_worlds.mixin;

import mod.rat_pack_studios.fantastic_worlds.WorldPresetKeys;
import mod.rat_pack_studios.fantastic_worlds.world.chunkgen.FantasticWorldsChunkGenEnd;
import mod.rat_pack_studios.fantastic_worlds.world.chunkgen.FantasticWorldsChunkGenNether;
import mod.rat_pack_studios.fantastic_worlds.world.chunkgen.FantasticWorldsChunkGenOverworld;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import net.minecraft.world.level.levelgen.presets.WorldPresets;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(WorldPresets.Bootstrap.class)
public abstract class FantasticWorldsPresets
{
    @Shadow @Final
    private BootstrapContext<WorldPreset> context;

    @Shadow protected abstract LevelStem makeOverworld(ChunkGenerator chunkGenerator);

    @Shadow @Final private HolderGetter<Biome> biomes;

    @Shadow @Final private HolderGetter<NoiseGeneratorSettings> noiseSettings;

    @Shadow @Final private HolderGetter<MultiNoiseBiomeSourceParameterList> multiNoiseBiomeSourceParameterLists;

    @Inject(method = "registerOverworlds", at = @At("TAIL"))
    private void addFantasticWorldPreset(BiomeSource biomeSource, CallbackInfo ci){

        HolderGetter<DimensionType> dimensionLookup = this.context.lookup(Registries.DIMENSION_TYPE);
        Holder<DimensionType> netherType = dimensionLookup.getOrThrow(BuiltinDimensionTypes.NETHER);
        Holder<DimensionType> endType = dimensionLookup.getOrThrow(BuiltinDimensionTypes.END);

        Holder<NoiseGeneratorSettings> overworldSettings = this.noiseSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD);
        Holder<NoiseGeneratorSettings> netherSettings = this.noiseSettings.getOrThrow(NoiseGeneratorSettings.NETHER);
        Holder<NoiseGeneratorSettings> endSettings = this.noiseSettings.getOrThrow(NoiseGeneratorSettings.END);


        Holder.Reference<MultiNoiseBiomeSourceParameterList> netherBiomeSource = this.multiNoiseBiomeSourceParameterLists.getOrThrow(MultiNoiseBiomeSourceParameterLists.NETHER);

        LevelStem overworldOptions = this.makeOverworld(new FantasticWorldsChunkGenOverworld(biomeSource, overworldSettings));
        LevelStem netherOptions = new LevelStem(netherType, new FantasticWorldsChunkGenNether(MultiNoiseBiomeSource.createFromPreset(netherBiomeSource), netherSettings));
        LevelStem endOptions = new LevelStem(endType, new FantasticWorldsChunkGenEnd(TheEndBiomeSource.create(this.biomes), endSettings));

        this.context.register(WorldPresetKeys.FANTASTIC_OVERWORLD, new WorldPreset(Map.of(LevelStem.OVERWORLD, overworldOptions, LevelStem.NETHER, netherOptions, LevelStem.END, endOptions)));
    }

}

package mod.rat_pack_studios.fantastic_worlds.world.chunkgen;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.chunk.ChunkGenerator;

public class FantasticWorldsChunkGenOverworld extends AbstractFantasticWorldsChunkGenerator
{
    public static final MapCodec<NoiseBasedChunkGenerator> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                            BiomeSource.CODEC.fieldOf("biome_source").forGetter(ChunkGenerator::getBiomeSource),
                            NoiseGeneratorSettings.CODEC.fieldOf("settings").forGetter(NoiseBasedChunkGenerator::generatorSettings)
                    )
                    .apply(instance, instance.stable(FantasticWorldsChunkGenOverworld::new))
    );

    public FantasticWorldsChunkGenOverworld(BiomeSource biomeSource, Holder<NoiseGeneratorSettings> settings)
    {
        super(biomeSource, settings);
    }
}

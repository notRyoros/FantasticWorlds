package mod.rat_pack_studios.fantastic_worlds.world.chunkgen;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.biome.FeatureSorter;

import java.util.List;

public class AbstractFantasticWorldsChunkGenerator extends NoiseBasedChunkGenerator
{
    public AbstractFantasticWorldsChunkGenerator(BiomeSource biomeSource, Holder<NoiseGeneratorSettings> settings)
    {
        super(biomeSource, settings);
    }
}

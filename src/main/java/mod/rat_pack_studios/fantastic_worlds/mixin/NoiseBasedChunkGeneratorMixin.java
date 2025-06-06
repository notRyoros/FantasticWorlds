package mod.rat_pack_studios.fantastic_worlds.mixin;

import com.mojang.serialization.MapCodec;
import mod.rat_pack_studios.fantastic_worlds.WorldPresetKeys;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.tags.WorldPresetTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.presets.WorldPresets;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoiseBasedChunkGenerator.class)
public class NoiseBasedChunkGeneratorMixin {

    /**
     * @author
     * @reason
     */
    @Overwrite
    private static Aquifer.FluidPicker createFluidPicker(NoiseGeneratorSettings p_249264_) {
        Aquifer.FluidStatus $$1 = new Aquifer.FluidStatus(-114, Blocks.LAVA.defaultBlockState());
        int $$2 = p_249264_.seaLevel();
        Aquifer.FluidStatus $$3 = new Aquifer.FluidStatus($$2, p_249264_.defaultFluid());
        Aquifer.FluidStatus $$4 = new Aquifer.FluidStatus(DimensionType.MIN_Y * 2, Blocks.AIR.defaultBlockState());
        return (p_224274_, p_224275_, p_224276_) -> {
            return p_224275_ < Math.min(-114, $$2) ? $$1 : $$3;
        };
    }
}
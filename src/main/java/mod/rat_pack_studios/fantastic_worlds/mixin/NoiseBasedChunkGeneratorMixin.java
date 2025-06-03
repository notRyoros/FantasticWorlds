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
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoiseBasedChunkGenerator.class)
public class NoiseBasedChunkGeneratorMixin {

    @Shadow @Final public static MapCodec<NoiseBasedChunkGenerator> CODEC;

    @Inject(method = "createFluidPicker", at = @At("TAIL"), cancellable = true)
    private static void overwriteCreateFluidPicker(NoiseGeneratorSettings noiseGeneratorSettings, CallbackInfoReturnable<Aquifer.FluidPicker> cir)
    {
        Aquifer.FluidStatus fluidStatus = new Aquifer.FluidStatus(-118, Blocks.LAVA.defaultBlockState());
        int i = noiseGeneratorSettings.seaLevel();
        Aquifer.FluidStatus fluidStatus2 = new Aquifer.FluidStatus(i, noiseGeneratorSettings.defaultFluid());
        Aquifer.FluidStatus fluidStatus3 = new Aquifer.FluidStatus(DimensionType.MIN_Y * 2, Blocks.AIR.defaultBlockState());
        cir.setReturnValue((j, k, l) -> {
            return k < Math.min(-118, i) ? fluidStatus : fluidStatus2;
        });
    }
}
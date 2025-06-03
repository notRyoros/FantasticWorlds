package mod.rat_pack_studios.fantastic_worlds.mixin;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoiseBasedChunkGenerator.class)
public class LavaLevelMixin {

    @Inject(method = "createFluidPicker", at = @At("TAIL"), cancellable = true)
    private static void overwriteCreateFluidPicker(NoiseGeneratorSettings p_249264_, CallbackInfoReturnable<Aquifer.FluidPicker> cir)
    {
        Aquifer.FluidStatus $$1 = new Aquifer.FluidStatus(-118, Blocks.LAVA.defaultBlockState());
        int $$2 = p_249264_.seaLevel();
        Aquifer.FluidStatus $$3 = new Aquifer.FluidStatus($$2, p_249264_.defaultFluid());
        Aquifer.FluidStatus $$4 = new Aquifer.FluidStatus(DimensionType.MIN_Y * 2, Blocks.AIR.defaultBlockState());
        cir.setReturnValue((p_224274_, p_224275_, p_224276_) -> {
            return p_224275_ < Math.min(-118, $$2) ? $$1 : $$3;
        });
    }
}
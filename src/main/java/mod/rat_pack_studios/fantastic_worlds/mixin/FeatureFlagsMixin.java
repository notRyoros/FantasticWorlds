package mod.rat_pack_studios.fantastic_worlds.mixin;

import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FeatureFlags.class)
public class FeatureFlagsMixin {
    @Shadow @Final public static FeatureFlag REDSTONE_EXPERIMENTS;

    @Shadow @Final public static FeatureFlag TRADE_REBALANCE;

    @Shadow @Final public static FeatureFlag MINECART_IMPROVEMENTS;

    @Redirect(method = "isExperimental", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/flag/FeatureFlagSet;isSubsetOf(Lnet/minecraft/world/flag/FeatureFlagSet;)Z"))
    private static boolean redirectedIsExperimental(FeatureFlagSet instance, FeatureFlagSet featureFlagSet) {
        if (featureFlagSet.contains(MINECART_IMPROVEMENTS) || featureFlagSet.contains(TRADE_REBALANCE) || featureFlagSet.contains(REDSTONE_EXPERIMENTS))
        {
            return true;
        }
        return false;
    }
}

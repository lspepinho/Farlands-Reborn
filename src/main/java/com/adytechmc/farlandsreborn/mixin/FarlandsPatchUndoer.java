package com.adytechmc.farlandsreborn.mixin;

import net.minecraft.util.math.noise.OctavePerlinNoiseSampler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OctavePerlinNoiseSampler.class)
public class FarlandsPatchUndoer {
    private static final double FARLANDS_PRECISION = 5.3406656E1;

    @Inject(method = "maintainPrecision", at = @At("HEAD"), cancellable = true)
    private static void injectMethod(double value, CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue(value - (double) net.minecraft.util.math.MathHelper.lfloor(value / FARLANDS_PRECISION + 0.5) * FARLANDS_PRECISION);
    }
}

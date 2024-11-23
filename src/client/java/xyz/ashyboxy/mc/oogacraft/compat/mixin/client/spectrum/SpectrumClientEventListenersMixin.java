package xyz.ashyboxy.mc.oogacraft.compat.mixin.client.spectrum;

import com.llamalad7.mixinextras.sugar.Local;
import de.dafuqs.spectrum.registries.client.SpectrumClientEventListeners;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SpectrumClientEventListeners.class)
public class SpectrumClientEventListenersMixin {
    // if the camera entity has a null block pos then spectrum will crash trying to call getBiome
    @Inject(method = "lambda$register$8", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/world/ClientWorld;getBiome(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/registry/entry/RegistryEntry;"), cancellable = true)
    private static void oogacraftCompat$cancelOnNullCameraBlockPos(MinecraftClient client, CallbackInfo ci,
                                                                   @Local Entity cameraEntity) {
        if (cameraEntity.getBlockPos() == null) ci.cancel();
    }
}

package com.mystic.flatopdimension;

import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FlatEventHandler {

    @SubscribeEvent
    public static void onDimensionModRegistry(RegistryEvent.Register<ModDimension> event) {
        event.getRegistry().register(Main.dimension);
        DimensionManager.registerDimension(Main.FLAT_DIM, Main.dimension, null, true);
    }

    @SubscribeEvent
    public static void onChunkGeneratorTypeRegistry(RegistryEvent.Register<ChunkGeneratorType<?, ?>> event) {
        event.getRegistry().register(Main.generatorType.setRegistryName(Main.MODID, "generator"));
    }

    @SubscribeEvent
    public static void onBiomeProviderTypeRegistry(RegistryEvent.Register<BiomeProviderType<?, ?>> event) {
        event.getRegistry().register(Main.biomeProviderType.setRegistryName(Main.MODID, "generator"));
    }
}
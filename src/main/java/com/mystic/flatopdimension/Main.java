package com.mystic.flatopdimension;

import java.util.function.BiFunction;

import com.mystic.flatopdimension.config.FlatConfig;
import com.mystic.flatopdimension.dimension.FlatBiomeProvider;
import com.mystic.flatopdimension.dimension.FlatChunkGenerators;
import com.mystic.flatopdimension.dimension.FlatDimension;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;


@Mod("flat")
public class Main {

    public static final String MODID = "flat";
    public static final ResourceLocation FLAT_DIM = new ResourceLocation(MODID, "fun_dun_dimension");

    public static ModDimension dimension = new ModDimension() {
        @Override
        public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
            return FlatDimension::new;
        }
    }.setRegistryName(FLAT_DIM);

    public static ChunkGeneratorType<GenerationSettings, FlatChunkGenerators> generatorType = new ChunkGeneratorType<>(FlatChunkGenerators::new, false, GenerationSettings::new);
    public static BiomeProviderType<SingleBiomeProviderSettings, FlatBiomeProvider> biomeProviderType = new BiomeProviderType<>(FlatBiomeProvider::new, SingleBiomeProviderSettings::new);

    

    public Main() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FlatConfig.configSpec);
    }
}

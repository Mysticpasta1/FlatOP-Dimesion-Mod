package com.mystic.flatopdimension.dimension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.gen.feature.structure.Structure;

public class FlatBiomeProvider extends BiomeProvider {

    private final Biome biome;
    private static final List<Biome> SPAWN = Collections.singletonList(Biomes.PLAINS);

    public FlatBiomeProvider(SingleBiomeProviderSettings settings) {
        biome = Biomes.PLAINS;
    }

    @Override
    public Biome getBiome(int x, int y) {
        return biome;
    }
   
    
    @Override
    public List<Biome> getBiomesToSpawnIn() {
        return SPAWN;
    }

    @Override
    public Set<BlockState> getSurfaceBlocks() {
        if (topBlocksCache.isEmpty()) {
            topBlocksCache.add(biome.getSurfaceBuilderConfig().getTop());
        }

        return topBlocksCache;
    }


	@Override
	public Set<Biome> getBiomesInSquare(int centerX, int centerZ, int sideLength) {
		return Collections.singleton(biome);
	}

	@Override
	public BlockPos findBiomePosition(int x, int y, int radius, List<Biome> biomes, Random random) {
		
		return new BlockPos(x, 65, y); 
	}

	@Override
	public boolean hasStructure(Structure<?> structureIn) {
		return false;
	}

	@Override
	public Biome[] getBiomes(int x, int z, int width, int length, boolean cacheFlag) {
		Biome[] biomes = new Biome[width * length];
		Arrays.fill(biomes, biome);
		return biomes;
	}
}
package com.mystic.flatopdimension.setup;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class ClientProxy implements IProxy{

	@SuppressWarnings("resource")
	@Override
	public World getClientWorld() {
		return Minecraft.getInstance().world;
	}

}

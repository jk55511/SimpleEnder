package com.SimpleEnder.TileEntity;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityEnderChest;

public class TileEntityTunedEnderChest extends TileEntityEnderChest{
	private UUID tunedPlayer;
	
	public UUID getTunedUUID() {
		return tunedPlayer;
	}
	
	public void setTunedUUID(EntityPlayer player) {
		tunedPlayer = player.getPersistentID();
	}
}

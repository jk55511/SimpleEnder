package com.SimpleEnder;

import java.util.Objects;

import org.apache.logging.log4j.Logger;

import com.SimpleEnder.Blocks.BlockTunedEnderChest;
import com.SimpleEnder.TileEntity.TileEntityTunedEnderChest;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class SimpleEvents extends Event{
	
	private static BlockTunedEnderChest TEC;
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		TEC = new BlockTunedEnderChest();
		TEC.setRegistryName("simpleender", "tuned_ender_chest");
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(new ItemBlock(TEC).setRegistryName(TEC.getRegistryName()));;
		
	}
	
	
}

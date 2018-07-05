package com.SimpleEnder;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.Logger;

import com.SimpleEnder.TileEntity.TileEntityTunedEnderChest;

@Mod(modid = SimpleEnder.MODID, name = SimpleEnder.NAME, version = SimpleEnder.VERSION)
public class SimpleEnder
{
    public static final String MODID = "simpleender";
    public static final String NAME = "Simple Ender";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        GameRegistry.registerTileEntity(TileEntityTunedEnderChest.class, "simpleender:tuned_ender_chest");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("Loading SimpleEnder");
    }
    
    @EventHandler
	public void registerCommands(FMLServerStartingEvent event) {
		event.registerServerCommand(new OpenEnder());
	}
    
}

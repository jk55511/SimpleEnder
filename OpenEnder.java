package com.SimpleEnder;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.StatList;

public class OpenEnder extends CommandBase {
	
	@Override
	public String getName() {
		return "ender";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		if (sender.getEntityWorld().isRemote) {
	        return "/simpleender";
	    } else {
	        return "/simpleender";
	    }
	}
	
	@Override
	public List<String> getAliases() {
		ArrayList<String> all = new ArrayList<String>();
		all.add("ender");
		return all;
	}
	
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length > 1)
        {
            throw new WrongUsageException("commands.ender.usage", new Object[0]);
        }
		else if(args.length == 0){	
			EntityPlayer player = this.getCommandSenderAsPlayer(sender);
			player.displayGUIChest(player.getInventoryEnderChest());
			player.addStat(StatList.ENDERCHEST_OPENED);
		}
		else if(args.length == 1) {
			EntityPlayer player1 = this.getCommandSenderAsPlayer(sender);
			EntityPlayer player = (EntityPlayer)getEntity(server, sender, args[0]);
			player1.displayGUIChest(player.getInventoryEnderChest());
			player1.addStat(StatList.ENDERCHEST_OPENED);
		}
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
	    return true;
	}
	

}

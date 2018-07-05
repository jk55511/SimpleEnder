package com.SimpleEnder.Blocks;

import com.SimpleEnder.TileEntity.TileEntityTunedEnderChest;

import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTunedEnderChest extends BlockEnderChest {
	
	private EntityPlayer tunedPlayer;
	
	public BlockTunedEnderChest(){
		
	}
	
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		TileEntityTunedEnderChest tileentity =(TileEntityTunedEnderChest) worldIn.getTileEntity(pos);
		try{
			tunedPlayer = (EntityPlayer) worldIn.getMinecraftServer().getEntityFromUuid(tileentity.getTunedUUID());
		}catch(Exception e) {
			tileentity.setTunedUUID(playerIn);
			tunedPlayer = playerIn;
		}
		InventoryEnderChest inventoryenderchest = tunedPlayer.getInventoryEnderChest();
        if (inventoryenderchest != null && tileentity instanceof TileEntityTunedEnderChest)
        {
            if (worldIn.getBlockState(pos.up()).doesSideBlockChestOpening(worldIn, pos.up(), EnumFacing.DOWN))
            {
                return true;
            }
            else if (worldIn.isRemote)
            {
                return true;
            }
            else
            {
                inventoryenderchest.setChestTileEntity((TileEntityTunedEnderChest)tileentity);
                playerIn.displayGUIChest(inventoryenderchest);
                playerIn.addStat(StatList.ENDERCHEST_OPENED);
                return true;
            }
        }
        else
        {
            return true;
        }
    }
	
	public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityTunedEnderChest();
    }
	
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
       super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
       TileEntityTunedEnderChest tileentity =(TileEntityTunedEnderChest) worldIn.getTileEntity(pos);
       tileentity.setTunedUUID((EntityPlayer)placer);
    }

}

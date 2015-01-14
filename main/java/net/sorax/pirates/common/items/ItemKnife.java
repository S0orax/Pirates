package net.sorax.pirates.common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.sorax.pirates.common.entities.EntityKnife;

public class ItemKnife extends Item {
	
	public ItemKnife() {
		this.maxStackSize = 32;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if(!playerIn.capabilities.isCreativeMode) {
			--itemStackIn.stackSize;
		}
		
		worldIn.playSoundAtEntity(playerIn, "pirates:knife", 1.0f, 1.0f);
		
		if(!worldIn.isRemote)
			worldIn.spawnEntityInWorld(new EntityKnife(worldIn, playerIn));
		
		return itemStackIn;
	}
}

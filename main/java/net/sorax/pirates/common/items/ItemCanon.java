package net.sorax.pirates.common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.sorax.pirates.common.entities.EntityBoulet;

public class ItemCanon extends Item{
	
	public ItemCanon() {
		this.maxStackSize = 1;
	}
	
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if(playerIn.capabilities.isCreativeMode || playerIn.inventory.hasItem(ItemPirates.boulet)) {
			worldIn.playSoundAtEntity(playerIn, "pirates:canon", 1.0f, 1.0f);
			playerIn.inventory.consumeInventoryItem(ItemPirates.boulet);
			EntityBoulet boulet = new EntityBoulet(worldIn, playerIn);
			worldIn.spawnEntityInWorld(boulet);
		}
		
		return itemStackIn;
	}
}

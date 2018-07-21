package com.sorax.pirates.common.items;

import com.sorax.pirates.client.PirateSounds;
import com.sorax.pirates.common.entities.EntityBoulet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemCanon extends Item{
	
	public ItemCanon() {
		this.maxStackSize = 1;
	}
	
	private ItemStack findAmmo(EntityPlayer player) {
		for(int i = 0; i< player.inventory.getSizeInventory(); i++) {
			ItemStack itemstack = player.inventory.getStackInSlot(i);
			if(itemstack.getItem() == ItemPirates.boulet) {
				return itemstack;
			}
		}
		return ItemStack.EMPTY;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemStackIn = playerIn.getHeldItem(handIn);
		ItemStack ammo = this.findAmmo(playerIn);
		boolean hasAmmo = !ammo.isEmpty();
		
		if(playerIn.capabilities.isCreativeMode || !hasAmmo) {
			return hasAmmo ? new ActionResult<ItemStack>(EnumActionResult.PASS, itemStackIn) : new ActionResult<ItemStack>(EnumActionResult.FAIL, itemStackIn);
		} else {
			worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, PirateSounds.CANON, SoundCategory.NEUTRAL, 1.0f, 1.0f);
			ammo.shrink(1);
			EntityBoulet boulet = new EntityBoulet(worldIn, playerIn);
			worldIn.spawnEntity(boulet);
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
		}
		
	}
}

package com.sorax.pirates.common.items;

import java.util.Random;

import com.sorax.pirates.client.PirateSounds;
import com.sorax.pirates.common.entities.EntityFusilBullet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemFusil extends Item {

	public ItemFusil() {
		this.maxStackSize = 1;
	}
	
	private ItemStack findAmmo(EntityPlayer player) {
		for(int i = 0; i< player.inventory.getSizeInventory(); i++) {
			ItemStack itemstack = player.inventory.getStackInSlot(i);
			if(itemstack.getItem() == ItemPirates.munition) {
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
		if (!playerIn.capabilities.isCreativeMode && !hasAmmo) {
            return hasAmmo ? new ActionResult<ItemStack>(EnumActionResult.PASS, itemStackIn) : new ActionResult<ItemStack>(EnumActionResult.FAIL, itemStackIn);
        } else {
        	worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, PirateSounds.FUSIL, SoundCategory.NEUTRAL, 1.0f, 1.0f);
        	
        	Random rand = new Random();
        	for (int i = 0; i < 16; i++) {
        		worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, playerIn.posX + rand.nextDouble() - 0.5D,
        				playerIn.posY + 0.75D + rand.nextDouble(), playerIn.posZ + rand.nextDouble() - 0.5D, 0.0D, 0.0D,
        				0.0D, new int[0]);
        	}
        	worldIn.spawnEntity(new EntityFusilBullet(worldIn, playerIn));
        	
        	ammo.shrink(1);
        	playerIn.setActiveHand(handIn);
        	return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
        }

	}
}

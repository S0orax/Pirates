package com.sorax.pirates.common.items;

import com.sorax.pirates.client.PirateSounds;
import com.sorax.pirates.common.entities.EntityKnife;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemKnife extends Item {
	
	public ItemKnife() {
		this.maxStackSize = 32;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemStackIn = playerIn.getHeldItem(handIn);
		
		if(!playerIn.capabilities.isCreativeMode) {
			itemStackIn.shrink(1);
		}
		
		worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, PirateSounds.KNIFE, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		
		if(!worldIn.isRemote)
			worldIn.spawnEntity(new EntityKnife(worldIn, playerIn));
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
	}
}

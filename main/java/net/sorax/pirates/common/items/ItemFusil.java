package net.sorax.pirates.common.items;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.sorax.pirates.common.entities.EntityFusilBullet;

public class ItemFusil extends Item {

		public ItemFusil() {
			this.maxStackSize = 1;
		}
		
		public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
			if(playerIn.capabilities.isCreativeMode || playerIn.inventory.hasItem(ItemPirates.munition)) {
								
				worldIn.playSoundAtEntity(playerIn, "pirates:fusil", 1.0f, 1.0f);
					
				Random rand = new Random();
				for(int i = 0; i < 16; i++) {
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, playerIn.posX + rand.nextDouble() - 0.5D, playerIn.posY + 0.75D + rand.nextDouble(), playerIn.posZ + rand.nextDouble() - 0.5D, 0.0D, 0.0D, 0.0D, new int[0]);
				}
				worldIn.spawnEntityInWorld(new EntityFusilBullet(worldIn, playerIn));
				
				playerIn.inventory.consumeInventoryItem(ItemPirates.munition);
			}
			
			return itemStackIn;
		}
}

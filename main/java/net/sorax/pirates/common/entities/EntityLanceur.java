package net.sorax.pirates.common.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityLanceur extends EntityMob implements IRangedAttackMob {

	public EntityLanceur(World world) {
		super(world);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entity, float f) {
		EntityKnife knife = new EntityKnife(this.worldObj, this);
		this.worldObj.spawnEntityInWorld(knife);
	}
	
	
}

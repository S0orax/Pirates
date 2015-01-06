package net.sorax.pirates.common.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityKnife extends EntityThrowable{

	public EntityKnife(World world) {
		super(world);
	}
	
	public EntityKnife(World world, EntityLivingBase entity) {
		super(world, entity);
	}
	
	public EntityKnife(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if (mop.entityHit != null) {
			mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 3f);
		}

		System.out.println("Test");
		
		if(!this.worldObj.isRemote) {
			this.setDead();
		}
	}

}

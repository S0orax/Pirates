package com.sorax.pirates.common.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityFusilBullet extends EntityThrowable{

	public EntityFusilBullet(World world) {
		super(world);
	}
	
	public EntityFusilBullet(World world, EntityLivingBase entity) {
		super(world, entity);
	}
	
	public EntityFusilBullet(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if(result.entityHit != null) {
			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 10f);
		}
		
		if(!this.world.isRemote) {
			this.setDead();
		}
	}

}

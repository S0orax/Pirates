package net.sorax.pirates.common.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBoulet extends EntityThrowable{

	public EntityBoulet(World world) {
		super(world);
	}
	
	public EntityBoulet(World world, EntityLivingBase entity) {
		super(world, entity);
	}
	
	public EntityBoulet(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if(!worldObj.isRemote) {
			worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3, true);
			this.setDead();
		}
	}

}

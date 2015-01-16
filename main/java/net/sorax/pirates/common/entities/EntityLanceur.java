package net.sorax.pirates.common.entities;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.sorax.pirates.common.items.ItemPirates;

public class EntityLanceur extends EntityMob implements IRangedAttackMob {

	private String[] lanceurTexture = {"textures/entities/mob/lanceur1.png", "textures/entities/mob/lanceur2.png", "textures/entities/mob/lanceur3.png"};
	
	public EntityLanceur(World world) {
		super(world);
		((PathNavigateGround)this.getNavigator()).func_179690_a(true);
        this.tasks.addTask(1, new EntityAIArrowAttack(this, 1.25D, 20, 10.0F));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.setLanceurType(this.getRNG().nextInt(3));
        this.setCurrentItemOrArmor(0, new ItemStack(ItemPirates.couteau));
	}
	
	protected void entityInit() {
		super.entityInit();
		this.getDataWatcher().addObject(12, Byte.valueOf((byte)0));
	}
	
	public void setLanceurType(int type) {
		this.getDataWatcher().updateObject(12, Byte.valueOf((byte)type));
	}
	
	public int getLanceurType() {
		return this.getDataWatcher().getWatchableObjectByte(12);
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
    }
	
	protected String getLivingSound()
    {
		String[] ambiants = {"ambiant1", "ambiant2", "ambiant3"};
		String ambiant = ambiants[this.rand.nextInt(3)];
        return "pirates:mob.pirate." + ambiant;
    }

    protected String getHurtSound()
    {
        return "pirates:mob.pirate.hurt";
    }

    protected String getDeathSound()
    {
        return "pirates:mob.pirate.death";
    }
	
	public void writeEntityToNBT(NBTTagCompound tagCompound) {
		super.writeEntityToNBT(tagCompound);
		tagCompound.setInteger("Type", this.getLanceurType());
	}
	
	public void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		this.setLanceurType(tagCompund.getInteger("Type"));
	}
	
	public String getTexture() {
		int i = this.getLanceurType();
		return this.lanceurTexture[i];
	}
	
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entity, float f) {
		EntityKnife knife = new EntityKnife(this.worldObj, this);
		double d0 = entity.posY + (double)entity.getEyeHeight() - 1.100000023841858D;
		double d1 = entity.posX - this.posX;
		double d2 = d0 - this.posY;
		double d3 = entity.posZ - this.posZ;
		float f1 = MathHelper.sqrt_double(d1 * d1 + d3 * d3) * 0.2f;
		knife.setThrowableHeading(d1, d2 * (double)f1, d3, 1.6f, 12f);
		this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(knife);
	}
	
	
}

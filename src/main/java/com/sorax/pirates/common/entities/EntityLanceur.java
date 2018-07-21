package com.sorax.pirates.common.entities;

import com.sorax.pirates.client.PirateSounds;
import com.sorax.pirates.common.items.ItemPirates;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityLanceur extends EntityMob implements IRangedAttackMob {
	
	private static final DataParameter<Byte> VARIANT = EntityDataManager.<Byte>createKey(EntityLanceur.class, DataSerializers.BYTE);
	private String[] lanceurTexture = {"textures/entities/mob/lanceur1.png", "textures/entities/mob/lanceur2.png", "textures/entities/mob/lanceur3.png"};
	
	public EntityLanceur(World world) {
		super(world);
        this.setLanceurType(this.getRNG().nextInt(3));
	}
	
	protected void initEntityAI() {
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, true));
	}
	
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(VARIANT, Byte.valueOf((byte)0));
	}
	
	public void setLanceurType(int type) {
		this.dataManager.set(VARIANT, Byte.valueOf((byte)type));
	}
	
	public int getLanceurType() {
		return this.dataManager.get(VARIANT);
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
    }
	
	@Override
	protected SoundEvent getAmbientSound()
    {
        return PirateSounds.PIRATE_AMBIANT;
    }

	@Override
    protected SoundEvent getHurtSound(DamageSource d)
    {
        return PirateSounds.PIRATE_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return PirateSounds.PIRATE_DEATH;
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
		EntityKnife knife = new EntityKnife(this.world, this);
		double d0 = entity.posY + (double)entity.getEyeHeight() - 1.100000023841858D;
		double d1 = entity.posX - this.posX;
		double d2 = d0 - this.posY;
		double d3 = entity.posZ - this.posZ;
		float f1 = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2f;
		knife.setThrowableHeading(d1, d2 * (double)f1, d3, 1.6f, 12f);
		this.playSound(SoundEvents.ENTITY_SNOWBALL_THROW, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.world.spawnEntity(knife);
	}
	
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ItemPirates.couteau));
    }

	@Override
	public void setSwingingArms(boolean swingingArms) {
		// TODO Auto-generated method stub
		
	}
}

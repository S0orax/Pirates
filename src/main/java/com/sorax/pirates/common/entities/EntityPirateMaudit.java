package com.sorax.pirates.common.entities;

import com.sorax.pirates.client.PirateSounds;
import com.sorax.pirates.common.items.ItemPirates;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityPirateMaudit extends EntityMob {
	
	private static final DataParameter<Byte> MALEDICTION = EntityDataManager.<Byte>createKey(EntityPirateMaudit.class, DataSerializers.BYTE);
	
	public EntityPirateMaudit(World world) {
		super(world);        
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIBreakDoor(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.applyEntityAI();
	}
	
	protected void applyEntityAI()
    {
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, true));
    }
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
	}
	
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(MALEDICTION, Byte.valueOf((byte)0));
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
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return PirateSounds.PIRATE_DEATH;
    }
	
	private void setMalediction(boolean malediction) {
		this.dataManager.set(MALEDICTION, Byte.valueOf((byte)(malediction ? 1 : 0)));
	}
	
	public void onLivingUpdate() {
		BlockPos pos = new BlockPos(this.posX, this.posY, this.posZ);
		
		if(!this.world.isDaytime() && this.world.canSeeSky(pos) && !this.world.isRaining() 
				&& !this.world.isRemote && !this.isInMoon()) {
			setMalediction(true);
		} else if ((this.world.isDaytime() || this.isInMoon() && (!this.world.canSeeSky(pos) || this.world.isRaining())) && !this.world.isRemote) 
			setMalediction(false);
		
		super.onLivingUpdate();
	}
	
	 public boolean attackEntityFrom(DamageSource source, float amount) {
		 float prevHealth = this.getHealth();
		 if(super.attackEntityFrom(source, amount)) {
			if(isInMoon()) {
				this.setHealth(prevHealth);
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	protected Item getDropItem() {
		return Items.IRON_INGOT;
	}
	
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        int j = this.rand.nextInt(2) + this.rand.nextInt(1 + p_70628_2_);
        int k;

        for (k = 0; k < j; ++k)
        {
            this.dropItem(ItemPirates.medaillon, 1);
        }

        j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);

        for (k = 0; k < j; ++k)
        {
            this.dropItem(Items.IRON_INGOT, 1);
        }
    }
	
	protected int getExperiencePoints(EntityPlayer player) {
		return super.getExperiencePoints(player);
	}
	
	public boolean isInMoon() {
		return this.dataManager.get(MALEDICTION) == 1;
	}
	
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
    }
}

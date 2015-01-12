package net.sorax.pirates.common.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.sorax.pirates.common.items.ItemPirates;

public class EntityPirateMaudit extends EntityMob{
	
	public EntityPirateMaudit(World world) {
		super(world);
		((PathNavigateGround)this.getNavigator()).func_179688_b(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIBreakDoor(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(2, this.field_175455_a);
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.applyEntityAI();
	}
	
	protected void applyEntityAI()
    {
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
	}
	
	protected void entityInit() {
		super.entityInit();
		this.getDataWatcher().addObject(12, Byte.valueOf((byte)0));
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
	
	private void setMalediction(boolean malediction) {
		this.getDataWatcher().updateObject(12, Byte.valueOf((byte)(malediction ? 1 : 0)));
	}
	
	public void onLivingUpdate() {
		BlockPos pos = new BlockPos(this.posX, this.posY, this.posZ);
		
		if(!this.worldObj.isDaytime() && this.worldObj.canSeeSky(pos) && !this.worldObj.isRaining() 
				&& !this.worldObj.isRemote && !this.isInMoon()) {
			setMalediction(true);
		} else if ((this.worldObj.isDaytime() || this.isInMoon() && (!this.worldObj.canSeeSky(pos) || this.worldObj.isRaining())) && !this.worldObj.isRemote) 
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
		return Items.iron_ingot;
	}
	
	protected int getExperiencePoints(EntityPlayer player) {
		return super.getExperiencePoints(player);
	}
	
	protected void func_180481_a(DifficultyInstance p_180481_1_) {
		super.func_180481_a(p_180481_1_);
		
		if (this.rand.nextFloat() < (this.worldObj.getDifficulty() == EnumDifficulty.HARD ? 0.05F : 0.01F)) {
            int i = this.rand.nextInt(3);

            if (i == 0)
            {
                this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
            }
            else
            {
                this.setCurrentItemOrArmor(0, new ItemStack(ItemPirates.medaillon));
            }
        }
		
		this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
	}
	
	public boolean isInMoon() {
		return this.getDataWatcher().getWatchableObjectByte(12) == 1;
	}
}

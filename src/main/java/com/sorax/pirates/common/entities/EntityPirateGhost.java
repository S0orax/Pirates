package com.sorax.pirates.common.entities;

import java.util.Random;

import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityPirateGhost extends EntityFlying implements IMob {

	public EntityPirateGhost(World world) {
		super(world);
		this.noClip = true;
		this.moveHelper = new EntityPirateGhost.PirateGhostMoveHelper();
		this.tasks.addTask(1, new EntityPirateGhost.AIRandomFlying(this));
	}
	
	class AIRandomFlying extends EntityAIBase {
		
		private EntityPirateGhost ghost = EntityPirateGhost.this;
		
		public AIRandomFlying(EntityPirateGhost ghost) {
			this.setMutexBits(1);
		}
		
		@Override
		public boolean shouldExecute() {
			EntityMoveHelper entitymovehelper = this.ghost.getMoveHelper();

            if (!entitymovehelper.isUpdating())
            {
                return true;
            }
            else
            {
                double d0 = entitymovehelper.getX() - this.ghost.posX;
                double d1 = entitymovehelper.getY() - this.ghost.posY;
                double d2 = entitymovehelper.getZ() - this.ghost.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                return d3 < 1.0D || d3 > 3600.0D;
            }
		}
		
		public boolean continueExecuting() {
			return false;
		}
		
		public void startExecuting() {
			Random random = this.ghost.getRNG();
            double d0 = this.ghost.posX + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d1 = this.ghost.posY + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d2 = this.ghost.posZ + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.ghost.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
		}
	}
	
	class PirateGhostMoveHelper extends EntityMoveHelper
    {
        private EntityPirateGhost ghost = EntityPirateGhost.this;
        private int field_179928_h;
        private static final String __OBFID = "CL_00002216";

        public PirateGhostMoveHelper()
        {
            super(EntityPirateGhost.this);
        }

        public void onUpdateMoveHelper()
        {
            if (this.isUpdating())
            {
                double d0 = this.posX - this.ghost.posX;
                double d1 = this.posY - this.ghost.posY;
                double d2 = this.posZ - this.ghost.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;

                if (this.field_179928_h-- <= 0)
                {
                    this.field_179928_h += this.ghost.getRNG().nextInt(5) + 2;
                    d3 = (double)MathHelper.sqrt(d3);

                    if (this.func_179926_b(this.posX, this.posY, this.posZ, d3))
                    {
                        this.ghost.motionX += d0 / d3 * 0.1D;
                        this.ghost.motionY += d1 / d3 * 0.1D;
                        this.ghost.motionZ += d2 / d3 * 0.1D;
                    }
                    else
                    {
                        this.action = Action.WAIT;
                    }
                }
            }
        }

        private boolean func_179926_b(double p_179926_1_, double p_179926_3_, double p_179926_5_, double p_179926_7_)
        {
            double d4 = (p_179926_1_ - this.ghost.posX) / p_179926_7_;
            double d5 = (p_179926_3_ - this.ghost.posY) / p_179926_7_;
            double d6 = (p_179926_5_ - this.ghost.posZ) / p_179926_7_;
            AxisAlignedBB axisalignedbb = this.ghost.getEntityBoundingBox();

            for (int i = 1; (double)i < p_179926_7_; ++i)
            {
                axisalignedbb = axisalignedbb.offset(d4, d5, d6);

                if (!this.ghost.world.getCollisionBoxes(this.ghost, axisalignedbb).isEmpty())
                {
                    return false;
                }
            }

            return true;
        }
    }
}

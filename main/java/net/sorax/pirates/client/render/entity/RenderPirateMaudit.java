package net.sorax.pirates.client.render.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.sorax.pirates.common.entities.EntityPirateMaudit;

@SideOnly(Side.CLIENT)
public class RenderPirateMaudit extends RenderBiped {
	
	private ResourceLocation pirate = new ResourceLocation("pirates", "textures/entities/mob/pirate_maudit_off.png");
	private ResourceLocation pirate_moon = new ResourceLocation("pirates", "textures/entities/mob/pirate_maudit_on.png");
	
	public RenderPirateMaudit(RenderManager p_i46168_1_, ModelBiped p_i46168_2_, float p_i46168_3_) {
		super(p_i46168_1_, p_i46168_2_, p_i46168_3_);
		this.addLayer(new LayerBipedArmor(this));
        this.addLayer(new LayerHeldItem(this));
	}
	
	protected ResourceLocation getEntityTexture(Entity entity) {
		return getEntityTexture((EntityLiving)entity);
	}
	
	protected ResourceLocation getEntityTexture(EntityLiving living) {
		return getPirateMauditTexture((EntityPirateMaudit)living);
	}
	
	private ResourceLocation getPirateMauditTexture(EntityPirateMaudit entity) {
		return entity.isInMoon() ? pirate_moon : pirate;
	}
	
	public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
        super.doRender((EntityPirateMaudit)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
    	super.doRender((EntityPirateMaudit)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
    	super.doRender((EntityPirateMaudit)entity, x, y, z, p_76986_8_, partialTicks);
    }
	
}

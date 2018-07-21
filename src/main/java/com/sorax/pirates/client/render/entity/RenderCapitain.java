package com.sorax.pirates.client.render.entity;

import com.sorax.pirates.common.entities.EntityCapitain;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderCapitain extends RenderBiped {
	
	private ResourceLocation texture = new ResourceLocation("pirates", "textures/entities/mob/capitaine.png");
	private float scale;
	
	public RenderCapitain(float p_i46168_3_, float scale) {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), p_i46168_3_ * scale);
		this.addLayer(new LayerBipedArmor(this));
        this.addLayer(new LayerHeldItem(this));
        this.scale = scale;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity) {
		return getEntityTexture((EntityLiving)entity);
	}
	
	protected ResourceLocation getEntityTexture(EntityLiving living) {
		return getPirateMauditTexture((EntityCapitain)living);
	}
	
	private ResourceLocation getPirateMauditTexture(EntityCapitain entity) {
		return this.texture;
	}
	
	protected void preRender(EntityCapitain entity, float f) {
		GlStateManager.scale(this.scale, this.scale, this.scale);		
	}
	
	protected void preRenderCallback(EntityLivingBase entity, float f) {
		this.preRender((EntityCapitain)entity, f);
	}
	
	public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
        super.doRender((EntityCapitain)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
    	super.doRender((EntityCapitain)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
    	super.doRender((EntityCapitain)entity, x, y, z, p_76986_8_, partialTicks);
    }

}

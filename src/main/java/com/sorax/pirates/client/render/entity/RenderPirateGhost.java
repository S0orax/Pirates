package com.sorax.pirates.client.render.entity;

import com.sorax.pirates.common.entities.EntityPirateGhost;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderPirateGhost extends RenderBiped {
	
	private ResourceLocation texture = new ResourceLocation("pirates", "textures/entities/mob/pirate_fantome.png");
	
	public RenderPirateGhost(float p_i46168_3_) {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), p_i46168_3_);
		this.addLayer(new LayerBipedArmor(this));
        this.addLayer(new LayerHeldItem(this));
	}
	
	protected ResourceLocation getEntityTexture(Entity entity) {
		return getEntityTexture((EntityLiving)entity);
	}
	
	protected ResourceLocation getEntityTexture(EntityLiving living) {
		return getPirateMauditTexture((EntityPirateGhost)living);
	}
	
	private ResourceLocation getPirateMauditTexture(EntityPirateGhost entity) {
		return this.texture;
	}
	
	public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
        super.doRender((EntityPirateGhost)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
    	super.doRender((EntityPirateGhost)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
    	super.doRender((EntityPirateGhost)entity, x, y, z, p_76986_8_, partialTicks);
    }
}

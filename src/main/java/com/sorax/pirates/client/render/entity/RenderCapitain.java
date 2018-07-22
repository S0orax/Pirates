package com.sorax.pirates.client.render.entity;

import com.sorax.pirates.common.entities.EntityCapitain;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderCapitain extends RenderBiped<EntityCapitain> {
	
	private ResourceLocation texture = new ResourceLocation("pirates", "textures/entities/mob/capitaine.png");
	private float scale;
	
	public RenderCapitain(RenderManager renderManager, float p_i46168_3_, float scale) {
		super(renderManager, new ModelBiped(), p_i46168_3_ * scale);
		this.addLayer(new LayerBipedArmor(this));
        this.addLayer(new LayerHeldItem(this));
        this.scale = scale;
	}
	
	protected ResourceLocation getEntityTexture(EntityCapitain living) {
		return getPirateMauditTexture(living);
	}
	
	private ResourceLocation getPirateMauditTexture(EntityCapitain entity) {
		return this.texture;
	}
	
	protected void preRender(EntityCapitain entity, float f) {
		GlStateManager.scale(this.scale, this.scale, this.scale);		
	}
	
	protected void preRenderCallback(EntityCapitain entity, float f) {
		this.preRender(entity, f);
	}
	
	public void doRender(EntityCapitain entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
        super.doRender(entity, x, y, z, p_76986_8_, partialTicks);
    }

}

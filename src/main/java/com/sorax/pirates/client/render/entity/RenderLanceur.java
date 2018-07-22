package com.sorax.pirates.client.render.entity;

import com.sorax.pirates.common.entities.EntityLanceur;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderLanceur extends RenderBiped<EntityLanceur>{

	public RenderLanceur(RenderManager p_i46168_1_, ModelBiped p_i46168_2_, float p_i46168_3_) {
		super(p_i46168_1_, p_i46168_2_, p_i46168_3_);
		this.addLayer(new LayerBipedArmor(this));
        this.addLayer(new LayerHeldItem(this));
	}
	
	protected ResourceLocation getEntityTexture(EntityLanceur living) {
		return getLanceurTexture(living);
	}
	
	private ResourceLocation getLanceurTexture(EntityLanceur entity) {
		return new ResourceLocation("pirates", entity.getTexture());
	}
	
	public void doRender(EntityLanceur entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
        super.doRender(entity, x, y, z, p_76986_8_, partialTicks);
        
    }

}

package net.sorax.pirates.client.render.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.sorax.pirates.common.entities.EntityLanceur;
import net.sorax.pirates.common.entities.EntityPirateMaudit;

public class RenderLanceur extends RenderBiped{

	public RenderLanceur(RenderManager p_i46168_1_, ModelBiped p_i46168_2_, float p_i46168_3_) {
		super(p_i46168_1_, p_i46168_2_, p_i46168_3_);
		this.addLayer(new LayerBipedArmor(this));
        this.addLayer(new LayerHeldItem(this));
	}
	
	protected ResourceLocation getEntityTexture(Entity entity) {
		return getEntityTexture((EntityLiving)entity);
	}
	
	protected ResourceLocation getEntityTexture(EntityLiving living) {
		return getLanceurTexture((EntityLanceur)living);
	}
	
	private ResourceLocation getLanceurTexture(EntityLanceur entity) {
		return new ResourceLocation("pirates", entity.getTexture());
	}
	
	public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
        super.doRender((EntityLanceur)entity, x, y, z, p_76986_8_, partialTicks);
        
    }

}

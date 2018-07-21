package com.sorax.pirates.client;

import com.sorax.pirates.client.render.entity.RenderBoulet;
import com.sorax.pirates.client.render.entity.RenderCapitain;
import com.sorax.pirates.client.render.entity.RenderFusilBullet;
import com.sorax.pirates.client.render.entity.RenderKnife;
import com.sorax.pirates.client.render.entity.RenderLanceur;
import com.sorax.pirates.client.render.entity.RenderPirateGhost;
import com.sorax.pirates.client.render.entity.RenderPirateMaudit;
import com.sorax.pirates.common.CommonProxy;
import com.sorax.pirates.common.entities.EntityBoulet;
import com.sorax.pirates.common.entities.EntityCapitain;
import com.sorax.pirates.common.entities.EntityFusilBullet;
import com.sorax.pirates.common.entities.EntityKnife;
import com.sorax.pirates.common.entities.EntityLanceur;
import com.sorax.pirates.common.entities.EntityPirateGhost;
import com.sorax.pirates.common.entities.EntityPirateMaudit;
import com.sorax.pirates.common.items.ItemPirates;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityBoulet.class, this.<EntityBoulet>createRenderer(new RenderBoulet(Minecraft.getMinecraft().getRenderManager(), ItemPirates.boulet, Minecraft.getMinecraft().getRenderItem())));
		RenderingRegistry.registerEntityRenderingHandler(EntityKnife.class, this.<EntityKnife>createRenderer(new RenderKnife(Minecraft.getMinecraft().getRenderManager(), ItemPirates.couteau, Minecraft.getMinecraft().getRenderItem())));
		RenderingRegistry.registerEntityRenderingHandler(EntityFusilBullet.class, this.<EntityFusilBullet>createRenderer(new RenderFusilBullet(Minecraft.getMinecraft().getRenderManager(), ItemPirates.munition, Minecraft.getMinecraft().getRenderItem())));
		RenderingRegistry.registerEntityRenderingHandler(EntityPirateMaudit.class, this.<EntityPirateMaudit>createRenderer(new RenderPirateMaudit(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0.5f)));
		RenderingRegistry.registerEntityRenderingHandler(EntityLanceur.class, this.<EntityLanceur>createRenderer(new RenderLanceur(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0.5f)));
		RenderingRegistry.registerEntityRenderingHandler(EntityCapitain.class, this.<EntityCapitain>createRenderer(new RenderCapitain(0.5f, 2.0f)));
		RenderingRegistry.registerEntityRenderingHandler(EntityPirateGhost.class, this.<EntityPirateGhost>createRenderer(new RenderPirateGhost(0.0f)));
	}
	
	private <T extends Entity> IRenderFactory<? super T> createRenderer(Render<T> render) {
		return new IRenderFactory<T>() {
			@Override
			public Render<T> createRenderFor(RenderManager manager) {
				return render;
			}
		};
	}
}

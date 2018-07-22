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
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityBoulet.class, renderManager -> new RenderBoulet(renderManager, ItemPirates.boulet, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityKnife.class, renderManager -> new RenderKnife(renderManager, ItemPirates.couteau, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityFusilBullet.class, renderManager -> new RenderFusilBullet(renderManager, ItemPirates.munition, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityPirateMaudit.class, renderManager -> new RenderPirateMaudit(renderManager, new ModelBiped(), 0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityLanceur.class, renderManager -> new RenderLanceur(renderManager, new ModelBiped(), 0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityCapitain.class, renderManager -> new RenderCapitain(renderManager, 0.5f, 2.0f));
		RenderingRegistry.registerEntityRenderingHandler(EntityPirateGhost.class, renderManager -> new RenderPirateGhost(renderManager, 0.0f));
	}
}

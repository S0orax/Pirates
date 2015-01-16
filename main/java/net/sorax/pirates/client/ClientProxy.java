package net.sorax.pirates.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.sorax.pirates.client.render.entity.RenderBoulet;
import net.sorax.pirates.client.render.entity.RenderCapitain;
import net.sorax.pirates.client.render.entity.RenderFusilBullet;
import net.sorax.pirates.client.render.entity.RenderKnife;
import net.sorax.pirates.client.render.entity.RenderLanceur;
import net.sorax.pirates.client.render.entity.RenderPirateGhost;
import net.sorax.pirates.client.render.entity.RenderPirateMaudit;
import net.sorax.pirates.common.CommonProxy;
import net.sorax.pirates.common.entities.EntityBoulet;
import net.sorax.pirates.common.entities.EntityCapitain;
import net.sorax.pirates.common.entities.EntityFusilBullet;
import net.sorax.pirates.common.entities.EntityKnife;
import net.sorax.pirates.common.entities.EntityLanceur;
import net.sorax.pirates.common.entities.EntityPirateGhost;
import net.sorax.pirates.common.entities.EntityPirateMaudit;
import net.sorax.pirates.common.items.ItemPirates;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityBoulet.class, new RenderBoulet(Minecraft.getMinecraft().getRenderManager(), ItemPirates.boulet, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityKnife.class, new RenderKnife(Minecraft.getMinecraft().getRenderManager(), ItemPirates.couteau, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityFusilBullet.class, new RenderFusilBullet(Minecraft.getMinecraft().getRenderManager(), ItemPirates.munition, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityPirateMaudit.class, new RenderPirateMaudit(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityLanceur.class, new RenderLanceur(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityCapitain.class, new RenderCapitain(0.5f, 2.0f));
		RenderingRegistry.registerEntityRenderingHandler(EntityPirateGhost.class, new RenderPirateGhost(0.0f));
	}
}

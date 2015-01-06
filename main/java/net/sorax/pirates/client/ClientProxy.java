package net.sorax.pirates.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.sorax.pirates.client.render.entity.RenderBoulet;
import net.sorax.pirates.client.render.entity.RenderKnife;
import net.sorax.pirates.common.CommonProxy;
import net.sorax.pirates.common.entities.EntityBoulet;
import net.sorax.pirates.common.entities.EntityFusilBullet;
import net.sorax.pirates.common.entities.EntityKnife;
import net.sorax.pirates.common.items.ItemPirates;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		EntityRegistry.registerGlobalEntityID(EntityBoulet.class, "EntityBoulet", EntityRegistry.findGlobalUniqueEntityId());
		RenderingRegistry.registerEntityRenderingHandler(EntityBoulet.class, new RenderBoulet(Minecraft.getMinecraft().getRenderManager(), ItemPirates.boulet, Minecraft.getMinecraft().getRenderItem()));
	
		EntityRegistry.registerGlobalEntityID(EntityKnife.class, "EntityKnife", EntityRegistry.findGlobalUniqueEntityId());
		RenderingRegistry.registerEntityRenderingHandler(EntityKnife.class, new RenderKnife(Minecraft.getMinecraft().getRenderManager(), ItemPirates.couteau, Minecraft.getMinecraft().getRenderItem()));
		
		EntityRegistry.registerGlobalEntityID(EntityFusilBullet.class, "EntityFusilBullet", EntityRegistry.findGlobalUniqueEntityId());
		RenderingRegistry.registerEntityRenderingHandler(EntityFusilBullet.class, new RenderKnife(Minecraft.getMinecraft().getRenderManager(), ItemPirates.munition, Minecraft.getMinecraft().getRenderItem()));
	}
}

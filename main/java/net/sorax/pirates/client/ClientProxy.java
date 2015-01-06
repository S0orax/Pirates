package net.sorax.pirates.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.sorax.pirates.client.render.entity.RenderBoulet;
import net.sorax.pirates.common.CommonProxy;
import net.sorax.pirates.common.entities.EntityBoulet;
import net.sorax.pirates.common.items.ItemPirates;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		EntityRegistry.registerGlobalEntityID(EntityBoulet.class, "EntityBoulet", EntityRegistry.findGlobalUniqueEntityId());
		RenderingRegistry.registerEntityRenderingHandler(EntityBoulet.class, new RenderBoulet(Minecraft.getMinecraft().getRenderManager(), ItemPirates.boulet, Minecraft.getMinecraft().getRenderItem()));
	}
}

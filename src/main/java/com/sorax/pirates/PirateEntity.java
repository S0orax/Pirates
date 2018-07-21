package com.sorax.pirates;

import com.sorax.pirates.common.entities.EntityBoulet;
import com.sorax.pirates.common.entities.EntityCapitain;
import com.sorax.pirates.common.entities.EntityFusilBullet;
import com.sorax.pirates.common.entities.EntityKnife;
import com.sorax.pirates.common.entities.EntityLanceur;
import com.sorax.pirates.common.entities.EntityPirateGhost;
import com.sorax.pirates.common.entities.EntityPirateMaudit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class PirateEntity {
	
	public static void loadCreature() {
		registerMob(EntityPirateMaudit.class, "PirateMaudit", 0, 0xFF0000);
		registerMob(EntityLanceur.class, "Lanceur", 0xFF9999, 0x553333);
		registerMob(EntityCapitain.class, "Capitaine", 0x4D4433, 0xD6AA85);
		registerMob(EntityPirateGhost.class, "PirateGhost", 0x95B1BE, 0xFFFFFF);
	}
	
	public static void loadOthers() {
		registerOther(EntityKnife.class, "EntityKnife");
		registerOther(EntityBoulet.class, "EntityBoulet");
		registerOther(EntityFusilBullet.class, "EntityFusilBullet");
	}
	
	private static void registerMob(Class<? extends EntityLivingBase> clazz, String name, int egg1, int egg2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Pirates.MODID, name), clazz, name, 0, Pirates.instance, 64, 1, true, egg1, egg2);
	}
	
	private static void registerOther(Class<? extends Entity> clazz, String name) {
		EntityRegistry.registerModEntity(new ResourceLocation(Pirates.MODID, name), clazz, name, 100, Pirates.instance, 64, 1, true);
	}
}

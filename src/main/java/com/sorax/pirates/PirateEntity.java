package com.sorax.pirates;

import com.sorax.pirates.common.entities.EntityBoulet;
import com.sorax.pirates.common.entities.EntityCapitain;
import com.sorax.pirates.common.entities.EntityFusilBullet;
import com.sorax.pirates.common.entities.EntityKnife;
import com.sorax.pirates.common.entities.EntityLanceur;
import com.sorax.pirates.common.entities.EntityPirateGhost;
import com.sorax.pirates.common.entities.EntityPirateMaudit;

import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@Mod.EventBusSubscriber(modid=Pirates.MODID)
public class PirateEntity {
	
	public static final EntityEntry CURSED_PIRATE = new EntityEntry(EntityPirateMaudit.class, Pirates.MODID + ":PirateMaudit").setRegistryName(Pirates.MODID, "PirateMaudit");
	public static final EntityEntry LAUNCHER_PIRATE = new EntityEntry(EntityLanceur.class, Pirates.MODID + ":Lanceur").setRegistryName(Pirates.MODID, "Lanceur");
	public static final EntityEntry CAPTAIN_PIRATE = new EntityEntry(EntityCapitain.class, Pirates.MODID + ":Capitaine").setRegistryName(Pirates.MODID, "Capitaine");
	public static final EntityEntry GHOST_PIRATE = new EntityEntry(EntityPirateGhost.class, Pirates.MODID + ":PirateGhost").setRegistryName(Pirates.MODID, "PirateGhost");
	public static final EntityEntry KNIFE = new EntityEntry(EntityKnife.class, Pirates.MODID + ":EntityKnife").setRegistryName(Pirates.MODID, "EntityKnife");;
	public static final EntityEntry BULLET = new EntityEntry(EntityBoulet.class, Pirates.MODID + ":EntityBoulet").setRegistryName(Pirates.MODID, "EntityBoulet");
	public static final EntityEntry SHOTGUN_AMMO = new EntityEntry(EntityFusilBullet.class, Pirates.MODID + ":EntityFusilBullet").setRegistryName(Pirates.MODID, "EntityFusilBullet");
	
	public static void initEggs() {
		CURSED_PIRATE.setEgg(new EntityEggInfo(new ResourceLocation(Pirates.MODID, "PirateMaudit"), 0, 0xff0000));
		LAUNCHER_PIRATE.setEgg(new EntityEggInfo(new ResourceLocation(Pirates.MODID, "Lanceur"), 0xFF9999, 0x553333));
		CAPTAIN_PIRATE.setEgg(new EntityEggInfo(new ResourceLocation(Pirates.MODID, "Capitaine"), 0x4D4433, 0xD6AA85));
		GHOST_PIRATE.setEgg(new EntityEggInfo(new ResourceLocation(Pirates.MODID, "PirateGhost"), 0x95B1BE, 0xFFFFFF));
	}
	
	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityEntry> register) {
		register.getRegistry().registerAll(CURSED_PIRATE, LAUNCHER_PIRATE, CAPTAIN_PIRATE, GHOST_PIRATE, KNIFE, BULLET, SHOTGUN_AMMO);
	}
}

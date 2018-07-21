package com.sorax.pirates;

import com.sorax.pirates.common.CommonProxy;
import com.sorax.pirates.common.entities.EntityLanceur;
import com.sorax.pirates.common.entities.EntityPirateMaudit;
import com.sorax.pirates.common.items.ItemPirates;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = Pirates.MODID, name = "Pirate's", version = Pirates.VERSION)

public class Pirates {
	
	public static final String MODID = "pirates";
	public static final String VERSION = "0.0.1";
	
	
	@Instance(MODID)
	public static Pirates instance;
	
	@SidedProxy(clientSide = "com.sorax.pirates.client.ClientProxy", serverSide = "com.sorax.pirates.common.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(new ItemPirates());
		PirateEntity.loadOthers();
		PirateEntity.loadCreature();
		
		proxy.registerRenderers();
		
		Biome[] biomes = {
			Biomes.BEACH, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.DESERT, 
			Biomes.EXTREME_HILLS, Biomes.JUNGLE, Biomes.TAIGA_HILLS, Biomes.MESA, 
			Biomes.PLAINS, Biomes.ROOFED_FOREST, Biomes.SAVANNA, Biomes.TAIGA,
			Biomes.OCEAN
		};
		
		EntityRegistry.addSpawn(EntityPirateMaudit.class, 10, 2, 5, EnumCreatureType.AMBIENT, biomes);
		EntityRegistry.addSpawn(EntityLanceur.class, 8, 2, 4, EnumCreatureType.AMBIENT, biomes);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}

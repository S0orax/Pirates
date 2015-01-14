package net.sorax.pirates;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.sorax.pirates.common.CommonProxy;
import net.sorax.pirates.common.entities.EntityBoulet;
import net.sorax.pirates.common.entities.EntityFusilBullet;
import net.sorax.pirates.common.entities.EntityKnife;
import net.sorax.pirates.common.entities.EntityLanceur;
import net.sorax.pirates.common.entities.EntityPirateMaudit;
import net.sorax.pirates.common.items.ItemPirates;

@Mod(modid = Pirates.MODID, name = "Pirate's", version = Pirates.VERSION)

public class Pirates {
	
	public static final String MODID = "pirates";
	public static final String VERSION = "0.0.1";
	
	
	@Instance(MODID)
	public static Pirates instance;
	
	@SidedProxy(clientSide = "net.sorax.pirates.client.ClientProxy", serverSide = "net.sorax.pirates.common.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		ItemPirates.load();
		
		PirateEntity.loadOthers();
		
		PirateEntity.loadCreature();
		
		proxy.registerRenderers();
		
		BiomeGenBase[] biomes = {
			BiomeGenBase.beach, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.desert, 
			BiomeGenBase.extremeHills, BiomeGenBase.jungle, BiomeGenBase.megaTaiga, BiomeGenBase.mesa, 
			BiomeGenBase.plains, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.taiga,
			BiomeGenBase.ocean
		};
		
		EntityRegistry.addSpawn(EntityPirateMaudit.class, 10, 2, 5, EnumCreatureType.AMBIENT, biomes);
		EntityRegistry.addSpawn(EntityLanceur.class, 8, 2, 4, EnumCreatureType.AMBIENT, biomes);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}

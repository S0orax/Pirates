package com.sorax.pirates.common.items;

import com.sorax.pirates.Pirates;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid=Pirates.MODID)
public class ItemPirates {
	
	public static Item barbe = new Item().setUnlocalizedName(Pirates.MODID + ".barbe").setRegistryName(Pirates.MODID, "barbe").setCreativeTab(CreativeTabs.MISC);
	public static Item boulet = new Item().setUnlocalizedName(Pirates.MODID + ".boulet").setRegistryName(Pirates.MODID, "boulet").setCreativeTab(CreativeTabs.MISC);
	public static Item cacheoeil = new Item().setUnlocalizedName(Pirates.MODID + ".cacheoeil").setRegistryName(Pirates.MODID, "cacheoeil").setCreativeTab(CreativeTabs.MISC);
	public static Item cadenas = new Item().setUnlocalizedName(Pirates.MODID + ".cadenas").setRegistryName(Pirates.MODID, "cadenas").setCreativeTab(CreativeTabs.MISC);
	public static Item canon = new ItemCanon().setUnlocalizedName(Pirates.MODID + ".canon").setRegistryName(Pirates.MODID, "canon").setCreativeTab(CreativeTabs.MISC);
	public static Item cd = new Item().setUnlocalizedName(Pirates.MODID + ".cd").setRegistryName(Pirates.MODID, "cd").setCreativeTab(CreativeTabs.MISC);
	public static Item corsaire = new Item().setUnlocalizedName(Pirates.MODID + ".corsaire").setRegistryName(Pirates.MODID, "corsaire").setCreativeTab(CreativeTabs.MISC);
	public static Item couteau = new ItemKnife().setUnlocalizedName(Pirates.MODID + ".couteau").setRegistryName(Pirates.MODID, "couteau").setCreativeTab(CreativeTabs.MISC);
	public static Item diamondhull = new Item().setUnlocalizedName(Pirates.MODID + ".diamondhull").setRegistryName(Pirates.MODID, "diamondhull").setCreativeTab(CreativeTabs.MISC);
	public static Item ecaillesirene = new Item().setUnlocalizedName(Pirates.MODID + ".ecaillesirene").setRegistryName(Pirates.MODID, "ecaillesirene").setCreativeTab(CreativeTabs.MISC);
	public static Item ectoplasme = new Item().setUnlocalizedName(Pirates.MODID + ".ectoplasme").setRegistryName(Pirates.MODID, "ectoplasme").setCreativeTab(CreativeTabs.MISC);
	public static Item fonte = new Item().setUnlocalizedName(Pirates.MODID + ".fonte").setRegistryName(Pirates.MODID, "fonte").setCreativeTab(CreativeTabs.MISC);
	public static Item fusil = new ItemFusil().setUnlocalizedName(Pirates.MODID + ".fusil").setRegistryName(Pirates.MODID, "fusil").setCreativeTab(CreativeTabs.MISC);
	public static Item gouvernail = new Item().setUnlocalizedName(Pirates.MODID + ".gouvernail").setRegistryName(Pirates.MODID, "gouvernail").setCreativeTab(CreativeTabs.MISC);
	public static Item ironhull = new Item().setUnlocalizedName(Pirates.MODID + ".ironhull").setRegistryName(Pirates.MODID, "ironhull").setCreativeTab(CreativeTabs.MISC);
	public static Item jambedebois = new Item().setUnlocalizedName(Pirates.MODID + ".jambedebois").setRegistryName(Pirates.MODID, "jambedebois").setCreativeTab(CreativeTabs.MISC);
	public static Item key = new Item().setUnlocalizedName(Pirates.MODID + ".key").setRegistryName(Pirates.MODID, "key").setCreativeTab(CreativeTabs.MISC);
	public static Item mat = new Item().setUnlocalizedName(Pirates.MODID + ".mat").setRegistryName(Pirates.MODID, "mat").setCreativeTab(CreativeTabs.MISC);
	public static Item medaillon = new Item().setUnlocalizedName(Pirates.MODID + ".medaillon").setRegistryName(Pirates.MODID, "medaillon").setCreativeTab(CreativeTabs.MISC);
	public static Item munition = new Item().setUnlocalizedName(Pirates.MODID + ".munition").setRegistryName(Pirates.MODID, "munition").setCreativeTab(CreativeTabs.MISC);
	public static Item plume = new Item().setUnlocalizedName(Pirates.MODID + ".plume").setRegistryName(Pirates.MODID, "plume").setCreativeTab(CreativeTabs.MISC);
	public static Item proue = new Item().setUnlocalizedName(Pirates.MODID + ".proue").setRegistryName(Pirates.MODID, "proue").setCreativeTab(CreativeTabs.MISC);
	public static Item rhum = new Item().setUnlocalizedName(Pirates.MODID + ".rhum").setRegistryName(Pirates.MODID, "rhum").setCreativeTab(CreativeTabs.MISC);
	public static Item voile = new Item().setUnlocalizedName(Pirates.MODID + ".voile").setRegistryName(Pirates.MODID, "voile").setCreativeTab(CreativeTabs.MISC);
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
	    event.getRegistry().registerAll(barbe, boulet, cacheoeil, cadenas, canon, cd, corsaire, couteau, diamondhull, ecaillesirene, ectoplasme, fonte, 
	    								fusil, gouvernail, ironhull, jambedebois, key, mat, medaillon, munition, plume, proue, rhum, voile);
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(barbe);
		registerRender(boulet);
		registerRender(cacheoeil);
		registerRender(cadenas);
		registerRender(canon);
		registerRender(cd);
		registerRender(corsaire);
		registerRender(couteau);
		registerRender(diamondhull);
		registerRender(ecaillesirene);
		registerRender(ectoplasme);
		registerRender(fonte);
		registerRender(fusil);
		registerRender(gouvernail);
		registerRender(ironhull);
		registerRender(jambedebois);
		registerRender(key);
		registerRender(mat);
		registerRender(medaillon);
		registerRender(munition);
		registerRender(plume);
		registerRender(proue);
		registerRender(rhum);
		registerRender(voile);
	}
	
	
	@SideOnly(Side.CLIENT)
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
}

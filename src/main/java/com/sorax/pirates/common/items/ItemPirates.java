package com.sorax.pirates.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemPirates {
	
	public static Item barbe = new Item().setUnlocalizedName("barbe").setCreativeTab(CreativeTabs.MISC);
	public static Item boulet = new Item().setUnlocalizedName("boulet").setCreativeTab(CreativeTabs.MISC);
	public static Item cacheoeil = new Item().setUnlocalizedName("cacheoeil").setCreativeTab(CreativeTabs.MISC);
	public static Item cadenas = new Item().setUnlocalizedName("cadenas").setCreativeTab(CreativeTabs.MISC);
	public static Item canon = new ItemCanon().setUnlocalizedName("canon").setCreativeTab(CreativeTabs.MISC);
	public static Item cd = new Item().setUnlocalizedName("cd").setCreativeTab(CreativeTabs.MISC);
	public static Item corsaire = new Item().setUnlocalizedName("corsaire").setCreativeTab(CreativeTabs.MISC);
	public static Item couteau = new ItemKnife().setUnlocalizedName("couteau").setCreativeTab(CreativeTabs.MISC);
	public static Item diamondhull = new Item().setUnlocalizedName("diamondhull").setCreativeTab(CreativeTabs.MISC);
	public static Item ecaillesirene = new Item().setUnlocalizedName("ecaillesirene").setCreativeTab(CreativeTabs.MISC);
	public static Item ectoplasme = new Item().setUnlocalizedName("ectoplasme").setCreativeTab(CreativeTabs.MISC);
	public static Item fonte = new Item().setUnlocalizedName("fonte").setCreativeTab(CreativeTabs.MISC);
	public static Item fusil = new ItemFusil().setUnlocalizedName("fusil").setCreativeTab(CreativeTabs.MISC);
	public static Item gouvernail = new Item().setUnlocalizedName("gouvernail").setCreativeTab(CreativeTabs.MISC);
	public static Item ironhull = new Item().setUnlocalizedName("ironhull").setCreativeTab(CreativeTabs.MISC);
	public static Item jambedebois = new Item().setUnlocalizedName("jambedebois").setCreativeTab(CreativeTabs.MISC);
	public static Item key = new Item().setUnlocalizedName("key").setCreativeTab(CreativeTabs.MISC);
	public static Item mat = new Item().setUnlocalizedName("mat").setCreativeTab(CreativeTabs.MISC);
	public static Item medaillon = new Item().setUnlocalizedName("medaillon").setCreativeTab(CreativeTabs.MISC);
	public static Item munition = new Item().setUnlocalizedName("munition").setCreativeTab(CreativeTabs.MISC);
	public static Item plume = new Item().setUnlocalizedName("plume").setCreativeTab(CreativeTabs.MISC);
	public static Item proue = new Item().setUnlocalizedName("proue").setCreativeTab(CreativeTabs.MISC);
	public static Item rhum = new Item().setUnlocalizedName("rhum").setCreativeTab(CreativeTabs.MISC);
	public static Item voile = new Item().setUnlocalizedName("voile").setCreativeTab(CreativeTabs.MISC);
	
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
	    event.getRegistry().registerAll(barbe, boulet, cacheoeil, cadenas, canon, cd, corsaire, couteau, diamondhull, ecaillesirene, ectoplasme, fonte, 
	    								fusil, gouvernail, ironhull, jambedebois, key, mat, medaillon, munition, plume, proue, rhum, voile);
	}
}

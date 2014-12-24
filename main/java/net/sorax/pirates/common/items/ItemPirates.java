package net.sorax.pirates.common.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemPirates {
	
	public static Item barbe = new Item().setUnlocalizedName("barbe").setCreativeTab(CreativeTabs.tabMisc);
	public static Item boulet = new Item().setUnlocalizedName("boulet").setCreativeTab(CreativeTabs.tabMisc);
	public static Item cacheoeil = new Item().setUnlocalizedName("cacheoeil").setCreativeTab(CreativeTabs.tabMisc);
	public static Item cadenas = new Item().setUnlocalizedName("cadenas").setCreativeTab(CreativeTabs.tabMisc);
	public static Item canon = new Item().setUnlocalizedName("canon").setCreativeTab(CreativeTabs.tabMisc);
	public static Item cd = new Item().setUnlocalizedName("cd").setCreativeTab(CreativeTabs.tabMisc);
	public static Item corsaire = new Item().setUnlocalizedName("corsaire").setCreativeTab(CreativeTabs.tabMisc);
	public static Item couteau = new Item().setUnlocalizedName("couteau").setCreativeTab(CreativeTabs.tabMisc);
	public static Item diamondhull = new Item().setUnlocalizedName("diamondhull").setCreativeTab(CreativeTabs.tabMisc);
	public static Item ecaillesirene = new Item().setUnlocalizedName("ecaillesirene").setCreativeTab(CreativeTabs.tabMisc);
	public static Item ectoplasme = new Item().setUnlocalizedName("ectoplasme").setCreativeTab(CreativeTabs.tabMisc);
	public static Item fonte = new Item().setUnlocalizedName("fonte").setCreativeTab(CreativeTabs.tabMisc);
	public static Item fusil = new Item().setUnlocalizedName("fusil").setCreativeTab(CreativeTabs.tabMisc);
	public static Item gouvernail = new Item().setUnlocalizedName("gouvernail").setCreativeTab(CreativeTabs.tabMisc);
	public static Item ironhull = new Item().setUnlocalizedName("ironhull").setCreativeTab(CreativeTabs.tabMisc);
	public static Item jambedebois = new Item().setUnlocalizedName("jambedebois").setCreativeTab(CreativeTabs.tabMisc);
	public static Item key = new Item().setUnlocalizedName("key").setCreativeTab(CreativeTabs.tabMisc);
	public static Item mat = new Item().setUnlocalizedName("mat").setCreativeTab(CreativeTabs.tabMisc);
	public static Item medaillon = new Item().setUnlocalizedName("medaillon").setCreativeTab(CreativeTabs.tabMisc);
	public static Item munition = new Item().setUnlocalizedName("munition").setCreativeTab(CreativeTabs.tabMisc);
	public static Item plume = new Item().setUnlocalizedName("plume").setCreativeTab(CreativeTabs.tabMisc);
	public static Item proue = new Item().setUnlocalizedName("proue").setCreativeTab(CreativeTabs.tabMisc);
	public static Item rhum = new Item().setUnlocalizedName("rhum").setCreativeTab(CreativeTabs.tabMisc);
	public static Item voile = new Item().setUnlocalizedName("voile").setCreativeTab(CreativeTabs.tabMisc);	
	
	public static void preInit() {
		registerItem(barbe, "barbe");
		registerItem(boulet, "boulet");
		registerItem(cacheoeil, "cacheoeil");
		registerItem(cadenas, "cadenas");
		registerItem(canon, "canon");
		registerItem(cd, "cd");
		registerItem(corsaire, "corsaire");
		registerItem(couteau, "couteau");
		registerItem(diamondhull, "diamondhull");
		registerItem(ecaillesirene, "ecaillesirene");
		registerItem(ectoplasme, "ectoplasme");
		registerItem(fonte, "fonte");
		registerItem(fusil, "fusil");
		registerItem(gouvernail, "gouvernail");
		registerItem(ironhull, "ironhull");
		registerItem(jambedebois, "jambedebois");
		registerItem(key, "key");
		registerItem(mat, "mat");
		registerItem(medaillon, "medaillon");
		registerItem(munition, "munition");
		registerItem(plume, "plume");
		registerItem(proue, "proue");
		registerItem(rhum, "rhum");
		registerItem(voile, "voile");
	}
	
	private static void registerItem(Item item, String texture) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation("pirates:" + texture, "inventory"));;
		GameRegistry.registerItem(item, texture);
	}
}

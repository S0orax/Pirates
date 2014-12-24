package net.sorax.pirates.common.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemPirates {
	
	public static Item barbe = new Item().setUnlocalizedName("barbe").setCreativeTab(CreativeTabs.tabMisc);
	
	public static void preInit() {
		itemRendering(barbe, "barbe");
	
		registerItem();
	}
	
	private static void itemRendering(Item item, String texture) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation("pirates:" + texture, "inventory"));;
	}
	
	private static void registerItem() {
		GameRegistry.registerItem(barbe, "barbe");
	}
}

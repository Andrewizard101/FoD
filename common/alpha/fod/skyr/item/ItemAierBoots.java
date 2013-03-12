package alpha.fod.skyr.item;

import alpha.fod.skyr.SkyrRef;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;


public class ItemAierBoots extends ItemArmor implements IArmorTextureProvider {

	public ItemAierBoots(int par1, EnumArmorMaterial par2EnumArmorMaterial,int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);

	}
	
	public String getArmorTextureFile(ItemStack par1) {
		/*if(par1.itemID == Skyr.AeirBoots.itemID) {
			return "/FoD/Items/AeirBoots.png";
		}*/
		
		return "/FoD/Items/AeirBoots.png";
	}
}

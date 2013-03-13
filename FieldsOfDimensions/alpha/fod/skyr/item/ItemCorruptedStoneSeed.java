package alpha.fod.skyr.item;

import alpha.fod.skyr.Skyr;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCorruptedStoneSeed extends Item {

	public ItemCorruptedStoneSeed(int par1) {
		super(par1);
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		if(par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par3World.getBlockId(par4, par5, par6) == Skyr.granite.blockID && par3World.getBlockMetadata(par4, par5, par6) == 0) {
			par3World.setBlockMetadata(par4, par5, par6, 3);
			return true;
		}
		else return false;
    }
	
}

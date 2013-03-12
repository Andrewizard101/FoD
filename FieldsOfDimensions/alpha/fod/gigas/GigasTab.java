package alpha.fod.gigas;

import alpha.fod.gigas.Gigas;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class GigasTab extends CreativeTabs
{
        public GigasTab(int par1, String par2Str)
        {
                super(par1, par2Str);
        }
        
        //sets the image for the creative tab
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
        {
           //there is a diference between items and blocks. will give an example of both
                return Gigas.gigasPortal.blockID;//items
               // return Yourmod.YourBlock.BlockID; for if you want to use a block
        }
   
        //sets the title/name for the creative tab
        public String getTranslatedTabLabel()
        {
         return "Gigas Silva";
        }
}
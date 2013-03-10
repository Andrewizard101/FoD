package alpha.fod.gigas.block;

import alpha.fod.gigas.Gigas;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class BlockGigasDirt extends Block
{
    public BlockGigasDirt(int par1)
    {
        super(par1, Material.wood);
        this.setCreativeTab(Gigas.gigasTab);
    }

  
    public String getTextureFile() //this specifies the texture path. 
    {
     return "/Gigas/Textures/Blocks.png";
    }

}

package common.alpha.fod.gigas.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import common.alpha.fod.gigas.Gigas;

public class BlockGigasDirt extends Block
{
    public BlockGigasDirt(int par1)
    {
        super(par1, Material.wood);
        this.setCreativeTab(Gigas.GigasTab);
    }

  
    public String getTextureFile() //this specifies the texture path. 
    {
     return "/Gigas/Textures/Blocks.png";
    }

}

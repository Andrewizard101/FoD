package Gigas.Silva.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import Gigas.Silva.CoreMod.GigasCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGigasDirt extends Block
{
    public BlockGigasDirt(int par1)
    {
        super(par1, Material.wood);
        this.setCreativeTab(GigasCore.GigasTab);
    }

  
    public String getTextureFile() //this specifies the texture path. 
    {
     return "/Gigas/Textures/Blocks.png";
    }

}

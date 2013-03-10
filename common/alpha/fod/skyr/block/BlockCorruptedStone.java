package common.alpha.fod.skyr.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import common.alpha.fod.skyr.Skyr;

public class BlockCorruptedStone extends Block {

	public BlockCorruptedStone(int par1, int par2, Material par3Material) 
	{
		super(par1, par2, par3Material);
	}

	public int quantityDropped(Random par1Random) 
	{
		return 2 + par1Random.nextInt(3);
	}

	public int idDropped(int par1, Random par2Random, int par3) 
	{
		return Skyr.corruptedStoneSeed.itemID;
	}
}

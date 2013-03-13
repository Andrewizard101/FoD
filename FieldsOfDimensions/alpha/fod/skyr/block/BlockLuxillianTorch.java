package alpha.fod.skyr.block;

import java.util.Random;

import alpha.fod.skyr.entity.EntityBlueFlameParticle;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.BlockTorch;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockLuxillianTorch extends BlockTorch {
	protected BlockLuxillianTorch(int par1) {
		super(par1, RenderingRegistry.addTextureOverride("/terrain.png", "/FoD/Blocks/LuxillianTorch.png"));
	}

	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		int var6 = par1World.getBlockMetadata(par2, par3, par4);
		double var7 = (double) ((float) par2 + 0.5F);
		double var9 = (double) ((float) par3 + 0.7F);
		double var11 = (double) ((float) par4 + 0.5F);
		double var13 = 0.2199999988079071D;
		double var15 = 0.27000001072883606D;

		Entity e = new EntityBlueFlameParticle(par1World, par2, par3, par4, 0, 0, 0);
		if (var6 == 1) {
			par1World.spawnEntityInWorld(e = new EntityBlueFlameParticle(par1World, var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D));
		} else if (var6 == 2) {	
			par1World.spawnEntityInWorld(e = new EntityBlueFlameParticle(par1World, var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D));
		} else if (var6 == 3) {
			par1World.spawnEntityInWorld(e = new EntityBlueFlameParticle(par1World, var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D));
		} else if (var6 == 4) {
			par1World.spawnEntityInWorld(e = new EntityBlueFlameParticle(par1World, var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D));
		} else {
			par1World.spawnEntityInWorld(e = new EntityBlueFlameParticle(par1World, var7, var9, var11, 0.0D, 0.0D, 0.0D));
		}
	}

}

package Gigas.Silva.Dimension;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenGigas extends BiomeGenBase
{
	private WorldGenerator theWorldGenerator;
    public BiomeGenGigas(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.theBiomeDecorator.treesPerChunk = 15;
        this.theBiomeDecorator.grassPerChunk = 5;
        this.theBiomeDecorator.flowersPerChunk = 2;
        this.theBiomeDecorator.clayPerChunk = 9;
        this.theBiomeDecorator.reedsPerChunk = 25;
        this.theBiomeDecorator.waterlilyPerChunk = 1;
        

        this.setColor(5470985);
        
        this.theWorldGenerator = new WorldGenMinable(Block.silverfish.blockID, 8);
        this.theWorldGenerator = new WorldGenMinable(Block.oreDiamond.blockID, 8);
        this.theWorldGenerator = new WorldGenMinable(Block.oreEmerald.blockID, 10);
        this.setTemperatureRainfall(1.2F, 0.9F);
 
    }


   //==================Tree Gen============//
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return (WorldGenerator)(par1Random.nextInt(1) == 0 ? new WorldGenHugeGigas(false, 10 + par1Random.nextInt(30), 0, 0)  : new WorldGenGigasTrees ());
    }

    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);
        WorldGenVines var5 = new WorldGenVines();

        for (int var6 = 0; var6 < 50; ++var6)
        {
            int var7 = par3 + par2Random.nextInt(16) + 8;
            byte var8 = 64;
            int var9 = par4 + par2Random.nextInt(16) + 8;
            var5.generate(par1World, par2Random, var7, var8, var9);
        }
    }
}



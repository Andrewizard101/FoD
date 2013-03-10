package common.alpha.fod.gigas.generation;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

import common.alpha.fod.gigas.Gigas;

public class WorldProviderGigas extends WorldProvider
{
 public void registerWorldChunkManager()
 {
  this.worldChunkMgr = new WorldChunkManagerHell(Gigas.Gigas, 0.8F, 0.1F);
  this.dimensionId = Gigas.dimension;
 }
 
 public String getDimensionName() 
 {
  return "Gigas";
 }
 
 public boolean canRespawnHere()
 {
  return true;
 }

 
 @Override
 public IChunkProvider createChunkGenerator()
 {
     return new ChunkProviderGigas(this.worldObj, this.worldObj.getSeed());
 }
}
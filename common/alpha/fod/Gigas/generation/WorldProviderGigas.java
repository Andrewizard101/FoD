package alpha.fod.gigas.generation;

import alpha.fod.gigas.Gigas;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;


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
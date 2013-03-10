package Gigas.Silva.Dimension;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import Gigas.Silva.CoreMod.GigasCore;

public class WorldProviderGigas extends WorldProvider
{
 public void registerWorldChunkManager()
 {
  this.worldChunkMgr = new WorldChunkManagerHell(GigasCore.Gigas, 0.8F, 0.1F);
  this.dimensionId = GigasCore.dimension;
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
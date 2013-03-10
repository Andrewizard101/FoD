package common.alpha.fod.skyr.generation;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

import common.alpha.fod.skyr.Skyr;

public class WorldProviderSkyr extends WorldProvider {

	 public String getDimensionName() 
	 {
		 return "Skyr";
	 }
	 
	 public boolean canRespawnHere()
	 {
		 return true;
	 }
	 
	 public void registerWorldChunkManager()
	 {
		 this.worldChunkMgr = new WorldChunkManagerHell(Skyr.SkyrPlains, 0.8F, 0.0F);
		 this.dimensionId = Skyr.dimensionSkyrID;
	 }
	 
	 @Override
	 public IChunkProvider createChunkGenerator()
	 {
		 return new ChunkProviderSkyr(worldObj, worldObj.getSeed(), true);
	 }
	 
	 public String getSaveFolder()
	 {
		 return "Skyr";
	 }
}

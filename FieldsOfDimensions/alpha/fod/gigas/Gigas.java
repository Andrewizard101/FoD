package alpha.fod.gigas;

import alpha.fod.FOD;
import alpha.fod.common.BuildBlock;
import alpha.fod.common.Dimension;
import alpha.fod.gigas.generation.BiomeGenGigas;
import alpha.fod.gigas.generation.WorldProviderGigas;
import alpha.fod.skyr.entity.EntityJellyfish;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.MinecraftForgeClient;


import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Gigas {
	
	@Dimension(worldProvider = WorldProviderGigas.class)
	public static int dimension = 26; 
	
	public static int gigasPortalId;
	public static int gigasLogsId;
	public static int gigasleavesId;
	public static int GigasId;
	
	public static BiomeGenBase Gigas= (new BiomeGenGigas(28)).setBiomeName("GigasSilva").setTemperatureRainfall(1.2F, 0.9F);;

	@BuildBlock(blockClass = "SUB.BlockGigasPortal", hardness = 0, params = {"ID", "INT.0"}, stepSound = "soundGrassFootstep")
	public static Block gigasPortal;
	@BuildBlock(blockClass = "SUB.BlockGigasLog", hardness = 0.7F, stepSound = "soundWoodFootstep", params = {"ID"})
	public static Block gigasLogs;
	@BuildBlock(blockClass = "SUB.BlockGigasLeaf", hardness = 0.2F, stepSound = "soundGrassFootstep", params = {"ID", "INT.3"})
	public static Block gigasleaves;

	public static CreativeTabs gigasTab = new GigasTab(CreativeTabs.getNextID(), "Gigas"); 
	
	public void RegisterBiomes(){
	}
	
	public void RegisterRecipes(){	
	}
	
	@SideOnly(Side.CLIENT)
	public void Render(){
        MinecraftForgeClient.preloadTexture("/Gigas/Textures/Blocks.png");
        MinecraftForgeClient.preloadTexture("/Gigas/Textures/Items.png");
	}
	
	public void RegisterEntities(){
	}
}




package Gigas.Silva.CoreMod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import Gigas.Silva.Blocks.BlockGigasLeaf;
import Gigas.Silva.Blocks.BlockGigasLog;
import Gigas.Silva.Dimension.BiomeGenGigas;
import Gigas.Silva.Dimension.BlockGigasPortal;
import Gigas.Silva.Dimension.WorldProviderGigas;
import Gigas.Silva.Entity.EntityJelly;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
@Mod (modid = "Gigas",name = "Gigas Silva", version = "1.4.7", acceptedMinecraftVersions = "1.4.7")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class GigasCore {

	@SidedProxy(clientSide = "Gigas.Silva.CoreMod.GigasClient",serverSide = "Gigas.Silva.CoreMod.GigasProxy")


	public static GigasProxy proxy;
	public static int dimension = 26; 
	
	//==================Biomes=========================//
	
	  public static final BiomeGenBase Gigas= (new BiomeGenGigas(28)).setBiomeName("GigasSilva").setTemperatureRainfall(1.2F, 0.9F);;
	

	//================Block Registering==============//


	public static Block GigasPortal;
	public static Block GigasLogs;
	public static Block Gigasleaf;



	//================Creative Tabs==============//

	public static CreativeTabs GigasTab = new GigasTab (CreativeTabs.getNextID(),"Gigas"); 



	//================Items=====================//



	
	//================Blocks====================//

	@Mod.PreInit
	public void preInit(FMLPreInitializationEvent preEvent){
		
		GigasPortal = (BlockGigasPortal)(new BlockGigasPortal(231, 0)).setStepSound(Block.soundGrassFootstep).setBlockName("Your2Block");
		GigasLogs = (BlockGigasLog)(new BlockGigasLog(232)).setStepSound(Block.soundWoodFootstep).setBlockName("Your2Block").setHardness(0.7F).setResistance(1.0F);
		Gigasleaf = (BlockGigasLeaf)(new BlockGigasLeaf(233, 3)).setStepSound(Block.soundGrassFootstep).setBlockName("Yourd2Block").setHardness(0.2F).setResistance(1.0F);

		GameRegistry.registerBlock(GigasPortal);
		GameRegistry.registerBlock(GigasLogs);
		GameRegistry.registerBlock(Gigasleaf);

	}	
	
	@Mod.Init
	public void load(FMLInitializationEvent initEvent){
		proxy.registerRenderInformation();

		//class references. this tells the block what properties it has. 
		//the first 2 numbers (eg, 230, 0) the first is the block id while the second one is the texture.
		//the log block wont use this however because we are going to be adding the textures in the log's class file
		//side note: block ids go from 146-255 as of 1.4.3 (this is 106 block ids!)
	
		
		//game registry (registers the block)


		//================Recipes======================//



		//================DIMENSION==============//

		DimensionManager.registerProviderType(dimension, WorldProviderGigas.class, false);
	    DimensionManager.registerDimension(dimension, dimension);



		//================MOBS====================//

	    ModLoader.registerEntityID(EntityJelly.class,  "Jelly", 25, 0x2B6308, 0x182410);
	     ModLoader.addLocalization("entity.Jelly.name", "Jelly");
		    ModLoader.addSpawn(EntityJelly.class, 18, 3, 3, EnumCreatureType.ambient, new BiomeGenBase[] { GigasCore.Gigas });

		//===============Item Names===================//


	}
}




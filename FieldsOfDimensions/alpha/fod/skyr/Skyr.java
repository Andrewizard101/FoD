package alpha.fod.skyr;

import alpha.fod.FOD;
import alpha.fod.common.BuildBlock;
import alpha.fod.common.BuildItem;
import alpha.fod.common.Dimension;
import alpha.fod.common.No;
import alpha.fod.skyr.client.ModelJellyfish;
import alpha.fod.skyr.client.RenderJellyfish;
import alpha.fod.skyr.entity.EntityBlueSlime;
import alpha.fod.skyr.entity.EntityBlueSlimeBall;
import alpha.fod.skyr.entity.EntityGrenadeApple;
import alpha.fod.skyr.entity.EntityJellyfish;
import alpha.fod.skyr.entity.EntityNut;
import alpha.fod.skyr.generation.BiomeGenSkyr;
import alpha.fod.skyr.generation.BiomeGenSkyrPlains;
import alpha.fod.skyr.generation.WorldGeneratorSkyr;
import alpha.fod.skyr.generation.WorldProviderSkyr;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;


import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Skyr {
	
public static final String itemString = SkyrRef.item;
	
	public static CreativeTabs skyrTab = new CreativeSkyrTab(CreativeTabs.getNextID(), "Skyr");
	
	public static int skyrId;
	public static int SkyrPortalId;
	
	public static int portalShellId;
	public static int igniterId;
	public static int SkyrPlainsId;
	
	public static int luxOreId;
	public static int luxillianBlockId;
	public static int luxillianTorchId;
	public static int graniteId;
	public static int corruptedStoneId;
	public static int SkyrGrassId;
	public static int SkyweedId;
	public static int SkyrWoodId;
	public static int SkyrLeavesId;
	public static int nickelOreId;
	
	public static int graniteSwordId;
	public static int granitePickId;
	public static int graniteAxeId;
	public static int graniteSpadeId;
	public static int graniteHoeId;
	public static int luxPowderId;
	public static int corruptedStoneSeedId;
	public static int nutId;
	public static int grenadeAppleId;
	public static int squirrelMeatId;
	public static int squirrelMeatCookedId;
	public static int nutBakedId;
	public static int PomeGranateId;
	public static int blueSlimeballId;
	public static int aeirPowderId;
	public static int nickelIngotId;
	public static int electricCoilId;
	
	public static int ElectricWhipId;
	public static int ElectromagnetId;
	public static int FluteOfTheWindsId;

	
	@BuildBlock(blockClass = "SUB.BlockSkyrPortal", hardness = 0, params = {"ID", "INT.10"})
	public static BlockPortal SkyrPortal;
    public static BiomeGenBase skyr;
	
    @BuildBlock(blockClass = "SUB.BlockOres", hardness = 3F, params = {"ID", "INT.14", "MATERIAL.rock"})
	public static Block luxOre;
    @BuildBlock(blockClass = "SUB.BlockLuxillian", hardness = 3.2F, params = {"ID", "INT.13", "MATERIAL.circuts"})
	public static Block luxillianBlock;
    @BuildBlock(blockClass = "SUB.BlockLuxillianTorch", hardness = 0, params = {"ID", "INT.8"}, light = 55)
	public static Block luxillianTorch;
    @No(autoRegister = false, autoName = false)
    @BuildBlock(blockClass = "SUB.BlockGranite", hardness = 2.2F, params = {"ID", "INT.0", "MATERIAL.rock"}, resist = 15F)
	public static Block granite;
    @BuildBlock(blockClass = "SUB.BlockCorruptedStone", hardness = 2F, params = {"ID", "INT.20", "MATERIAL.rock"}, resist = 11F)
	public static Block corruptedStone;
    @BuildBlock(blockClass = "SUB.BlockOres", hardness = 3F, params = {"ID", "INT.14", "MATERIAL.rock"})
	public static Block nickelOre;
    
    @No(config = 230)
    @BuildBlock(blockClass = "SUB.BlockSkyrGrass", hardness = 1F, params = {"ID"})
	public static Block SkyrGrass;
    @BuildBlock(blockClass = "SUB.BlockSkyweed", hardness = .25F, params = {"ID"}, stepSound = "soundGrassFootstep")
    public static Block Skyweed;
    @BuildBlock(blockClass = "SUB.BlockSkyrLog", hardness = 2F, params = {"ID"}, stepSound = "soundWoodFootstep")
    public static Block SkyrWood;
    @BuildBlock(blockClass = "SUB.BlockSkyrLeaves", hardness = .5F, params = {"ID", "INT.8"}, stepSound = "soundGrassFootstep")
    public static Block SkyrLeaves;

	public static final EnumToolMaterial GRANITE = EnumHelper.addToolMaterial("GRANITE", 1, 110, 5.0F, 1, 6);
	
	@BuildItem(icon = 0, itemClass = "CORE.ItemSwordBase", params = {"ID", "ENUM.GRANITE", ""})
	public static Item graniteSword;
	@BuildItem(icon = 2, itemClass = "CORE.ItemPickaxeBase", params = {"ID", "ENUM.GRANITE", ""})
	public static Item granitePickaxe;
	@BuildItem(icon = 4, itemClass = "CORE.ItemAxeBase", params = {"ID", "ENUM.GRANITE", ""})
	public static Item graniteAxe;
	@BuildItem(icon = 1, itemClass = "CORE.ItemSpadeBase", params = {"ID", "ENUM.GRANITE", ""})
	public static Item graniteSpade;
	@BuildItem(icon = 3, itemClass = "CORE.ItemHoeBase", params = {"ID", "ENUM.GRANITE", ""})
	public static Item graniteHoe;
	
	@BuildItem(icon = 9, itemClass = "CORE.ItemBase", params = {"ID", ""})
	public static Item luxPowder;
	@BuildItem(icon = 0, itemClass = "CORE.ItemBase", params = {"ID", "FILE.itemString"})
	public static Item nickelIngot;
	@BuildItem(icon = 14, itemClass = "SUB.ItemCorruptedStoneSeed", params = {"ID"})
	public static Item corruptedStoneSeed;
	@BuildItem(icon = 7, itemClass = "SUB.ItemNut", params = {"ID"})
	public static Item nut;
	@BuildItem(icon = 10, itemClass = "SUB.ItemGrenadeApple", params = {"ID"})
	public static Item grenadeApple;
	
	//Food
	@BuildItem(icon = 5, itemClass = "CORE.ItemFoodBase", params = {"ID", "INT.1", "BOOLEAN.false", ""})
	public static Item squirrelMeat;
	@BuildItem(icon = 15, itemClass = "CORE.ItemFoodBase", params = {"ID", "INT.3", "BOOLEAN.false", ""})
	public static Item squirrelMeatCooked;
	@BuildItem(icon = 7, itemClass = "CORE.ItemFoodBase", params = {"ID", "INT.2", "BOOLEAN.false", ""})
	public static Item nutBaked;
	@BuildItem(icon = 6, itemClass = "CORE.ItemFoodBase", params = {"ID", "INT.6", "BOOLEAN.false", ""})
	public static Item PomeGranate;
	 
	//Start Mob drops//
	@BuildItem(icon = 16, itemClass = "CORE.ItemBase", params = {"ID", ""})
	public static Item blueSlimeball;
	@BuildItem(icon = 17, itemClass = "CORE.ItemBase", params = {"ID", ""})
	public static Item aeirPowder;
	@BuildItem(icon = 13, itemClass = "CORE.ItemBase", params = {"ID", ""})
	public static Item electricCoil;
	//food form mobs is in food
	public static final EnumArmorMaterial AEIRBOOTS = EnumHelper.addArmorMaterial("AierBoots", 10, new int[] { 1, 3, 2, 1 }, 15);

	//public static Item AeirBoots = new ItemAierBoots(3305, AEIRBOOTS, 0,3).setItemName("AierBoots").setIconIndex(10).setIconCoord(0, 0);

	public static final EnumToolMaterial WHIP = EnumHelper.addToolMaterial("WHIP", 1, 100, 1.0F, 2, 0);

	@BuildItem(icon = 0, itemClass = "SUB.ItemElectricWhip", params = {"ID", "FILE.itemString"})
	public static Item ElectricWhip;
	@BuildItem(icon = 0, itemClass = "SUB.ItemElectromagnet", params = {"ID", "FILE.itemString"})
	public static Item Electromagnet;
	@BuildItem(icon = 0, itemClass = "SUB.ItemFluteOfTheWinds", params = {"ID", "FILE.itemString"})
	public static Item FluteOfTheWinds;

	
	/*
	 * FoD Dimension ID's
	 * Skyr: 26
	 * Gelidos Inferos: 27
	 * Gigas Silva: 28
	 * (Neptune: 29)
	 */
	@Dimension(worldProvider = WorldProviderSkyr.class)
	public static final int dimensionSkyrID = DimensionManager.getNextFreeDimId();

    public static BiomeGenBase SkyrPlains;

	static int startEntityId = 300;
	
	@SideOnly(Side.CLIENT)
	public void Render()
	{
		// Render step 1: Entities
		
		//RenderingRegistry.registerEntityRenderingHandler(EntityFloatingCloud.class, new Render-(new Model-, 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlueSlime.class, new RenderSlime(new ModelSlime(16), new ModelSlime(0), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityJellyfish.class, new RenderJellyfish(new ModelJellyfish(), 0.3F));
		
		// Render step 2: Blocks
		granite.blockIndexInTexture = RenderingRegistry.addTextureOverride("/terrain.png", "/FoD/Skyr/Blocks/Granite.png");
		luxOre.blockIndexInTexture = RenderingRegistry.addTextureOverride("/terrain.png", "/FoD/Skyr/Blocks/LightOre.png");
		luxillianTorch.blockIndexInTexture = RenderingRegistry.addTextureOverride("/terrain.png", "/FoD/Skyr/Blocks/LuxillianTorch.png");
		luxillianBlock.blockIndexInTexture = RenderingRegistry.addTextureOverride("/terrain.png", "/FoD/Skyr/Blocks/LuxillianBlock.png");
		SkyrPortal.blockIndexInTexture = RenderingRegistry.addTextureOverride("/terrain.png", "/FoD/Skyr/Blocks/PortalTexture.png");
		SkyrLeaves.blockIndexInTexture = RenderingRegistry.addTextureOverride("/terrain.png", "/FoD/Skyr/Blocks/SkyLeaves.png");
		Skyweed.blockIndexInTexture = RenderingRegistry.addTextureOverride("/terrain.png", "/FoD/Skyr/Blocks/Skyweed1.png");
		
		// Render step 3: Items
		luxPowder.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/Items/LuxillianDust.png"));
		corruptedStoneSeed.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/Items/CorruptedSeeds.png"));
		blueSlimeball.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/Items/BlueSlimeball.png"));
		aeirPowder.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/Items/AeirPowder.png"));
		nut.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/Items/Nut.png"));
		nutBaked.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/Items/Nut.png"));
		grenadeApple.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/Items/GrenadeApple.png"));
		squirrelMeat.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/Items/SquirrelMeat.png"));
		squirrelMeatCooked.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/Items/CookedSquirrelMeat.png"));

		PomeGranate.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/Items/Pomegranate.png"));
		electricCoil.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/Items/ElectricCoil.png"));
		ElectricWhip.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/Items/ElectricWhip.png"));

		graniteAxe.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/WeaponsAndTools/GraniteAxe.png"));
		granitePickaxe.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/WeaponsAndTools/GranitePickaxe.png"));
		graniteSpade.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/WeaponsAndTools/GraniteShovel.png"));
		graniteSword.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/WeaponsAndTools/GraniteSword.png"));
		graniteHoe.setIconIndex(RenderingRegistry.addTextureOverride("/gui/items.png", "/FoD/Skyr/WeaponsAndTools/GraniteHoe.png"));
	}
	
	public static int getUniqueEntityId() {
		do {
			startEntityId++;
		} while (EntityList.getStringFromID(startEntityId) != null);

		return startEntityId;
	}
	
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor,secondaryColor));
	}
	
	public void RegisterBiomes(){
	 	GameRegistry.registerWorldGenerator(new WorldGeneratorSkyr());
		MinecraftForge.EVENT_BUS.register(new SkyrEvent());
		
		SkyrPlains = new BiomeGenSkyrPlains(this.SkyrPlainsId).setBiomeName("SlyrPlains").setTemperatureRainfall(0.8F, 0.4F);
		skyr = (new BiomeGenSkyr(this.skyrId)).setMinMaxHeight(-1.9F, 1F).setColor(0).setBiomeName("Skyr").setDisableRain();
	}
	
	public void RegisterRecipes(){
		//Craft
		GameRegistry.addRecipe(new ItemStack(luxillianTorch, 1), new Object[] {" # ", " I ", '#', luxPowder, 'I', Item.stick});
		GameRegistry.addRecipe(new ItemStack(luxillianBlock, 1), new Object[] {"###", "###", "###", '#', luxPowder});
		GameRegistry.addShapelessRecipe(new ItemStack(grenadeApple, 1), new Object[] {PomeGranate, Item.gunpowder});
		GameRegistry.addRecipe(new ItemStack(granite, 1, 2), new Object[] {"##", "##", '#', new ItemStack(granite, 1, 1)});
		
		//Tools and weapons
		GameRegistry.addRecipe(new ItemStack(ElectricWhip, 1), new Object[] {"  S", " SC", "L C", 'L', Item.leather, 'S', Item.silk, 'C', electricCoil});
		//GameRegistry.addRecipe(new ItemStack(AeirBoots, 1), new Object[] {"AAA", "F F", "LLL", 'L', Item.leather, 'F', Item.feather, 'A', aeirPowder});
		GameRegistry.addRecipe(new ItemStack(Electromagnet, 1), new Object[] {"C I", "LLL", "C I", 'L', luxPowder, 'C', electricCoil, 'I', nickelIngot});
		
		GameRegistry.addRecipe(new ItemStack(graniteSword, 1), new Object[] {" # ", " # ", " I ", '#', new ItemStack(granite, 1, 0), 'I', Item.stick});
		GameRegistry.addRecipe(new ItemStack(granitePickaxe, 1), new Object[] {"###", " I ", " I ", '#', new ItemStack(granite, 1, 0), 'I', Item.stick});
		GameRegistry.addRecipe(new ItemStack(graniteAxe, 1), new Object[] {"## ", "#I ", " I ", '#', new ItemStack(granite, 1, 0), 'I', Item.stick});
		GameRegistry.addRecipe(new ItemStack(graniteSpade, 1), new Object[] {" # ", " I ", " I ", '#', new ItemStack(granite, 1, 0), 'I', Item.stick});
		GameRegistry.addRecipe(new ItemStack(graniteHoe, 1), new Object[] {"## ", " I ", " I ", '#', new ItemStack(granite, 1, 0), 'I', Item.stick});
				
				//Smelt
		GameRegistry.addSmelting(squirrelMeat.itemID, new ItemStack(squirrelMeatCooked, 1), 0.35F);
		GameRegistry.addSmelting(nickelOre.blockID, new ItemStack(nickelIngot, 1), 1.0F);
		FurnaceRecipes.smelting().addSmelting(granite.blockID, 0, new ItemStack(granite, 1, 1), 0.0F);	
	}

	
	public void RegisterEntities()
	{
		/*ModLoader.registerEntityID(EntityBlueSlime.class,"BlueSlime", 100);
		ModLoader.addSpawn(EntityBlueSlime.class, 2, 1, 4, EnumCreatureType.creature, BiomeGenBase.plains);
	     
		ModLoader.registerEntityID(EntityFloatingCloud.class,"Floating Cloud", 101);
		ModLoader.addSpawn(EntityFloatingCloud.class, 2, 1, 2, EnumCreatureType.creature, BiomeGenBase.plains);
	     
		ModLoader.registerEntityID(EntityNut.class,"Nut", 102);*/
	     
		
		EntityRegistry.registerModEntity(EntityJellyfish.class, "Jellyfish", 1, FOD.instance, 45, 2, true);
		EntityRegistry.addSpawn(EntityJellyfish.class, 4, 1, 4, EnumCreatureType.monster, SkyrPlains);
		LanguageRegistry.instance().addStringLocalization("entity.FODSkyr.EntityJellyfish.name", "Jellyfish");
		
		EntityRegistry.registerModEntity(EntityBlueSlime.class,"BlueSlime", 3, FOD.instance, 45, 5, true);
		LanguageRegistry.instance().addStringLocalization("entity.FODSkyr.EntityBlueSlime.name", "BlueSlime");
		
		EntityRegistry.registerModEntity(EntityNut.class, "Nut", 202, this, 30, 2, true);
		EntityRegistry.registerModEntity(EntityGrenadeApple.class, "GrenadeApple", 203, this, 30, 2, true);
		EntityRegistry.registerModEntity(EntityBlueSlimeBall.class, "Blue Slime Ball", 204, this, 30, 2, true);
		
		registerEntityEgg(EntityJellyfish.class, 0xFF4800, 0x00FFF2);
		registerEntityEgg(EntityBlueSlime.class, 0x2040AF, 0x4060C0);
	
	}

}

package Gigas.Silva.CoreMod;

import net.minecraftforge.client.MinecraftForgeClient;
import Gigas.Silva.Entity.EntityJelly;
import Gigas.Silva.Entity.ModelJelly;
import Gigas.Silva.Entity.RenderJelly;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class GigasClient extends GigasProxy
{
        public void registerRenderInformation()
        {

                MinecraftForgeClient.preloadTexture("/Gigas/Textures/Blocks.png");
                MinecraftForgeClient.preloadTexture("/Gigas/Textures/Items.png");
            	RenderingRegistry.instance().registerEntityRenderingHandler(EntityJelly.class, new RenderJelly(new ModelJelly(), 0.3F));


        }
}
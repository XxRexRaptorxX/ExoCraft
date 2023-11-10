package xxrexraptorxx.exocraft.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xxrexraptorxx.exocraft.main.ModBlocks;
import xxrexraptorxx.exocraft.main.ModItems;
import xxrexraptorxx.exocraft.util.Events;
import xxrexraptorxx.exocraft.util.FuelHandler;
import xxrexraptorxx.exocraft.util.OreDictionaryHandler;
import xxrexraptorxx.exocraft.util.UpdateChecker;
import xxrexraptorxx.exocraft.world.WorldGenerator;
import xxrexraptorxx.exocraft.world.WorldTickHandler;

@Mod.EventBusSubscriber
public class CommonProxy {
	
    public ModItems items;
    public ModBlocks blocks;

    
	
    public void preInit(FMLPreInitializationEvent event) {
        
        // Update Checker //
    	UpdateChecker.checkForUpdates();  
    	
    	// Events //
    	MinecraftForge.EVENT_BUS.register(new Events());
   	 
    	    	    	
    	// Items //
    	items = new ModItems();
       	items.init();
    	items.register();
    	
    	// Blocks //
    	blocks = new ModBlocks();
       	blocks.init();
    	blocks.register();

    	// Handler //
        GameRegistry.registerFuelHandler(new FuelHandler());
        
	    // Generation //
        GameRegistry.registerWorldGenerator(WorldGenerator.instance, 1);
        MinecraftForge.EVENT_BUS.register(WorldGenerator.instance);

    }

	public void init(FMLInitializationEvent event) {
    	

    	// Handler //
        OreDictionaryHandler.registerOreDictionary();
        MinecraftForge.EVENT_BUS.register(WorldTickHandler.instance);
         


	}

	public void postInit(FMLPostInitializationEvent event) {
	}
}
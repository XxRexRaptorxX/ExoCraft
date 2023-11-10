package xxrexraptorxx.exocraft.main;

import org.apache.logging.log4j.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xxrexraptorxx.exocraft.proxy.CommonProxy;

/**---------------------------------------------------------------------------------*
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage https://minecraft.curseforge.com/projects/exo-craft
 **---------------------------------------------------------------------------------*/


@Mod(modid = Reference.MODID, version = Reference.VERSION, acceptedMinecraftVersions = Reference.MCVERSIONS)
public class ExoCraft {

    @Mod.Instance
    public static ExoCraft instance;
    
    public static Logger logger;
    
    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
    public static CommonProxy proxy;
    

	
    // Creative-Tab //
    public static CreativeTabs mainTab = new CreativeTabs("exoTab") {
	
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.atlasHelmet);
		}
	};

	
    /***********************************************************************************************************************************/ 
    /***********************************************************************************************************************************/
    
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
   	 	logger = event.getModLog();
    	proxy.preInit(event);
    }
  
    
    
    @EventHandler
    public void Init(FMLInitializationEvent event) {
    	proxy.init(event);
    }
   
   

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	proxy.postInit(event);
    }
 
}
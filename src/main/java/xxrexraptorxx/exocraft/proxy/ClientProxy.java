package xxrexraptorxx.exocraft.proxy;
 
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import xxrexraptorxx.exocraft.main.ModBlocks;
import xxrexraptorxx.exocraft.main.ModItems;
 
@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
 
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}
	
	
   @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        
        //Items
       	registerModel(ModItems.atlasHelmet);
       	registerModel(ModItems.atlasChestplate);
       	registerModel(ModItems.atlasLeggings);
       	registerModel(ModItems.atlasBoots);
       	registerModel(ModItems.ionHelmet);
       	registerModel(ModItems.ionChestplate);
       	registerModel(ModItems.ionLeggings);
       	registerModel(ModItems.ionBoots);
       	registerModel(ModItems.legionHelmet);
       	registerModel(ModItems.legionChestplate);
       	registerModel(ModItems.legionLeggings);
       	registerModel(ModItems.legionBoots);
       	registerModel(ModItems.ogreHelmet);
       	registerModel(ModItems.ogreChestplate);
       	registerModel(ModItems.ogreLeggings);
       	registerModel(ModItems.ogreBoots);
       	registerModel(ModItems.stryderHelmet);
       	registerModel(ModItems.stryderChestplate);
       	registerModel(ModItems.stryderLeggings);
       	registerModel(ModItems.stryderBoots);
       	registerModel(ModItems.energyCore);
       	registerModel(ModItems.lavaCrystal);
       	registerModel(ModItems.redstoneCircuit);
       	registerModel(ModItems.reinforcedIronPlate);
       	registerModel(ModItems.unitAtlas);
       	registerModel(ModItems.unitIon);
       	registerModel(ModItems.unitLegion);
       	registerModel(ModItems.unitOgre);
       	registerModel(ModItems.unitStryder);
       	registerModel(ModItems.industrialExcavator);
       	registerModel(ModItems.industrialMiner);
       	registerModel(ModItems.industrialMultiTool);
       	registerModel(ModItems.machineCase);
       	
    	
    	// Blocks //
    	registerModel(ModBlocks.fabricator);
    	registerModel(ModBlocks.lavaCrystalBlock);
    	registerModel(ModBlocks.lavaCrystalOre);

   }
 
    

	public static void registerModel(Object obj) {
		if(obj instanceof Item) {
			Item item = (Item) obj;
    			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		} else if (obj instanceof Block) {
			Item item = Item.getItemFromBlock((Block) obj);
				Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		} else {
			throw new IllegalArgumentException("Item or Block required!");	
		}
	}
    
}




   

  
package xxrexraptorxx.exocraft.main;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xxrexraptorxx.exocraft.blocks.BlockFabricator;
import xxrexraptorxx.exocraft.blocks.BlockLavaCrystal;
import xxrexraptorxx.exocraft.blocks.BlockLavaCrystalOre;
import xxrexraptorxx.exocraft.gui.GuiHandlerFabricator;
import xxrexraptorxx.exocraft.gui.GuiHandlerRegistry;
import xxrexraptorxx.exocraft.tileentitys.TileEntityFabricator;
import xxrexraptorxx.exocraft.util.NameUtils;

public class ModBlocks {

	public static Block lavaCrystalBlock;
	public static Block lavaCrystalOre;
	public static Block fabricator;
	public static final int guiID= 1;

	
	
	
	
		public void init() {
		
			fabricator = new BlockFabricator();
			lavaCrystalBlock = new BlockLavaCrystal();
			lavaCrystalOre = new BlockLavaCrystalOre();

			

			NameUtils.setNames(fabricator, "fabricator");
			NameUtils.setNames(lavaCrystalBlock, "lava_crystal_block");
			NameUtils.setNames(lavaCrystalOre, "lava_crystal_ore");
		
		}
		
		
		
		public void register() {
			
			registerBlock(fabricator);
			registerBlock(lavaCrystalBlock);
			registerBlock(lavaCrystalOre);

			
			
			
			//Tile Entitys
			GameRegistry.registerTileEntity(TileEntityFabricator.class, Reference.MODID + ":fabricator");
			
			
			//GUI
			NetworkRegistry.INSTANCE.registerGuiHandler(ExoCraft.instance, GuiHandlerRegistry.getInstance());
			GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerFabricator(), GuiHandlerFabricator.getGuiID());

		}
		
		
		
		
		private static void registerBlock(Block block) {
			ForgeRegistries.BLOCKS.register(block);
			ItemBlock itemblock = new ItemBlock(block);
			itemblock.setRegistryName(block.getRegistryName());
			ForgeRegistries.ITEMS.register(itemblock);
		}
}

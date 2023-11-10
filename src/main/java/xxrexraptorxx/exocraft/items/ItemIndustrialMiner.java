package xxrexraptorxx.exocraft.items;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import xxrexraptorxx.exocraft.configs.ConfigGeneral;
import xxrexraptorxx.exocraft.main.ExoCraft;
import xxrexraptorxx.exocraft.main.ModItems;
import xxrexraptorxx.exocraft.util.ItemCustomIndustrial;

public class ItemIndustrialMiner extends ItemCustomIndustrial {

	private static final Set EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, 
				Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.DOUBLE_STONE_SLAB2, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, 
				Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, 
				Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, 
				Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_SLAB2});
	
    public ItemIndustrialMiner(ToolMaterial material) {
    	super(1, 0, 0F, material, EFFECTIVE_ON, "pickaxe", 3, 0.5F);
        this.setMaxStackSize(1);
        if(ConfigGeneral.activateIndustrialTools) {
        	this.setCreativeTab(ExoCraft.mainTab);
        }    }
    
    
	@Override
	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
	 return stack.getItem() == ModItems.reinforcedIronPlate;
	}  
	

}

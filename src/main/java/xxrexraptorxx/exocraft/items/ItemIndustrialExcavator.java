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

public class ItemIndustrialExcavator extends ItemCustomIndustrial {

	private static final Set EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, 
					Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND, Blocks.SNOW_LAYER});

	
    public ItemIndustrialExcavator(ToolMaterial material) {
    	super(1, 0, 0F, material, EFFECTIVE_ON, "shovel", 3, 0.5F);
        this.setMaxStackSize(1);
        if(ConfigGeneral.activateIndustrialTools) {
        	this.setCreativeTab(ExoCraft.mainTab);
        }
    }

	
	@Override
	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
	 return stack.getItem() == ModItems.reinforcedIronPlate;
	}  
	

}

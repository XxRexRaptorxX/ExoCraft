package xxrexraptorxx.exocraft.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import xxrexraptorxx.exocraft.main.ModBlocks;
import xxrexraptorxx.exocraft.main.ModItems;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.getItem().equals(ModItems.lavaCrystal)) {
			return 1000;   
		}	
		if(fuel.getItem().equals(Item.getItemFromBlock(ModBlocks.lavaCrystalBlock))) {
			return 9500;  
		}	

	return 0;
	
	}

}
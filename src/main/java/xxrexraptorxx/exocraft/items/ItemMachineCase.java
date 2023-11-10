package xxrexraptorxx.exocraft.items;

import net.minecraft.item.Item;
import xxrexraptorxx.exocraft.configs.ConfigGeneral;
import xxrexraptorxx.exocraft.main.ExoCraft;

public class ItemMachineCase extends Item {
	
	public ItemMachineCase () {
		super();
		this.setMaxStackSize(16);
        if(ConfigGeneral.activateIndustrialTools) {
        	this.setCreativeTab(ExoCraft.mainTab);
        }
	}

}

package xxrexraptorxx.exocraft.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import xxrexraptorxx.exocraft.main.References;

public class CreativeModeTabs {


    public static CreativeModeTab MOD_TAB = new CreativeModeTab(References.MODID + "_tab") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.LEGION_HELMET.get());
        }
    };
}

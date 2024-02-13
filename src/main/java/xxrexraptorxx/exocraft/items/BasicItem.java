package xxrexraptorxx.exocraft.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;
import xxrexraptorxx.exocraft.registry.CreativeModeTabs;
import xxrexraptorxx.exocraft.registry.ModItems;

public class BasicItem extends Item {

    public BasicItem() {
        super(new Properties()
                .tab(CreativeModeTabs.MOD_TAB)
        );
    }


    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        if (this == ModItems.LAVA_CRYSTAL.get()) {
            return 2000;
        } else {
            return 0;
        }
    }
}

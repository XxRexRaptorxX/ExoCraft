package xxrexraptorxx.exocraft.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;
import xxrexraptorxx.exocraft.registry.ModItems;

public class UnitItem extends Item {

    public UnitItem() {
        super(new Properties()
                .stacksTo(16)
        );
    }


    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}

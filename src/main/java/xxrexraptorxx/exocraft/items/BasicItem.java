package xxrexraptorxx.exocraft.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;
import xxrexraptorxx.exocraft.registry.ModItems;

public class BasicItem extends Item {

    public BasicItem() {
        super(new Properties()
        );
    }


    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        if (this == ModItems.LAVA_CRYSTAL.get()) {
            return 5000;
        } else {
            return 0;
        }
    }
}

package xxrexraptorxx.exocraft.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import xxrexraptorxx.exocraft.registry.ModItems;

public class UnitItem extends Item {

    public UnitItem() {
        super(new Properties()
                .stacksTo(16)
                .rarity(Rarity.RARE)
        );
    }


    @Override
    public boolean isFoil(ItemStack stack) {
        if (this == ModItems.EMPTY_UNIT.get() || this == ModItems.OLD_UNIT.get()) {
            return false;
        } else {
            return true;
        }
    }
}

package xxrexraptorxx.exocraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import xxrexraptorxx.exocraft.utils.enums.ArmorSlots;

import javax.annotation.Nullable;
import java.util.List;

public class ModuleItem extends Item {

    public ModuleItem() {
        super(new Properties()
                .stacksTo(16)
        );
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> list, TooltipFlag flag) {
        list.add(Component.translatable("message.exocraft.install_desc").withStyle(ChatFormatting.GRAY));
        list.add(Component.empty());
        list.add(Component.translatable("message.exocraft.can_install").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.UNDERLINE));
        list.add(Component.translatable(ArmorSlots.getArmorSlotsForArmor(this.asItem()).getLangKey()).withStyle(ChatFormatting.GRAY));
    }

}

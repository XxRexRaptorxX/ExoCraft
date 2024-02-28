package xxrexraptorxx.exocraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import xxrexraptorxx.exocraft.main.References;
import xxrexraptorxx.exocraft.registry.ModItems;

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
        list.add(Component.translatable(getEquipLanguageKeyForModules(stack.getItem())).withStyle(ChatFormatting.GRAY));
    }


    public static boolean isCorrectModule(ArmorItem armor, Item module) {
        ArmorItem.Type helmet = ArmorItem.Type.HELMET;
        ArmorItem.Type chestplate = ArmorItem.Type.CHESTPLATE;
        ArmorItem.Type leggings = ArmorItem.Type.LEGGINGS;
        ArmorItem.Type boots = ArmorItem.Type.BOOTS;

        if (module == ModItems.SNOW_WALKER_MODULE.get() && armor.getType() == boots) {
            return true;

        } else if (module == ModItems.ADVANCED_VISOR_MODULE.get() && armor.getType() == helmet) {
            return true;

        } else if (module == ModItems.GLIDER_MODULE.get() && armor.getType() == chestplate) {
            return true;

        } else if (module.asItem() == ModItems.DETERRENCE_MODULE.get() || module.asItem() == ModItems.FIRE_RESISTANT_COATING_MODULE.get()) {
            return true;

        } else {
            return false;
        }
    }


    public static String getEquipLanguageKeyForModules(Item armor) {
        String langkey;

        if (armor == ModItems.SNOW_WALKER_MODULE.get()) {
            langkey = "boots";
        } else if (armor == ModItems.ADVANCED_VISOR_MODULE.get()) {
            langkey = "helmet";
        } else if (armor == ModItems.GLIDER_MODULE.get()) {
            langkey = "chestplate";
        } else {
            langkey = "all";
        }

        return "message." + References.MODID + "." + langkey;
    }
}

package xxrexraptorxx.exocraft.utils.enums;

import net.minecraft.world.item.Item;
import xxrexraptorxx.exocraft.main.References;
import xxrexraptorxx.exocraft.registry.ModItems;

public enum ArmorSlots {

    HELMET ("helmet"),
    CHESTPLATE("chestplate"),
    LEGGINGS("leggings"),
    BOOTS("boots"),
    ALL("all");


    private String registry_name;

    ArmorSlots(String registry_name) {
        this.registry_name = registry_name;
    }


    public String getRegistryName() {
        return registry_name;
    }


    public String getLangKey() {
        return "message." + References.MODID + "." + registry_name;
    }


    public static ArmorSlots getArmorSlotsForArmor(Item armor) {
        if (armor == ModItems.SNOW_WALKER_MODULE.get()) {
            return BOOTS;
        } else if (armor == ModItems.ADVANCED_VISOR_MODULE.get()) {
            return HELMET;
        } else if (armor == ModItems.GLIDER_MODULE.get()) {
            return CHESTPLATE;
        } else {
            return ALL;
        }
    }
}

package xxrexraptorxx.exocraft.utils.enums;

import xxrexraptorxx.exocraft.main.References;

public enum Modules {

    SNOW_WALKER_MODULE ("snow_walker_module"),
    ADVANCED_VISOR_MODULE("advanced_visor_module"),
    GLIDER_MODULE("glider_module"),
    DETERRENCE_MODULE("deterrence_module"),
    FIRE_RESISTANT_COATING_MODULE("fire_resistant_coating_module");

    private String registry_name;

    Modules(String registry_name) {
        this.registry_name = registry_name;
    }


    public String getRegistryName() {
        return References.MODID + registry_name;
    }


    public String getLangKey() {
        return "item." + References.MODID + "." + registry_name;
    }

}

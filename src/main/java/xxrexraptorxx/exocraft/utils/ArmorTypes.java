package xxrexraptorxx.exocraft.utils;

public enum ArmorTypes {

    ATLAS ("atlas"),
    LEGION("legion"),
    STRYDER("stryder"),
    OGRE("ogre"),
    ION("ion");


    private String registry_name;

    ArmorTypes(String registry_name) {
        this.registry_name = registry_name;
    }


    public String getRegistryName() {
        return registry_name;
    }
}

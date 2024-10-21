package xxrexraptorxx.exocraft.utils.enums;

public enum ExosuitTypes {

    ATLAS ("atlas"),
    LEGION("legion"),
    STRYDER("stryder"),
    OGRE("ogre"),
    ION("ion");


    private String registry_name;

    ExosuitTypes(String registry_name) {
        this.registry_name = registry_name;
    }


    public String getRegistryName() {
        return registry_name;
    }
}

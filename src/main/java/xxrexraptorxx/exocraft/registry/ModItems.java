package xxrexraptorxx.exocraft.registry;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.exocraft.items.BasicItem;
import xxrexraptorxx.exocraft.items.UnitItem;
import xxrexraptorxx.exocraft.main.References;
import xxrexraptorxx.exocraft.utils.ArmorMaterials;

public class ModItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, References.MODID);


    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
    }

    public static final RegistryObject<ArmorItem> ATLAS_HELMET = ITEMS.register("atlas_helmet", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> ATLAS_LEGGINGS = ITEMS.register("atlas_leggings", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<ArmorItem> ATLAS_CHESTPLATE = ITEMS.register("atlas_chestplate", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<ArmorItem> ATLAS_BOOTS = ITEMS.register("atlas_boots", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<ArmorItem> LEGION_HELMET = ITEMS.register("legion_helmet", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> LEGION_LEGGINGS = ITEMS.register("legion_leggings", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<ArmorItem> LEGION_CHESTPLATE = ITEMS.register("legion_chestplate", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<ArmorItem> LEGION_BOOTS = ITEMS.register("legion_boots", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<ArmorItem> STRYDER_HELMET = ITEMS.register("stryder_helmet", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> STRYDER_LEGGINGS = ITEMS.register("stryder_leggings", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<ArmorItem> STRYDER_CHESTPLATE = ITEMS.register("stryder_chestplate", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<ArmorItem> STRYDER_BOOTS = ITEMS.register("stryder_boots", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<ArmorItem> OGRE_HELMET = ITEMS.register("ogre_helmet", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> OGRE_LEGGINGS = ITEMS.register("ogre_leggings", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<ArmorItem> OGRE_CHESTPLATE = ITEMS.register("ogre_chestplate", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<ArmorItem> OGRE_BOOTS = ITEMS.register("ogre_boots", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<ArmorItem> ION_HELMET = ITEMS.register("ion_helmet", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> ION_LEGGINGS = ITEMS.register("ion_leggings", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<ArmorItem> ION_CHESTPLATE = ITEMS.register("ion_chestplate", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<ArmorItem> ION_BOOTS = ITEMS.register("ion_boots", () -> new ArmorItem(ArmorMaterials.MECH, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<BasicItem> ENERGY_CORE = ITEMS.register("energy_core", BasicItem::new);
    public static final RegistryObject<BasicItem> LAVA_CRYSTAL = ITEMS.register("lava_crystal", BasicItem::new);
    public static final RegistryObject<BasicItem> REDSTONE_CIRCUIT = ITEMS.register("redstone_circuit", BasicItem::new);
    public static final RegistryObject<BasicItem> REINFORCED_IRON_PLATE = ITEMS.register("reinforced_iron_plate", BasicItem::new);
    public static final RegistryObject<UnitItem> ATLAS_UNIT = ITEMS.register("unit_atlas", UnitItem::new);
    public static final RegistryObject<UnitItem> OGRE_UNIT = ITEMS.register("unit_ogre", UnitItem::new);
    public static final RegistryObject<UnitItem> LEGION_UNIT = ITEMS.register("unit_legion", UnitItem::new);
    public static final RegistryObject<UnitItem> STRYDER_UNIT = ITEMS.register("unit_stryder", UnitItem::new);
    public static final RegistryObject<UnitItem> ION_UNIT = ITEMS.register("unit_ion", UnitItem::new);
}
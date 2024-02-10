package xxrexraptorxx.exocraft.registry;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.exocraft.items.BasicItem;
import xxrexraptorxx.exocraft.items.CustomArmorItem;
import xxrexraptorxx.exocraft.items.UnitItem;
import xxrexraptorxx.exocraft.main.References;
import xxrexraptorxx.exocraft.utils.ArmorMaterials;

public class ModItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, References.MODID);


    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
    }

    public static final RegistryObject<CustomArmorItem> REINFORCED_IRON_HELMET = ITEMS.register("reinforced_iron_helmet", () -> new CustomArmorItem(ArmorMaterials.REINFORCED_IRON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> REINFORCED_IRON_LEGGINGS = ITEMS.register("reinforced_iron_leggings", () -> new CustomArmorItem(ArmorMaterials.REINFORCED_IRON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> REINFORCED_IRON_CHESTPLATE = ITEMS.register("reinforced_iron_chestplate", () -> new CustomArmorItem(ArmorMaterials.REINFORCED_IRON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> REINFORCED_IRON_BOOTS = ITEMS.register("reinforced_iron_boots", () -> new CustomArmorItem(ArmorMaterials.REINFORCED_IRON, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<CustomArmorItem> ATLAS_HELMET = ITEMS.register("atlas_helmet", () -> new CustomArmorItem(ArmorMaterials.ATLAS, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> ATLAS_LEGGINGS = ITEMS.register("atlas_leggings", () -> new CustomArmorItem(ArmorMaterials.ATLAS, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> ATLAS_CHESTPLATE = ITEMS.register("atlas_chestplate", () -> new CustomArmorItem(ArmorMaterials.ATLAS, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> ATLAS_BOOTS = ITEMS.register("atlas_boots", () -> new CustomArmorItem(ArmorMaterials.ATLAS, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<CustomArmorItem> LEGION_HELMET = ITEMS.register("legion_helmet", () -> new CustomArmorItem(ArmorMaterials.LEGION, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> LEGION_LEGGINGS = ITEMS.register("legion_leggings", () -> new CustomArmorItem(ArmorMaterials.LEGION, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> LEGION_CHESTPLATE = ITEMS.register("legion_chestplate", () -> new CustomArmorItem(ArmorMaterials.LEGION, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> LEGION_BOOTS = ITEMS.register("legion_boots", () -> new CustomArmorItem(ArmorMaterials.LEGION, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<CustomArmorItem> STRYDER_HELMET = ITEMS.register("stryder_helmet", () -> new CustomArmorItem(ArmorMaterials.STRYDER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> STRYDER_LEGGINGS = ITEMS.register("stryder_leggings", () -> new CustomArmorItem(ArmorMaterials.STRYDER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> STRYDER_CHESTPLATE = ITEMS.register("stryder_chestplate", () -> new CustomArmorItem(ArmorMaterials.STRYDER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> STRYDER_BOOTS = ITEMS.register("stryder_boots", () -> new CustomArmorItem(ArmorMaterials.STRYDER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<CustomArmorItem> OGRE_HELMET = ITEMS.register("ogre_helmet", () -> new CustomArmorItem(ArmorMaterials.OGRE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> OGRE_LEGGINGS = ITEMS.register("ogre_leggings", () -> new CustomArmorItem(ArmorMaterials.OGRE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> OGRE_CHESTPLATE = ITEMS.register("ogre_chestplate", () -> new CustomArmorItem(ArmorMaterials.OGRE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> OGRE_BOOTS = ITEMS.register("ogre_boots", () -> new CustomArmorItem(ArmorMaterials.OGRE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<CustomArmorItem> ION_HELMET = ITEMS.register("ion_helmet", () -> new CustomArmorItem(ArmorMaterials.ION, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> ION_LEGGINGS = ITEMS.register("ion_leggings", () -> new CustomArmorItem(ArmorMaterials.ION, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> ION_CHESTPLATE = ITEMS.register("ion_chestplate", () -> new CustomArmorItem(ArmorMaterials.ION, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<CustomArmorItem> ION_BOOTS = ITEMS.register("ion_boots", () -> new CustomArmorItem(ArmorMaterials.ION, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<BasicItem> ENERGY_CORE = ITEMS.register("energy_core", BasicItem::new);
    public static final RegistryObject<BasicItem> LAVA_CRYSTAL = ITEMS.register("lava_crystal", BasicItem::new);
    public static final RegistryObject<BasicItem> REDSTONE_CIRCUIT = ITEMS.register("redstone_circuit", BasicItem::new);
    public static final RegistryObject<BasicItem> REINFORCED_IRON_PLATE = ITEMS.register("reinforced_iron_plate", BasicItem::new);

    public static final RegistryObject<BasicItem> ATLAS_MATRIX = ITEMS.register("matrix_atlas", BasicItem::new);
    public static final RegistryObject<BasicItem> OGRE_MATRIX = ITEMS.register("matrix_ogre", BasicItem::new);
    public static final RegistryObject<BasicItem> LEGION_MATRIX = ITEMS.register("matrix_legion", BasicItem::new);
    public static final RegistryObject<BasicItem> STRYDER_MATRIX = ITEMS.register("matrix_stryder", BasicItem::new);
    public static final RegistryObject<BasicItem> ION_MATRIX = ITEMS.register("matrix_ion", BasicItem::new);

    public static final RegistryObject<UnitItem> EMPTY_UNIT = ITEMS.register("unit_empty", UnitItem::new);
    public static final RegistryObject<UnitItem> ATLAS_UNIT = ITEMS.register("unit_atlas", UnitItem::new);
    public static final RegistryObject<UnitItem> OGRE_UNIT = ITEMS.register("unit_ogre", UnitItem::new);
    public static final RegistryObject<UnitItem> LEGION_UNIT = ITEMS.register("unit_legion", UnitItem::new);
    public static final RegistryObject<UnitItem> STRYDER_UNIT = ITEMS.register("unit_stryder", UnitItem::new);
    public static final RegistryObject<UnitItem> ION_UNIT = ITEMS.register("unit_ion", UnitItem::new);
    public static final RegistryObject<UnitItem> OLD_UNIT = ITEMS.register("unit_old", UnitItem::new);

}
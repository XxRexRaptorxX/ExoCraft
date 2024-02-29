package xxrexraptorxx.exocraft.registry;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.exocraft.items.*;
import xxrexraptorxx.exocraft.main.References;
import xxrexraptorxx.exocraft.utils.ArmorMaterials;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, References.MODID);


    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
    }

    public static final RegistryObject<ArmorItem> REINFORCED_IRON_HELMET = ITEMS.register("reinforced_iron_helmet", () -> new ArmorItem(ArmorMaterials.REINFORCED_IRON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> REINFORCED_IRON_LEGGINGS = ITEMS.register("reinforced_iron_leggings", () -> new ArmorItem(ArmorMaterials.REINFORCED_IRON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<ArmorItem> REINFORCED_IRON_CHESTPLATE = ITEMS.register("reinforced_iron_chestplate", () -> new ArmorItem(ArmorMaterials.REINFORCED_IRON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<ArmorItem> REINFORCED_IRON_BOOTS = ITEMS.register("reinforced_iron_boots", () -> new ArmorItem(ArmorMaterials.REINFORCED_IRON, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<MechArmorItem> ATLAS_HELMET = ITEMS.register("atlas_helmet", () -> new MechArmorItem(ArmorMaterials.ATLAS, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<MechArmorItem> ATLAS_LEGGINGS = ITEMS.register("atlas_leggings", () -> new MechArmorItem(ArmorMaterials.ATLAS, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<MechArmorItem> ATLAS_CHESTPLATE = ITEMS.register("atlas_chestplate", () -> new MechArmorItem(ArmorMaterials.ATLAS, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<MechArmorItem> ATLAS_BOOTS = ITEMS.register("atlas_boots", () -> new MechArmorItem(ArmorMaterials.ATLAS, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<MechArmorItem> LEGION_HELMET = ITEMS.register("legion_helmet", () -> new MechArmorItem(ArmorMaterials.LEGION, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<MechArmorItem> LEGION_LEGGINGS = ITEMS.register("legion_leggings", () -> new MechArmorItem(ArmorMaterials.LEGION, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<MechArmorItem> LEGION_CHESTPLATE = ITEMS.register("legion_chestplate", () -> new MechArmorItem(ArmorMaterials.LEGION, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<MechArmorItem> LEGION_BOOTS = ITEMS.register("legion_boots", () -> new MechArmorItem(ArmorMaterials.LEGION, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<MechArmorItem> STRYDER_HELMET = ITEMS.register("stryder_helmet", () -> new MechArmorItem(ArmorMaterials.STRYDER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<MechArmorItem> STRYDER_LEGGINGS = ITEMS.register("stryder_leggings", () -> new MechArmorItem(ArmorMaterials.STRYDER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<MechArmorItem> STRYDER_CHESTPLATE = ITEMS.register("stryder_chestplate", () -> new MechArmorItem(ArmorMaterials.STRYDER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<MechArmorItem> STRYDER_BOOTS = ITEMS.register("stryder_boots", () -> new MechArmorItem(ArmorMaterials.STRYDER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<MechArmorItem> OGRE_HELMET = ITEMS.register("ogre_helmet", () -> new MechArmorItem(ArmorMaterials.OGRE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<MechArmorItem> OGRE_LEGGINGS = ITEMS.register("ogre_leggings", () -> new MechArmorItem(ArmorMaterials.OGRE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<MechArmorItem> OGRE_CHESTPLATE = ITEMS.register("ogre_chestplate", () -> new MechArmorItem(ArmorMaterials.OGRE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<MechArmorItem> OGRE_BOOTS = ITEMS.register("ogre_boots", () -> new MechArmorItem(ArmorMaterials.OGRE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<MechArmorItem> ION_HELMET = ITEMS.register("ion_helmet", () -> new MechArmorItem(ArmorMaterials.ION, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<MechArmorItem> ION_LEGGINGS = ITEMS.register("ion_leggings", () -> new MechArmorItem(ArmorMaterials.ION, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<MechArmorItem> ION_CHESTPLATE = ITEMS.register("ion_chestplate", () -> new MechArmorItem(ArmorMaterials.ION, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<MechArmorItem> ION_BOOTS = ITEMS.register("ion_boots", () -> new MechArmorItem(ArmorMaterials.ION, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<EnergyItem> ENERGY_CORE = ITEMS.register("energy_core", () -> new EnergyItem(50000, 1500));
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

    public static final RegistryObject<ModuleItem> BLANK_MODULE = ITEMS.register("blank_module", ModuleItem::new);
    public static final RegistryObject<ModuleItem> SNOW_WALKER_MODULE = ITEMS.register("snow_walker_module", ModuleItem::new);
    public static final RegistryObject<ModuleItem> ADVANCED_VISOR_MODULE = ITEMS.register("advanced_visor_module", ModuleItem::new);
    public static final RegistryObject<ModuleItem> GLIDER_MODULE = ITEMS.register("glider_module", ModuleItem::new);
    public static final RegistryObject<ModuleItem> DETERRENCE_MODULE = ITEMS.register("deterrence_module", ModuleItem::new);
    public static final RegistryObject<ModuleItem> FIRE_RESISTANT_COATING_MODULE = ITEMS.register("fire_resistant_coating_module", ModuleItem::new);

}
package xxrexraptorxx.exocraft.main;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import xxrexraptorxx.exocraft.items.ItemArmorAtlas;
import xxrexraptorxx.exocraft.items.ItemArmorIon;
import xxrexraptorxx.exocraft.items.ItemArmorLegion;
import xxrexraptorxx.exocraft.items.ItemArmorOgre;
import xxrexraptorxx.exocraft.items.ItemArmorStryder;
import xxrexraptorxx.exocraft.items.ItemEnergyCore;
import xxrexraptorxx.exocraft.items.ItemIndustrialExcavator;
import xxrexraptorxx.exocraft.items.ItemIndustrialMiner;
import xxrexraptorxx.exocraft.items.ItemIndustrialMultiTool;
import xxrexraptorxx.exocraft.items.ItemLavaCrystal;
import xxrexraptorxx.exocraft.items.ItemMachineCase;
import xxrexraptorxx.exocraft.items.ItemRedstoneCircuit;
import xxrexraptorxx.exocraft.items.ItemReinforcedIronPlate;
import xxrexraptorxx.exocraft.items.ItemUnitAtlas;
import xxrexraptorxx.exocraft.items.ItemUnitIon;
import xxrexraptorxx.exocraft.items.ItemUnitLegion;
import xxrexraptorxx.exocraft.items.ItemUnitOgre;
import xxrexraptorxx.exocraft.items.ItemUnitStryder;
import xxrexraptorxx.exocraft.util.NameUtils;


public class ModItems {
	

		// Items //
		public static Item energyCore;
		public static Item lavaCrystal;
		public static Item redstoneCircuit;
		public static Item reinforcedIronPlate;
		public static Item unitAtlas;
		public static Item unitIon;
		public static Item unitLegion;
		public static Item unitOgre;
		public static Item unitStryder;
		public static Item industrialExcavator;
		public static Item industrialMiner;
		public static Item industrialMultiTool;
		public static Item machineCase;
		
		public static ItemArmor atlasHelmet;
		public static ItemArmor atlasChestplate;
		public static ItemArmor atlasLeggings;
		public static ItemArmor atlasBoots;
		public static ItemArmor ionHelmet;
		public static ItemArmor ionChestplate;
		public static ItemArmor ionLeggings;
		public static ItemArmor ionBoots;
		public static ItemArmor legionHelmet;
		public static ItemArmor legionChestplate;
		public static ItemArmor legionLeggings;
		public static ItemArmor legionBoots;
		public static ItemArmor ogreHelmet;
		public static ItemArmor ogreChestplate;
		public static ItemArmor ogreLeggings;
		public static ItemArmor ogreBoots;
		public static ItemArmor stryderHelmet;
		public static ItemArmor stryderChestplate;
		public static ItemArmor stryderLeggings;
		public static ItemArmor stryderBoots;
		
		public static ArmorMaterial atlasAM;
		public static ArmorMaterial ionAM;
		public static ArmorMaterial legionAM;
		public static ArmorMaterial ogreAM;
		public static ArmorMaterial stryderAM;
	
		public static ToolMaterial industrialTM;
	
	
	
	public void init() {
	
//					5                {1, 3, 2, 1} for leather armor (7 at all)
//				    15    			 {2, 5, 4, 1} for chain armor   (12 at all)
//					15    			 {2, 6, 5, 2} for iron armor    (15 at all)
//					7    			 {2, 5, 3, 1} for gold armor    (11 at all)
//					32               {3, 8, 6, 3} for diamond armor (20 at all - do not use more!)

//																			         durability		    armor	 enchantability                        toughness
		atlasAM = EnumHelper.addArmorMaterial("atlas", Reference.MODID + ":atlas",       30, new int[] {3, 8, 6, 3},  0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1);
		ionAM = EnumHelper.addArmorMaterial("ion", Reference.MODID + ":ion",             25, new int[] {3, 6, 6, 3},  5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);
		legionAM = EnumHelper.addArmorMaterial("legion", Reference.MODID + ":legion",    32, new int[] {3, 8, 6, 3},  0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2);
		ogreAM = EnumHelper.addArmorMaterial("ogre", Reference.MODID + ":ogre",          38, new int[] {3, 8, 6, 3},  0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1);
		stryderAM = EnumHelper.addArmorMaterial("stryder", Reference.MODID + ":stryder", 20, new int[] {3, 6, 4, 3},  0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);
//												         harv.lvl, uses, efficy., dmg., enchant.
		industrialTM = EnumHelper.addToolMaterial("industrial", 3,  800, 12.0F,   5.0F, 10);

		
		atlasHelmet = new ItemArmorAtlas(atlasAM, 1, EntityEquipmentSlot.HEAD);
		atlasChestplate = new ItemArmorAtlas(atlasAM, 1, EntityEquipmentSlot.CHEST);
		atlasLeggings = new ItemArmorAtlas(atlasAM, 2, EntityEquipmentSlot.LEGS);
		atlasBoots = new ItemArmorAtlas(atlasAM, 1, EntityEquipmentSlot.FEET);
		ionHelmet = new ItemArmorIon(ionAM, 1, EntityEquipmentSlot.HEAD);
		ionChestplate = new ItemArmorIon(ionAM, 1, EntityEquipmentSlot.CHEST);
		ionLeggings = new ItemArmorIon(ionAM, 2, EntityEquipmentSlot.LEGS);
		ionBoots = new ItemArmorIon(ionAM, 1, EntityEquipmentSlot.FEET);
		legionHelmet = new ItemArmorLegion(legionAM, 1, EntityEquipmentSlot.HEAD);
		legionChestplate = new ItemArmorLegion(legionAM, 1, EntityEquipmentSlot.CHEST);
		legionLeggings = new ItemArmorLegion(legionAM, 2, EntityEquipmentSlot.LEGS);
		legionBoots = new ItemArmorLegion(legionAM, 1, EntityEquipmentSlot.FEET);
		ogreHelmet = new ItemArmorOgre(ogreAM, 1, EntityEquipmentSlot.HEAD);
		ogreChestplate = new ItemArmorOgre(ogreAM, 1, EntityEquipmentSlot.CHEST);
		ogreLeggings = new ItemArmorOgre(ogreAM, 2, EntityEquipmentSlot.LEGS);
		ogreBoots = new ItemArmorOgre(ogreAM, 1, EntityEquipmentSlot.FEET);
		stryderHelmet = new ItemArmorStryder(stryderAM, 1, EntityEquipmentSlot.HEAD);
		stryderChestplate = new ItemArmorStryder(stryderAM, 1, EntityEquipmentSlot.CHEST);
		stryderLeggings = new ItemArmorStryder(stryderAM, 2, EntityEquipmentSlot.LEGS);
		stryderBoots = new ItemArmorStryder(stryderAM, 1, EntityEquipmentSlot.FEET);
		
		industrialExcavator = new ItemIndustrialExcavator(industrialTM);
		industrialMiner = new ItemIndustrialMiner(industrialTM);
		industrialMultiTool = new ItemIndustrialMultiTool(industrialTM);
		
		energyCore = new ItemEnergyCore();
		lavaCrystal = new ItemLavaCrystal();
		redstoneCircuit = new ItemRedstoneCircuit();
		reinforcedIronPlate = new ItemReinforcedIronPlate();
		unitAtlas = new ItemUnitAtlas();
		unitIon = new ItemUnitIon();
		unitLegion = new ItemUnitLegion();
		unitOgre = new ItemUnitOgre();
		unitStryder = new ItemUnitStryder();
		machineCase = new ItemMachineCase();

	
		
		
		
		NameUtils.setNames(atlasHelmet, "atlas_helmet");
		NameUtils.setNames(atlasChestplate, "atlas_chestplate");
		NameUtils.setNames(atlasLeggings, "atlas_leggings");
		NameUtils.setNames(atlasBoots, "atlas_boots");
		NameUtils.setNames(ionHelmet, "ion_helmet");
		NameUtils.setNames(ionChestplate, "ion_chestplate");
		NameUtils.setNames(ionLeggings, "ion_leggings");
		NameUtils.setNames(ionBoots, "ion_boots");
		NameUtils.setNames(legionHelmet, "legion_helmet");
		NameUtils.setNames(legionChestplate, "legion_chestplate");
		NameUtils.setNames(legionLeggings, "legion_leggings");
		NameUtils.setNames(legionBoots, "legion_boots");
		NameUtils.setNames(ogreHelmet, "ogre_helmet");
		NameUtils.setNames(ogreChestplate, "ogre_chestplate");
		NameUtils.setNames(ogreLeggings, "ogre_leggings");
		NameUtils.setNames(ogreBoots, "ogre_boots");
		NameUtils.setNames(stryderHelmet, "stryder_helmet");
		NameUtils.setNames(stryderChestplate, "stryder_chestplate");
		NameUtils.setNames(stryderLeggings, "stryder_leggings");
		NameUtils.setNames(stryderBoots, "stryder_boots");
		NameUtils.setNames(energyCore, "energy_core");
		NameUtils.setNames(lavaCrystal, "lava_crystal");
		NameUtils.setNames(redstoneCircuit, "redstone_circuit");
		NameUtils.setNames(reinforcedIronPlate, "reinforced_iron_plate");
		NameUtils.setNames(unitAtlas, "unit_atlas");
		NameUtils.setNames(unitIon, "unit_ion");
		NameUtils.setNames(unitLegion, "unit_legion");
		NameUtils.setNames(unitOgre, "unit_ogre");
		NameUtils.setNames(unitStryder, "unit_stryder");
		NameUtils.setNames(industrialExcavator, "industrial_excavator");
		NameUtils.setNames(industrialMiner, "industrial_miner");
		NameUtils.setNames(industrialMultiTool, "industrial_multi_tool");
		NameUtils.setNames(machineCase, "machine_case");
		
		
	}
	

	
	
	public void register() {
	
		registerItem(unitAtlas);
		registerItem(atlasHelmet);
		registerItem(atlasChestplate);
		registerItem(atlasLeggings);
		registerItem(atlasBoots);
		registerItem(unitIon);
		registerItem(ionHelmet);
		registerItem(ionChestplate);
		registerItem(ionLeggings);
		registerItem(ionBoots);
		registerItem(unitLegion);
		registerItem(legionHelmet);
		registerItem(legionChestplate);
		registerItem(legionLeggings);
		registerItem(legionBoots);
		registerItem(unitOgre);
		registerItem(ogreHelmet);
		registerItem(ogreChestplate);
		registerItem(ogreLeggings);
		registerItem(ogreBoots);
		registerItem(unitStryder);
		registerItem(stryderHelmet);
		registerItem(stryderChestplate);
		registerItem(stryderLeggings);
		registerItem(stryderBoots);
		
		registerItem(industrialExcavator);
		registerItem(industrialMiner);
		registerItem(industrialMultiTool);
		
		registerItem(machineCase);
		registerItem(redstoneCircuit);
		registerItem(reinforcedIronPlate);
		registerItem(lavaCrystal);
		registerItem(energyCore);
		
	}

	
	private static void registerItem(Item item) {
		ForgeRegistries.ITEMS.register(item);
	}
	
}

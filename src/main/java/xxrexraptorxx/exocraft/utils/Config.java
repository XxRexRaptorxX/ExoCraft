package xxrexraptorxx.exocraft.utils;

import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_WORLD = "world";
    public static final String CATEGORY_ARMOR = "armor";
    public static final String CATEGORY_MODULES = "modules";

    public static ModConfigSpec CLIENT_CONFIG;
    public static ModConfigSpec SERVER_CONFIG;

    public static ModConfigSpec.BooleanValue UPDATE_CHECKER;
    public static ModConfigSpec.BooleanValue PATREON_REWARDS;

    public static ModConfigSpec.BooleanValue IS_TABLE_ENCHANTABLE;
    public static ModConfigSpec.BooleanValue IS_BOOK_ENCHANTABLE;
    public static ModConfigSpec.BooleanValue USE_ENERGY;
    public static ModConfigSpec.BooleanValue USE_DURABILITY;
    public static ModConfigSpec.BooleanValue USE_ENERGY_FOR_MODULES;

    public static ModConfigSpec.BooleanValue WANDERING_TRADES;
    public static ModConfigSpec.IntValue UNIT_COST;
    public static ModConfigSpec.IntValue EXOSUIT_MAX_ENERGY_AMOUNT;
    public static ModConfigSpec.IntValue EXOSUIT_MAX_ENERGY_TRANSFER;

    public static ModConfigSpec.BooleanValue ENABLE_SNOW_WALKER_MODULE;
    public static ModConfigSpec.BooleanValue ENABLE_ADVANCED_VISOR_MODULE;
    public static ModConfigSpec.BooleanValue ENABLE_GLIDER_MODULE;
    public static ModConfigSpec.BooleanValue ENABLE_DETERRENCE_MODULE;

    public static void init() {
        initClient();
        initServer();

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
    }


    public static void initClient() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        UPDATE_CHECKER = builder.comment("Activate the Update-Checker").define("update-checker", true);
        builder.pop();

        CLIENT_CONFIG = builder.build();
    }


    public static void initServer() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        PATREON_REWARDS = builder.comment("Enables ingame rewards on first spawn for Patreons").define("patreon_rewards", true);
        builder.pop();

        builder.comment("Armor").push(CATEGORY_ARMOR);
        USE_ENERGY = builder.comment("Should mech suits use energy (FE) to work?").define("use_energy", false);
        EXOSUIT_MAX_ENERGY_AMOUNT = builder.comment("How much energy the mechsuits can store.").defineInRange("max_energy_amount", 50000, 100, Integer.MAX_VALUE);
        EXOSUIT_MAX_ENERGY_TRANSFER = builder.comment("How much energy the mechsuits can transfer at once.").defineInRange("max_energy_transfer", 1500, 10, Integer.MAX_VALUE);
        USE_DURABILITY = builder.comment("Should mech suits use up durability when they receive damage?").define("use_durability", true);
        IS_TABLE_ENCHANTABLE = builder.comment("Should mech suits be enchantable at the enchantment table?").define("is_table_enchantable", false);
        IS_BOOK_ENCHANTABLE = builder.comment("Should mech suits be enchantable with enchantment books?").define("is_book_enchantable", false);
        builder.pop();

        builder.comment("Modules").push(CATEGORY_MODULES);
        USE_ENERGY_FOR_MODULES = builder.comment("Should some modules use energy (FE) to work?").define("use_energy_for_modules", true);
        ENABLE_SNOW_WALKER_MODULE = builder.comment("Enable the snow walker module?").define("enable_snow_walker_module", true);
        ENABLE_ADVANCED_VISOR_MODULE = builder.comment("Enable the advanced visor module?").define("enable_advanced_visor_module", true);
        ENABLE_GLIDER_MODULE = builder.comment("Enable the glider module?").define("enable_glider_module", true);
        ENABLE_DETERRENCE_MODULE = builder.comment("Enable the deterrence module?").define("enable_deterrence_module", true);
        //ENABLE_FIRE_RESISTANT_COATING_MODULE = builder.comment("Enable the fire resistant coating module?").define("enable_fire_resistant_coating", true);
        builder.pop();

        builder.comment("World").push(CATEGORY_WORLD);
        WANDERING_TRADES = builder.comment("Enable trades of units from Wandering Traders").define("wandering_trades", true);
        UNIT_COST = builder.comment("How many emeralds should the units cost for the Wandering Trader?").defineInRange("unit_cost", 30, 1, 64);
        builder.pop();

        SERVER_CONFIG = builder.build();
    }


}
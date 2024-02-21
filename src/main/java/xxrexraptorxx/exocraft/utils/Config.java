package xxrexraptorxx.exocraft.utils;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_WORLD = "world";
    public static final String CATEGORY_ARMOR = "armor";

    public static ForgeConfigSpec CLIENT_CONFIG;
    public static ForgeConfigSpec SERVER_CONFIG;

    public static ForgeConfigSpec.BooleanValue UPDATE_CHECKER;
    public static ForgeConfigSpec.BooleanValue PATREON_REWARDS;

    public static ForgeConfigSpec.BooleanValue IS_TABLE_ENCHANTABLE;
    public static ForgeConfigSpec.BooleanValue IS_BOOK_ENCHANTABLE;
    public static ForgeConfigSpec.BooleanValue USE_ENERGY;
    public static ForgeConfigSpec.BooleanValue USE_DURABILITY;
    public static ForgeConfigSpec.BooleanValue WANDERING_TRADES;
    public static ForgeConfigSpec.IntValue UNIT_COST;


    public static void init() {
        initClient();
        initServer();

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
    }


    public static void initClient() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        UPDATE_CHECKER = builder.comment("Activate the Update-Checker").define("update-checker", true);
        builder.pop();

        CLIENT_CONFIG = builder.build();
    }


    public static void initServer() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        PATREON_REWARDS = builder.comment("Enables ingame rewards on first spawn for Patreons").define("patreon_rewards", true);
        builder.pop();

        builder.comment("Armor").push(CATEGORY_ARMOR);
        USE_ENERGY = builder.comment("Should mech suits use energy (FE) to work?").define("use_energy", false);
        USE_DURABILITY = builder.comment("Should mech suits use up durability when they receive damage?").define("use_durability", true);
        IS_TABLE_ENCHANTABLE = builder.comment("Should mech suits be enchantable at the enchantment table?").define("is_table_enchantable", false);
        IS_BOOK_ENCHANTABLE = builder.comment("Should mech suits be enchantable with enchantment books?").define("is_book_enchantable", false);
        builder.pop();

        builder.comment("World").push(CATEGORY_WORLD);
        WANDERING_TRADES = builder.comment("Enable trades of units from Wandering Traders").define("wandering_trades", true);
        UNIT_COST = builder.comment("How many emeralds should the units cost for the Wandering Trader?").defineInRange("unit_cost", 30, 1, 64);
        builder.pop();

        SERVER_CONFIG = builder.build();
    }

}
package xxrexraptorxx.exocraft.utils;

import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {

    public static final String CATEGORY_GENERAL = "general";

    public static ModConfigSpec CLIENT_CONFIG;
    public static ModConfigSpec SERVER_CONFIG;

    public static ModConfigSpec.BooleanValue UPDATE_CHECKER;
    public static ModConfigSpec.BooleanValue PATREON_REWARDS;

    public static ModConfigSpec.BooleanValue IS_TABLE_ENCHANTABLE;
    public static ModConfigSpec.BooleanValue IS_BOOK_ENCHANTABLE;
    public static ModConfigSpec.BooleanValue WANDERING_TRADES;
    public static ModConfigSpec.IntValue UNIT_COST;


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
        IS_TABLE_ENCHANTABLE = builder.comment("Should mech suits be enchantable at the enchantment table?").define("is_table_enchantable", false);
        IS_BOOK_ENCHANTABLE = builder.comment("Should mech suits be enchantable with enchantment books?").define("is_book_enchantable", false);
        WANDERING_TRADES = builder.comment("Enable trades of units from Wandering Traders").define("wandering_trades", true);
        UNIT_COST = builder.comment("How many emeralds should the units cost for the Wandering Trader?").defineInRange("unit_cost", 30, 1, 64);
        builder.pop();

        SERVER_CONFIG = builder.build();
    }


}
package xxrexraptorxx.exocraft.main;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import xxrexraptorxx.exocraft.registry.CreativeModeTabs;
import xxrexraptorxx.exocraft.registry.ModBlocks;
import xxrexraptorxx.exocraft.registry.ModItems;
import xxrexraptorxx.exocraft.utils.Config;
import xxrexraptorxx.exocraft.world.LootTableInjection;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage https://www.curseforge.com/minecraft/mc-mods/exo-craft
 **/
@Mod(References.MODID)
public class Exocraft {

    public static final Logger LOGGER = LogManager.getLogger();

    public Exocraft() {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        modBus.addListener(this::setup);

        Config.init();
        ModItems.init();
        ModBlocks.init();
        CreativeModeTabs.init();
    }


    private void setup(final @NotNull FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.addListener(LootTableInjection::onChestLootLoad);
    }
}
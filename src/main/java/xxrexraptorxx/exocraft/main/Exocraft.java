package xxrexraptorxx.exocraft.main;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
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

    public Exocraft(IEventBus bus) {
        bus.addListener(this::setup);

        Config.init();
        ModItems.init(bus);
        ModBlocks.init(bus);
        CreativeModeTabs.init(bus);
    }


    private void setup (final @NotNull FMLCommonSetupEvent event) {
        NeoForge.EVENT_BUS.addListener(LootTableInjection::onChestLootLoad);
    }
}
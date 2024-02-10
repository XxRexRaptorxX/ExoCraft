package xxrexraptorxx.exocraft.main;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.exocraft.registry.CreativeModeTabs;
import xxrexraptorxx.exocraft.registry.ModBlocks;
import xxrexraptorxx.exocraft.registry.ModItems;
import xxrexraptorxx.exocraft.utils.Config;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage https://www.curseforge.com/minecraft/mc-mods/exo-craft
 **/
@Mod(References.MODID)
public class Exocraft {

    public static final Logger LOGGER = LogManager.getLogger();

    public Exocraft(IEventBus bus) {
        Config.init();
        ModItems.init(bus);
        ModBlocks.init(bus);
        CreativeModeTabs.init(bus);
    }
}
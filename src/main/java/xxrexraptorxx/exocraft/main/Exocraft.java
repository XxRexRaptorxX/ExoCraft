package xxrexraptorxx.exocraft.main;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
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

    public Exocraft() {
        MinecraftForge.EVENT_BUS.register(this);

        Config.init();
        ModItems.init();
        ModBlocks.init();
        CreativeModeTabs.init();
    }
}
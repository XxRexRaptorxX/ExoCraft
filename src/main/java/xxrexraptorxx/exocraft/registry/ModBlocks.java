package xxrexraptorxx.exocraft.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.exocraft.blocks.LavaCrystalBlock;
import xxrexraptorxx.exocraft.blocks.LavaCrystalOre;
import xxrexraptorxx.exocraft.main.References;

public class ModBlocks {


    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(References.MODID);
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(References.MODID);

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    public static final DeferredBlock<LavaCrystalOre> LAVA_CRYSTAL_ORE = BLOCKS.register("lava_crystal_ore", LavaCrystalOre::new);
    public static final DeferredItem<Item> LAVA_CRYSTAL_ORE_BLOCKITEM = ITEMS.register("lava_crystal_ore", () -> new BlockItem(LAVA_CRYSTAL_ORE.get(), new Item.Properties()));

    public static final DeferredBlock<LavaCrystalBlock> LAVA_CRYSTAL_BLOCK = BLOCKS.register("lava_crystal_block", LavaCrystalBlock::new);
    public static final DeferredItem<Item> LAVA_CRYSTAL_BLOCKITEM = ITEMS.register("lava_crystal_block", () -> new BlockItem(LAVA_CRYSTAL_BLOCK.get(), new Item.Properties()));

}

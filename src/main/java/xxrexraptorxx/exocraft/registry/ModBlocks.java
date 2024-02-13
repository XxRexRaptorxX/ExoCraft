package xxrexraptorxx.exocraft.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.exocraft.blocks.LavaCrystalBlock;
import xxrexraptorxx.exocraft.blocks.LavaCrystalOre;
import xxrexraptorxx.exocraft.main.References;

public class ModBlocks {


    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, References.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, References.MODID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    public static final RegistryObject<LavaCrystalOre> LAVA_CRYSTAL_ORE = BLOCKS.register("lava_crystal_ore", LavaCrystalOre::new);
    public static final RegistryObject<Item> LAVA_CRYSTAL_ORE_BLOCKITEM = ITEMS.register("lava_crystal_ore", () -> new BlockItem(LAVA_CRYSTAL_ORE.get(), new Item.Properties().tab(CreativeModeTabs.MOD_TAB)));

    public static final RegistryObject<LavaCrystalBlock> LAVA_CRYSTAL_BLOCK = BLOCKS.register("lava_crystal_block", LavaCrystalBlock::new);
    public static final RegistryObject<Item> LAVA_CRYSTAL_BLOCKITEM = ITEMS.register("lava_crystal_block", () -> new BlockItem(LAVA_CRYSTAL_BLOCK.get(), new Item.Properties().tab(CreativeModeTabs.MOD_TAB)));

}

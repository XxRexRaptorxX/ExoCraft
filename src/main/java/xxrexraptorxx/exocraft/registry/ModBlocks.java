package xxrexraptorxx.exocraft.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.exocraft.blocks.BlockQuicksand;
import xxrexraptorxx.exocraft.main.References;

public class ModBlocks {


    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, References.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, References.MODID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    public static final RegistryObject<BlockQuicksand> QUICK_SAND = BLOCKS.register("quicksand", BlockQuicksand::new);
    public static final RegistryObject<Item> QUICK_SAND_BLOCKITEM = ITEMS.register("quicksand", () -> new BlockItem(QUICK_SAND.get(), new Item.Properties()));

    //public static final RegistryObject<Block> POISONED_IVY = BLOCKS.register("poisoned_ivy", () -> new FlowerBlock(MobEffects.POISON, 10, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    //public static final RegistryObject<Item> POISONED_IVY_BLOCKITEM = ITEMS.register("poisoned_ivy", () -> new BlockItem(POISONED_IVY.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

}

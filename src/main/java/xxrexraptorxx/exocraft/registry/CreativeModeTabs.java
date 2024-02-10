package xxrexraptorxx.exocraft.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.exocraft.main.References;

public class CreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, References.MODID);

    public static void init(IEventBus bus) { CREATIVE_MODE_TABS.register(bus); }


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register(References.MODID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + References.MODID + "_tab"))
            .icon(() -> ModItems.LEGION_HELMET.get().getDefaultInstance())
            .withTabsBefore(net.minecraft.world.item.CreativeModeTabs.SPAWN_EGGS)
            .displayItems((params, output) -> {

                output.accept(ModItems.REINFORCED_IRON_HELMET.get());
                output.accept(ModItems.REINFORCED_IRON_CHESTPLATE.get());
                output.accept(ModItems.REINFORCED_IRON_LEGGINGS.get());
                output.accept(ModItems.REINFORCED_IRON_BOOTS.get());

                output.accept(ModItems.ATLAS_HELMET.get());
                output.accept(ModItems.ATLAS_CHESTPLATE.get());
                output.accept(ModItems.ATLAS_LEGGINGS.get());
                output.accept(ModItems.ATLAS_BOOTS.get());

                output.accept(ModItems.LEGION_HELMET.get());
                output.accept(ModItems.LEGION_CHESTPLATE.get());
                output.accept(ModItems.LEGION_LEGGINGS.get());
                output.accept(ModItems.LEGION_BOOTS.get());

                output.accept(ModItems.STRYDER_HELMET.get());
                output.accept(ModItems.STRYDER_CHESTPLATE.get());
                output.accept(ModItems.STRYDER_LEGGINGS.get());
                output.accept(ModItems.STRYDER_BOOTS.get());

                output.accept(ModItems.OGRE_HELMET.get());
                output.accept(ModItems.OGRE_CHESTPLATE.get());
                output.accept(ModItems.OGRE_LEGGINGS.get());
                output.accept(ModItems.OGRE_BOOTS.get());

                output.accept(ModItems.ION_HELMET.get());
                output.accept(ModItems.ION_CHESTPLATE.get());
                output.accept(ModItems.ION_LEGGINGS.get());
                output.accept(ModItems.ION_BOOTS.get());

                output.accept(ModItems.ENERGY_CORE.get());
                output.accept(ModItems.LAVA_CRYSTAL.get());
                output.accept(ModItems.REDSTONE_CIRCUIT.get());
                output.accept(ModItems.REINFORCED_IRON_PLATE.get());

                output.accept(ModItems.ATLAS_MATRIX.get());
                output.accept(ModItems.OGRE_MATRIX.get());
                output.accept(ModItems.LEGION_MATRIX.get());
                output.accept(ModItems.STRYDER_MATRIX.get());
                output.accept(ModItems.ION_MATRIX.get());

                output.accept(ModItems.EMPTY_UNIT.get());
                output.accept(ModItems.ATLAS_UNIT.get());
                output.accept(ModItems.OGRE_UNIT.get());
                output.accept(ModItems.LEGION_UNIT.get());
                output.accept(ModItems.STRYDER_UNIT.get());
                output.accept(ModItems.ION_UNIT.get());
                output.accept(ModItems.OLD_UNIT.get());

                output.accept(ModBlocks.LAVA_CRYSTAL_ORE.get());
                output.accept(ModBlocks.LAVA_CRYSTAL_BLOCK.get());

            }).build());
}

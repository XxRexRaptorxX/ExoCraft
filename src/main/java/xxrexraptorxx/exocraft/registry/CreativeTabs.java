package xxrexraptorxx.exocraft.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.exocraft.main.References;

import java.util.ArrayList;

public class CreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, References.MODID);

    public static void init() {
        CREATIVE_MODE_TABS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


    public static final RegistryObject<CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register(References.MODID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + References.MODID + "_tab"))
            .icon(() -> ModItems.LEGION_HELMET.get().getPoweredInstance())
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .displayItems((params, output) -> {

                output.accept(ModItems.REINFORCED_IRON_HELMET.get());
                output.accept(ModItems.REINFORCED_IRON_CHESTPLATE.get());
                output.accept(ModItems.REINFORCED_IRON_LEGGINGS.get());
                output.accept(ModItems.REINFORCED_IRON_BOOTS.get());

                output.acceptAll(ModItems.ATLAS_HELMET.get().getItemVariantList());
                output.acceptAll(ModItems.ATLAS_CHESTPLATE.get().getItemVariantList());
                output.acceptAll(ModItems.ATLAS_LEGGINGS.get().getItemVariantList());
                output.acceptAll(ModItems.ATLAS_BOOTS.get().getItemVariantList());

                output.acceptAll(ModItems.LEGION_HELMET.get().getItemVariantList());
                output.acceptAll(ModItems.LEGION_CHESTPLATE.get().getItemVariantList());
                output.acceptAll(ModItems.LEGION_LEGGINGS.get().getItemVariantList());
                output.acceptAll(ModItems.LEGION_BOOTS.get().getItemVariantList());

                output.acceptAll(ModItems.STRYDER_HELMET.get().getItemVariantList());
                output.acceptAll(ModItems.STRYDER_CHESTPLATE.get().getItemVariantList());
                output.acceptAll(ModItems.STRYDER_LEGGINGS.get().getItemVariantList());
                output.acceptAll(ModItems.STRYDER_BOOTS.get().getItemVariantList());

                output.acceptAll(ModItems.OGRE_HELMET.get().getItemVariantList());
                output.acceptAll(ModItems.OGRE_CHESTPLATE.get().getItemVariantList());
                output.acceptAll(ModItems.OGRE_LEGGINGS.get().getItemVariantList());
                output.acceptAll(ModItems.OGRE_BOOTS.get().getItemVariantList());

                output.acceptAll(ModItems.ION_HELMET.get().getItemVariantList());
                output.acceptAll(ModItems.ION_CHESTPLATE.get().getItemVariantList());
                output.acceptAll(ModItems.ION_LEGGINGS.get().getItemVariantList());
                output.acceptAll(ModItems.ION_BOOTS.get().getItemVariantList());

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
package xxrexraptorxx.exocraft.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.exocraft.main.References;
import xxrexraptorxx.extragems.main.References;

public class CreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, References.MODID);

    public static void init() { CREATIVE_MODE_TABS.register(FMLJavaModLoadingContext.get().getModEventBus()); }


    public static final RegistryObject<CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register(References.MODID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + References.MODID + "_tab"))
            .icon(() -> ModItems.CHARGED_AMETHYST.get().getDefaultInstance())
            .withTabsBefore(net.minecraft.world.item.CreativeModeTabs.SPAWN_EGGS)
            .displayItems((params, output) -> {

                output.accept(ModItems.EMERALD_HELMET.get());
                output.accept(ModItems.EMERALD_CHESTPLATE.get());
                output.accept(ModItems.EMERALD_LEGGINGS.get());
                output.accept(ModItems.EMERALD_BOOTS.get());
            }).build());
}

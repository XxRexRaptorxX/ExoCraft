package xxrexraptorxx.exocraft.world;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.exocraft.main.References;

import java.util.List;

public class ModPlacedFeatures {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, References.MODID);


    public static final RegistryObject<PlacedFeature> LAVA_CRYSTAL = PLACED_FEATURES.register("lava_crystal_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.LAVA_CRYSTAL.getHolder().get(),
                    commonOrePlacement(10, // Rarity
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(34)))));


    public static List<PlacementModifier> orePlacement(PlacementModifier type, PlacementModifier codec) {
        return List.of(type, InSquarePlacement.spread(), codec, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier placement) {
        return orePlacement(CountPlacement.of(count), placement);
    }

    public static List<PlacementModifier> rareOrePlacement(int count, PlacementModifier placement) {
        return orePlacement(RarityFilter.onAverageOnceEvery(count), placement);
    }


    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
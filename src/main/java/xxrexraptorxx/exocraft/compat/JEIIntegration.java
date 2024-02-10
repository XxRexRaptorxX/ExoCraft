package xxrexraptorxx.exocraft.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import xxrexraptorxx.exocraft.main.References;
import xxrexraptorxx.exocraft.registry.ModItems;

import java.util.ArrayList;

@JeiPlugin
public class JEIIntegration implements IModPlugin {

    private static final ResourceLocation ID = new ResourceLocation(References.MODID, "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registry) {
        IIngredientManager ingredientManager = registry.getIngredientManager();

        ArrayList<ItemStack> units = new ArrayList<ItemStack>();
        units.add(new ItemStack(ModItems.ATLAS_UNIT.get()));
        units.add(new ItemStack(ModItems.STRYDER_UNIT.get()));
        units.add(new ItemStack(ModItems.ION_UNIT.get()));
        units.add(new ItemStack(ModItems.LEGION_UNIT.get()));
        units.add(new ItemStack(ModItems.OGRE_UNIT.get()));

        registry.addIngredientInfo(units, VanillaTypes.ITEM_STACK, Component.translatable("message.exocraft.units_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.OLD_UNIT.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.exocraft.old_unit_jei_desc"));

    }
}
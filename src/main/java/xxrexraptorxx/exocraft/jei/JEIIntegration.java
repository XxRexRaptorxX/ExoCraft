package xxrexraptorxx.exocraft.jei;

import javax.annotation.Nonnull;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.item.ItemStack;
import xxrexraptorxx.exocraft.containers.ContainerFabricator;
import xxrexraptorxx.exocraft.crafting.CraftingManagerFabricator;
import xxrexraptorxx.exocraft.gui.GuiFabricator;
import xxrexraptorxx.exocraft.main.ModBlocks;

@mezz.jei.api.JEIPlugin
public class JEIIntegration implements IModPlugin{

	public static IJeiHelpers jeiHelper;


    @Override
    public void register(@Nonnull IModRegistry registry) {

        jeiHelper = registry.getJeiHelpers();
        
   
        registry.addRecipeCategories(new ToACraftingCategory(jeiHelper.getGuiHelper()));
        registry.addRecipeHandlers(new ToACraftingHandler());
        
        registry.addRecipes(CraftingManagerFabricator.getInstance().getRecipeList());
        registry.addRecipeClickArea(GuiFabricator.class, 101, 24, 27, 27, "exocraft.fabricator");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.fabricator), "exocraft.fabricator");

        IRecipeTransferRegistry recipeTransferRegistry = registry.getRecipeTransferRegistry();
        recipeTransferRegistry.addRecipeTransferHandler(ContainerFabricator.class, "exocraft.fabricator", 0, 12, 7, 36);      
    }
    
}

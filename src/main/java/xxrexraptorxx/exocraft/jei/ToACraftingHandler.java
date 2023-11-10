package xxrexraptorxx.exocraft.jei;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import xxrexraptorxx.exocraft.crafting.RecipesFabricator;


public class ToACraftingHandler implements IRecipeHandler<RecipesFabricator> {


    @Nonnull
    @Override
    public Class<RecipesFabricator> getRecipeClass() {
        return RecipesFabricator.class;
    }

    @Nonnull
    @Override
    public String getRecipeCategoryUid(RecipesFabricator recipe) {
        return "exocraft.fabricator";
    }


    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(RecipesFabricator recipe) {
        return new ToACraftingWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(RecipesFabricator recipe) {
        return true;
    }
}

package xxrexraptorxx.exocraft.jei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Nullable;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import xxrexraptorxx.exocraft.main.Reference;

public class ToACraftingCategory implements IRecipeCategory {

    private final String locTitle;
    private final IDrawable background;

    public ToACraftingCategory(IGuiHelper guiHelper) {

        locTitle = "Fabricator";

        background = guiHelper.createDrawable(new ResourceLocation(Reference.MODID, "textures/gui/fabricator.png"), 5, 6, 176, 166);

    }

    @Override
    public String getUid() {
        return "exocraft.fabricator";
    }

    @Override
    public String getTitle() {
        return locTitle;
    }

    @Override
    public String getModName() {
        return Reference.NAME;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Nullable
    @Override
    public IDrawable getIcon() {
        return null;
    }

    @Override
    public void drawExtras(Minecraft minecraft) {

    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients) {

        recipeLayout.setRecipeTransferButton(105, 50);
        IGuiItemStackGroup guiStacks = recipeLayout.getItemStacks();

        int slotId = 0;

        List<Integer> xcoords = new ArrayList<Integer>();
        List<Integer> ycoords = new ArrayList<Integer>();
        xcoords.add(11);        ycoords.add(10);
        xcoords.add(37);        ycoords.add(10);
        xcoords.add(55);        ycoords.add(10);
        xcoords.add(73);        ycoords.add(10);
        xcoords.add(11);        ycoords.add(28);
        xcoords.add(37);        ycoords.add(28);
        xcoords.add(55);        ycoords.add(28);
        xcoords.add(73);         ycoords.add(28);
        xcoords.add(11);        ycoords.add(46);
        xcoords.add(37);        ycoords.add(46);
        xcoords.add(55);        ycoords.add(46);
        xcoords.add(73);        ycoords.add(46);
        
        
        // Input Slots
        List<List<ItemStack>> inputs = ingredients.getInputs(ItemStack.class);
        for (List<ItemStack> itemList : inputs) {

            int x = xcoords.get(slotId);
            int y = ycoords.get(slotId);
            guiStacks.init(slotId, true, x, y);
	        guiStacks.set(slotId, itemList);
            slotId++;
        }

   
        // Output Slot
        guiStacks.init(slotId, false, 131, 28);
        guiStacks.set(slotId, ingredients.getOutputs(ItemStack.class).get(0));

    }

    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {

        return new List<String>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(String s) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public String get(int index) {
                return null;
            }

            @Override
            public String set(int index, String element) {
                return null;
            }

            @Override
            public void add(int index, String element) {

            }

            @Override
            public String remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<String> listIterator() {
                return null;
            }

            @Override
            public ListIterator<String> listIterator(int index) {
                return null;
            }

            @Override
            public List<String> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

    }
}

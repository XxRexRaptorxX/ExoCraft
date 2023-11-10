package xxrexraptorxx.exocraft.crafting;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import xxrexraptorxx.exocraft.configs.ConfigGeneral;
import xxrexraptorxx.exocraft.main.ExoCraft;
import xxrexraptorxx.exocraft.main.ModItems;


public class CraftingManagerFabricator {

    private static final CraftingManagerFabricator INSTANCE = new CraftingManagerFabricator();

    private final List<IRecipe> recipes = Lists.newArrayList();

    public static CraftingManagerFabricator getInstance() {
        return INSTANCE;
    }


    private CraftingManagerFabricator() {
    	
    	/** RECIPES **/	   
    	this.addFabricatorRecipe(new ItemStack(ModItems.atlasHelmet),	  "A###", "B# #", "C   ", 'A', ModItems.unitAtlas, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);
    	this.addFabricatorRecipe(new ItemStack(ModItems.atlasChestplate), "A# #", "B###", "C###", 'A', ModItems.unitAtlas, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);
    	this.addFabricatorRecipe(new ItemStack(ModItems.atlasLeggings),   "A###", "B# #", "C# #", 'A', ModItems.unitAtlas, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);
    	this.addFabricatorRecipe(new ItemStack(ModItems.atlasBoots), 	  "A   ", "B# #", "C# #", 'A', ModItems.unitAtlas, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);

       	this.addFabricatorRecipe(new ItemStack(ModItems.ogreHelmet),	  "A###", "B# #", "C   ", 'A', ModItems.unitOgre, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);
    	this.addFabricatorRecipe(new ItemStack(ModItems.ogreChestplate),  "A# #", "B###", "C###", 'A', ModItems.unitOgre, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);
    	this.addFabricatorRecipe(new ItemStack(ModItems.ogreLeggings),    "A###", "B# #", "C# #", 'A', ModItems.unitOgre, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);
    	this.addFabricatorRecipe(new ItemStack(ModItems.ogreBoots), 	  "A   ", "B# #", "C# #", 'A', ModItems.unitOgre, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);

       	this.addFabricatorRecipe(new ItemStack(ModItems.legionHelmet),	   "A###", "B# #", "C   ", 'A', ModItems.unitLegion, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);
    	this.addFabricatorRecipe(new ItemStack(ModItems.legionChestplate), "A# #", "B###", "C###", 'A', ModItems.unitLegion, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);
    	this.addFabricatorRecipe(new ItemStack(ModItems.legionLeggings),   "A###", "B# #", "C# #", 'A', ModItems.unitLegion, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);
    	this.addFabricatorRecipe(new ItemStack(ModItems.legionBoots), 	   "A   ", "B# #", "C# #", 'A', ModItems.unitLegion, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);

       	this.addFabricatorRecipe(new ItemStack(ModItems.ionHelmet),	    "A###", "B# #", "C   ", 'A', ModItems.unitIon, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);
    	this.addFabricatorRecipe(new ItemStack(ModItems.ionChestplate), "A# #", "B###", "C###", 'A', ModItems.unitIon, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);
    	this.addFabricatorRecipe(new ItemStack(ModItems.ionLeggings),   "A###", "B# #", "C# #", 'A', ModItems.unitIon, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);
    	this.addFabricatorRecipe(new ItemStack(ModItems.ionBoots), 	    "A   ", "B# #", "C# #", 'A', ModItems.unitIon, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);

       	this.addFabricatorRecipe(new ItemStack(ModItems.stryderHelmet),	    "A###", "B# #", "C   ", 'A', ModItems.unitStryder, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);
    	this.addFabricatorRecipe(new ItemStack(ModItems.stryderChestplate), "A# #", "B###", "C###", 'A', ModItems.unitStryder, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);
    	this.addFabricatorRecipe(new ItemStack(ModItems.stryderLeggings),   "A###", "B# #", "C# #", 'A', ModItems.unitStryder, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);
    	this.addFabricatorRecipe(new ItemStack(ModItems.stryderBoots), 	    "A   ", "B# #", "C# #", 'A', ModItems.unitStryder, 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate);

    	this.addFabricatorRecipe(new ItemStack(ModItems.redstoneCircuit), "A#I#", "BXOX", "C#I#", '#', Items.REDSTONE, 'X', Items.REPEATER, 'I', Items.COMPARATOR, 'O', Blocks.REDSTONE_TORCH);
    	this.addFabricatorRecipe(new ItemStack(ModItems.reinforcedIronPlate), "A#X#", "BXXX", "C#X#", '#', Items.DIAMOND, 'X', Items.IRON_INGOT);
    	this.addFabricatorRecipe(new ItemStack(ModItems.energyCore), "A#X#", "BXOX", "C#X#", '#', Items.GOLD_INGOT, 'X', Items.REDSTONE, 'O', ModItems.lavaCrystal);

        if(ConfigGeneral.activateIndustrialTools) {
        	this.addFabricatorRecipe(new ItemStack(ModItems.machineCase), "A###", "B#X#", "C###", 'B', ModItems.energyCore, 'C', ModItems.redstoneCircuit, '#', ModItems.reinforcedIronPlate, 'X', Blocks.REDSTONE_BLOCK);
        	this.addFabricatorRecipe(new ItemStack(ModItems.industrialMiner), "A X ", "B # ", "C   ", '#', ModItems.machineCase, 'X', Items.IRON_PICKAXE);
        	this.addFabricatorRecipe(new ItemStack(ModItems.industrialExcavator), "A X ", "B # ", "C   ", '#', ModItems.machineCase, 'X', Items.IRON_SHOVEL);
        	this.addFabricatorRecipe(new ItemStack(ModItems.industrialMultiTool), "AXYZ", "B # ", "C   ", '#', ModItems.machineCase, 'X', Items.IRON_AXE, 'Y', Items.IRON_SHOVEL, 'Z', Items.IRON_PICKAXE);

        }
    }
    

    public  RecipesFabricator addFabricatorRecipe(ItemStack stack, Object... recipeComponents) {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (recipeComponents[i] instanceof String[]) {
            String[] astring = (String[])((String[])recipeComponents[i++]);

            for (String s2 : astring) {
                ++k;
                j = s2.length();
                s = s + s2;
            }
        } else {
            while (recipeComponents[i] instanceof String) {
                String s1 = (String)recipeComponents[i++];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }

        Map<Character, ItemStack> map;

        for (map = Maps.<Character, ItemStack>newHashMap(); i < recipeComponents.length; i += 2) {
            Character character = (Character)recipeComponents[i];
            ItemStack itemstack = ItemStack.EMPTY;

            if (recipeComponents[i + 1] instanceof Item) {
                itemstack = new ItemStack((Item)recipeComponents[i + 1]);
            
            } else if (recipeComponents[i + 1] instanceof Block) {
                itemstack = new ItemStack((Block)recipeComponents[i + 1], 1, 32767);
            
            } else if (recipeComponents[i + 1] instanceof ItemStack) {
                itemstack = (ItemStack)recipeComponents[i + 1];
            }

            map.put(character, itemstack);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int l = 0; l < j * k; ++l) {
            char c0 = s.charAt(l);

            if (map.containsKey(Character.valueOf(c0))) {
                aitemstack[l] = ((ItemStack)map.get(Character.valueOf(c0))).copy();
            
            } else {
                aitemstack[l] = ItemStack.EMPTY;
            }
        }


        RecipesFabricator shapedrecipes = new RecipesFabricator(j, k, aitemstack, stack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }
    
    
    public ItemStack findMatchingRecipe(InventoryCrafting craftMatrix, World worldIn) {
		for(IRecipe irecipe : this.recipes) {
				RecipesFabricator recipe = (RecipesFabricator) irecipe;
				
				if(irecipe.matches(craftMatrix, worldIn)) {
					return recipe.getCraftingResult(craftMatrix);
				}
		}
		
    	return ItemStack.EMPTY;
    }
    

    public List<IRecipe> getRecipeList() {
        return this.recipes;
    }

}

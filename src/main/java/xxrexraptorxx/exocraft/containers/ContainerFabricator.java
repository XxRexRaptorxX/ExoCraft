package xxrexraptorxx.exocraft.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import xxrexraptorxx.exocraft.crafting.CraftingManagerFabricator;
import xxrexraptorxx.exocraft.tileentitys.TileEntityFabricator;

public class ContainerFabricator extends Container {

    private TileEntityFabricator tileEntityFabricator;

    private InventoryCrafting craftMatrix = new InventoryCrafting(this, 4, 3);
    private IInventory craftResult = new InventoryCraftResult();

    private final int HOTBAR_SLOT_COUNT = 9;
    private final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private final int PLAYER_INVENTORY_COLUMN_COUNT = 9;



    public ContainerFabricator(InventoryPlayer invPlayer, TileEntityFabricator tileEntityFabricator) {

        this.tileEntityFabricator = tileEntityFabricator;

        final int SLOT_X_SPACING = 18;
        final int SLOT_Y_SPACING = 18;
        final int HOTBAR_XPOS = 8;
        final int HOTBAR_YPOS = 142;
        for (int x = 0; x < HOTBAR_SLOT_COUNT; x++) {
            addSlotToContainer(new Slot(invPlayer, x, HOTBAR_XPOS + SLOT_X_SPACING * x, HOTBAR_YPOS));
        }

        final int PLAYER_INVENTORY_XPOS = 8;
        final int PLAYER_INVENTORY_YPOS = 84;
        for (int y = 0; y < PLAYER_INVENTORY_ROW_COUNT; y++) {
            for (int x = 0; x < PLAYER_INVENTORY_COLUMN_COUNT; x++) {
                int slotNumber = HOTBAR_SLOT_COUNT + y * PLAYER_INVENTORY_COLUMN_COUNT + x;
                int xpos = PLAYER_INVENTORY_XPOS + x * SLOT_X_SPACING;
                int ypos = PLAYER_INVENTORY_YPOS + y * SLOT_Y_SPACING;
                addSlotToContainer(new Slot(invPlayer, slotNumber,  xpos, ypos));
            }
        }

        //CRAFTING
        addSlotToContainer(new SlotCrafting(invPlayer.player, this.craftMatrix, this.craftResult, 0, 137, 35));
        addSlotToContainer(new Slot(this.craftMatrix, 0, 17, 17));
        addSlotToContainer(new Slot(this.craftMatrix, 4, 17, 35));
        addSlotToContainer(new Slot(this.craftMatrix, 8, 17, 53));
        
        addSlotToContainer(new Slot(this.craftMatrix, 1, 43, 17));
        addSlotToContainer(new Slot(this.craftMatrix, 2, 61, 17));
        addSlotToContainer(new Slot(this.craftMatrix, 3, 79, 17));
        addSlotToContainer(new Slot(this.craftMatrix, 5, 43, 35));
        addSlotToContainer(new Slot(this.craftMatrix, 6, 61, 35));
        addSlotToContainer(new Slot(this.craftMatrix, 7, 79, 35));
        addSlotToContainer(new Slot(this.craftMatrix, 9, 43, 53));
        addSlotToContainer(new Slot(this.craftMatrix, 10,61, 53));
        addSlotToContainer(new Slot(this.craftMatrix, 11,79, 53));


        this.onCraftMatrixChanged(this.craftMatrix);
        
    }

    
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntityFabricator.isUsableByPlayer(player);
    }
    

    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
    	ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = inventorySlots.get(index);
	
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
	
			int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();
	
			if (index < containerSlots) {
				if (!this.mergeItemStack(itemstack1, containerSlots, inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, containerSlots, false)) {
				return ItemStack.EMPTY;
			}
	
			if (itemstack1.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
	
			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}
	
			slot.onTake(player, itemstack1);
		}
	
		return itemstack;
    }


    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
            super.onContainerClosed(playerIn);

            if (!playerIn.world.isRemote){
                this.clearContainer(playerIn, playerIn.world, this.craftMatrix);
            }
    }
    
    
    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn) {
    	this.craftResult.setInventorySlotContents(0, CraftingManagerFabricator.getInstance().findMatchingRecipe(this.craftMatrix, tileEntityFabricator.getWorld()));
    }

}

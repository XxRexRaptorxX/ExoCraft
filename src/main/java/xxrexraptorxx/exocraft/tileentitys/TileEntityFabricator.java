package xxrexraptorxx.exocraft.tileentitys;

import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import xxrexraptorxx.exocraft.main.ModBlocks;

public class TileEntityFabricator extends TileEntity implements IInventory {

	   private final int NUMBER_OF_SLOTS = 12;
	    private ItemStack[] itemStacks;

	    
	    public TileEntityFabricator(){
	        itemStacks = new ItemStack[NUMBER_OF_SLOTS];
	        clear();
	    }

	    
	    @Override
	    public ItemStack decrStackSize(int slotIndex, int count) {
	        ItemStack itemStackInSlot = getStackInSlot(slotIndex);
	        if (itemStackInSlot.isEmpty()) return ItemStack.EMPTY;

	        ItemStack itemStackRemoved;
	        if (itemStackInSlot.getCount() <= count) {
	            itemStackRemoved = itemStackInSlot;
	            setInventorySlotContents(slotIndex, ItemStack.EMPTY);
	        } else {
	            itemStackRemoved = itemStackInSlot.splitStack(count);
	            if (itemStackInSlot.getCount() == 0) {
	                setInventorySlotContents(slotIndex, ItemStack.EMPTY);
	            }
	        }
	        markDirty();
	        return itemStackRemoved;
	    }

	    
	    @Override
	    public NBTTagCompound writeToNBT(NBTTagCompound parentNBTTagCompound) {
	        super.writeToNBT(parentNBTTagCompound);

	        NBTTagList dataForAllSlots = new NBTTagList();
	        for (int i = 0; i < this.itemStacks.length; ++i) {
	            if (!this.itemStacks[i].isEmpty())	{
	                NBTTagCompound dataForThisSlot = new NBTTagCompound();
	                dataForThisSlot.setByte("Slot", (byte) i);
	                this.itemStacks[i].writeToNBT(dataForThisSlot);
	                dataForAllSlots.appendTag(dataForThisSlot);
	            }
	        }
	        parentNBTTagCompound.setTag("Items", dataForAllSlots);
	        return parentNBTTagCompound;
	    }

	    
	    @Override
	    public void readFromNBT(NBTTagCompound parentNBTTagCompound) {
	        super.readFromNBT(parentNBTTagCompound);
	        final byte NBT_TYPE_COMPOUND = 10;
	        NBTTagList dataForAllSlots = parentNBTTagCompound.getTagList("Items", NBT_TYPE_COMPOUND);

	        Arrays.fill(itemStacks, ItemStack.EMPTY);
	        for (int i = 0; i < dataForAllSlots.tagCount(); ++i) {
	            NBTTagCompound dataForOneSlot = dataForAllSlots.getCompoundTagAt(i);
	            int slotIndex = dataForOneSlot.getByte("Slot") & 255;

	            if (slotIndex >= 0 && slotIndex < this.itemStacks.length) {
	                this.itemStacks[slotIndex] = new ItemStack(dataForOneSlot);
	            }
	        }
	    }

	    
	    @Override
	    public ItemStack getStackInSlot(int slotIndex) {
	        return itemStacks[slotIndex];
	    }

	    
	    @Override
	    public void setInventorySlotContents(int slotIndex, ItemStack itemstack) {
	        itemStacks[slotIndex] = itemstack;
	        if (itemstack.isEmpty() && itemstack.getCount() > getInventoryStackLimit()) { //  isEmpty(); getStackSize()
	            itemstack.setCount(getInventoryStackLimit());  //setStackSize
	        }
	        markDirty();
	    }
	    

	    @Override
	    public boolean isItemValidForSlot(int slotIndex, ItemStack itemstack) {
	        return true;
	    }
	    

	    @Override
	    public String getName() {
	        return ModBlocks.fabricator.getLocalizedName();
	    }
	    

	    @Override
	    public void clear() {
	        Arrays.fill(itemStacks, ItemStack.EMPTY);
	    }
	    

	    @Override
	    public int getSizeInventory() {
	        return itemStacks.length;
	    }

	    
	    @Override
	    public boolean isUsableByPlayer(EntityPlayer player) {
	        if (this.world.getTileEntity(this.pos) != this) return false;
	        final double X_CENTRE_OFFSET = 0.5;
	        final double Y_CENTRE_OFFSET = 0.5;
	        final double Z_CENTRE_OFFSET = 0.5;
	        final double MAXIMUM_DISTANCE_SQ = 8.0 * 8.0;
	        return player.getDistanceSq(pos.getX() + X_CENTRE_OFFSET, pos.getY() + Y_CENTRE_OFFSET, pos.getZ() + Z_CENTRE_OFFSET) < MAXIMUM_DISTANCE_SQ;
	    }

	    
	    @Override
	    public int getInventoryStackLimit() {
	        return 64;
	    }
	    

	    @Override
	    public boolean hasCustomName() {
	        return false;
	    }
	    

	    @Override
	    public boolean isEmpty() {
	        for (ItemStack itemstack : itemStacks) {
	            if (!itemstack.isEmpty()) {
	                return false;
	            }
	        }
	        return true;
	    }

	    
	    @Override
	    public ItemStack removeStackFromSlot(int slotIndex) {
	        ItemStack itemStack = getStackInSlot(slotIndex);
	        if (!itemStack.isEmpty()) setInventorySlotContents(slotIndex, ItemStack.EMPTY);
	        return itemStack;
	    }
	    

	    @Override
	    public void openInventory(EntityPlayer player) {}

	    
	    @Override
	    public void closeInventory(EntityPlayer player) {}

	    
	    @Override
	    public int getField(int id) {
	        return 0;
	    }
	    

	    @Override
	    public void setField(int id, int value) {}

	    
	    @Override
	    public int getFieldCount() {
	        return 0;
	    }
}

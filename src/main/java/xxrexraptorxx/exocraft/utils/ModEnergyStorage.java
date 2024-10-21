package xxrexraptorxx.exocraft.utils;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.energy.EnergyStorage;

import java.text.DecimalFormat;

public class ModEnergyStorage extends EnergyStorage {

    private final ItemStack itemStack;

    public ModEnergyStorage(ItemStack stack, int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
        this.itemStack = stack;
    }


    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        if(!canReceive()) return 0;
        int energyStored = getEnergyStored();

        int energyReceived = Math.min(capacity - energyStored, Math.min(this.maxReceive, maxReceive));
        if(!simulate) writeEnergy(energyStored + energyReceived);
        return energyReceived;
    }


    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        if(!canExtract()) return 0;

        int energyExtracted = Math.min(getEnergyStored(), Math.min(this.maxExtract,maxExtract));
        if(!simulate) writeEnergy(getEnergyStored() - energyExtracted);
        return energyExtracted;
    }


    @Override
    public int getEnergyStored() {
        return this.itemStack.getOrCreateTag().getInt("energy");
    }


    private void writeEnergy(int amount) {
        this.itemStack.getOrCreateTag().putInt("energy", amount);
    }


    public static String formatEnergyValue(double num) {
        if (num < 1_000) {
            String toReturn = String.valueOf(num);
            toReturn += " FE";
            return toReturn;
        } else if (num >= 1_000 && num < 1_000_000d) {
            return removeZeros(num / 1_000) + " kFE";
        } else if (num < 1_000_000_000d) {
            return removeZeros(num / 1_000_000d) + " MFE";
        } else if (num < 1_000_000_000_000d) {
            return removeZeros(num / 1_000_000_000d) + " GFE";
        } else {
            return removeZeros(num / 1_000_000_000_000d) + " TFE";
        }
    }


    private static String removeZeros(double d) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(d);
    }

}
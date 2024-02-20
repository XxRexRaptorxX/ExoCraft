package xxrexraptorxx.exocraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import xxrexraptorxx.exocraft.registry.ModItems;
import xxrexraptorxx.exocraft.utils.Config;
import xxrexraptorxx.exocraft.utils.ModEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class EnergyItem extends Item {

    private static int maxEnergy = 50000;
    private static int maxTransfer = 1500;

    public EnergyItem(int maxEnergy, int maxTransfer) {
        super(new Properties()
                .stacksTo(16));
        this.maxEnergy = maxEnergy;
        this.maxTransfer = maxTransfer;
    }


    public static float getChargeRatio(ItemStack stack) {
        LazyOptional<IEnergyStorage> energy = stack.getCapability(ForgeCapabilities.ENERGY);

        if(energy.isPresent()) {
            IEnergyStorage energyStorage = energy.orElseThrow(IllegalStateException::new);
            return (float) energyStorage.getEnergyStored() / energyStorage.getMaxEnergyStored();
        }
        return 0;
    }


    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack itemStack, @Nullable CompoundTag nbt) {
        return new ICapabilityProvider() {

            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
                if(cap == ForgeCapabilities.ENERGY && Config.USE_ENERGY.get()) {
                    return LazyOptional.of(() -> new ModEnergyStorage(itemStack, maxEnergy, maxTransfer)).cast();
                }
                return LazyOptional.empty();
            }
        };
    }


    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level world, List<Component> list, TooltipFlag flag) {
        if (Config.USE_ENERGY.get()) {
            if (ForgeCapabilities.ENERGY == null) return; // sanity check
            itemStack.getCapability(ForgeCapabilities.ENERGY).ifPresent(e -> {
                list.add(Component.translatable("message.exocraft.energy").withStyle(ChatFormatting.GRAY)
                        .append(": " + ModEnergyStorage.formatEnergyValue(e.getEnergyStored()) + " / " + ModEnergyStorage.formatEnergyValue(e.getMaxEnergyStored())));
            });
        }
    }


    @Override
    public boolean isBarVisible(ItemStack stack) {
        if (Config.USE_ENERGY.get()) {
            return true;

        } else {
            return stack.isDamaged();
        }
    }


    public ItemStack getPoweredInstance() {
        ItemStack stack = new ItemStack(this);

        if (Config.USE_ENERGY.get()) {
            stack.getOrCreateTag().putInt("energy", getMaxEnergy());
        }

        return stack;
    }


    public ArrayList<ItemStack> getItemVariantList() {
        ArrayList<ItemStack> list = new ArrayList<>();

        ItemStack stack = new ItemStack(this);
        ItemStack poweredStack = new ItemStack(this);

        if (Config.USE_ENERGY.get()) {
            poweredStack.getOrCreateTag().putInt("energy", getMaxEnergy());
            list.add(poweredStack);
        }

        list.add(stack);
        return list;
    }


    @Override
    public int getBarWidth(ItemStack stack) {
        if (Config.USE_ENERGY.get()) {
            return Math.round(13 * getChargeRatio(stack));

        } else {
            return Math.round(13.0F - (float)stack.getDamageValue() * 13.0F / (float)this.getMaxDamage(stack));
        }
    }


    @Override
    public int getBarColor(ItemStack stack) {
        float f;

        if (Config.USE_ENERGY.get()) {
            f = getChargeRatio(stack);

        } else {
            float stackMaxDamage = this.getMaxDamage(stack);
            f = Math.max(0.0F, (stackMaxDamage - (float)stack.getDamageValue()) / stackMaxDamage);
        }

        return Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
    }


    public static int getMaxTransfer() {
        return maxTransfer;
    }


    public static int getMaxEnergy() {
        return maxEnergy;
    }
}

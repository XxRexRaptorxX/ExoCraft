package xxrexraptorxx.exocraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import xxrexraptorxx.exocraft.utils.ArmorTypes;
import xxrexraptorxx.exocraft.utils.Config;
import xxrexraptorxx.exocraft.utils.ModEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MechArmorItem extends ArmorItem {

	private static final int maxEnergy = 50000;
	private static final int maxTransfer = 1500;


	public MechArmorItem(ArmorMaterial material, Type type, Properties properties) {
		super(material, type, properties);
	}

	/**
	 * Counts how many armor pieces of a certain type are on the player.
	 */
	private int getMechSuitAmount(ArmorTypes armorType, Player player) {
		int amount = 0;

		Item helmet = player.getInventory().getArmor(3).getItem();
		Item chestplate = player.getInventory().getArmor(2).getItem();
		Item leggings = player.getInventory().getArmor(1).getItem();
		Item boots = player.getInventory().getArmor(0).getItem();

		if (helmet.toString().contains(armorType.getRegistryName())) amount++;
		if (chestplate.toString().contains(armorType.getRegistryName())) amount++;
		if (leggings.toString().contains(armorType.getRegistryName())) amount++;
		if (boots.toString().contains(armorType.getRegistryName())) amount++;

		return amount;
	}


	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		if(!level.isClientSide() && entity instanceof Player) {

			Player player = (Player) entity;

			int atlasCounter = getMechSuitAmount(ArmorTypes.ATLAS, player);
			int legionCounter = getMechSuitAmount(ArmorTypes.LEGION, player);
			int stryderCounter = getMechSuitAmount(ArmorTypes.STRYDER, player);
			int ogreCounter = getMechSuitAmount(ArmorTypes.OGRE, player);
			int ionCounter = getMechSuitAmount(ArmorTypes.ION, player);


			//ATLAS
			switch (atlasCounter) {
				case 1:
					player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 0, false, false, true));
					break;
				case 2:
					player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 0, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30, 0, false, false, true));
					break;
				case 3:
					player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 0, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30, 1, false, false, true));
					break;
				case 4:
					player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 0, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30, 1, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 30, 0, false, false, true));
					break;
				default:
					break;
			}

			//LEGION
			switch (legionCounter) {
				case 1:
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30, 0, false, false, true));
					break;
				case 2:
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30, 0, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 30, 0, false, false, true));
					break;
				case 3:
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30, 1, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 30, 1, false, false, true));
					break;
				case 4:
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30, 2, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 30, 2, false, false, true));
					break;
				default:
					break;
			}

			//ION
			switch (ionCounter) {
				case 1:
					player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 30, 0, false, false, true));
					break;
				case 2:
					player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 30, 0, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 30, 0, false, false, true));
					break;
				case 3:
					player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 30, 1, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 30, 0, false, false, true));
					break;
				case 4:
					player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 30, 1, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 30, 0, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 30, 0, false, false, true));
					break;
				default:
					break;
			}

			//STRYDER
			switch (stryderCounter) {
				case 1:
					player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 30, 0, false, false, true));
					break;
				case 2:
					player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 30, 0, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 0, false, false, true));
					break;
				case 3:
					player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 30, 1, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 1, false, false, true));
					break;
				case 4:
					player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 30, 1, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 1, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.JUMP, 30, 0, false, false, true));
					break;
				default:
					break;
			}

			//OGRE
			switch (ogreCounter) {
				case 1:
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 30, 0, false, false, true));
					break;
				case 2:
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 30, 0, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30, 0, false, false, true));
					break;
				case 3:
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 30, 1, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30, 1, false, false, true));
					break;
				case 4:
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 30, 2, false, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30, 1, false, false, true));
					break;
				default:
					break;
			}
		}
	}


	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		return Config.IS_BOOK_ENCHANTABLE.get();
	}


	@Override
	public boolean isEnchantable(ItemStack stack) {
		return Config.IS_TABLE_ENCHANTABLE.get();
	}


	// ENERGY HANDLING //

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


	@Override
	public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
		return Config.USE_DURABILITY.get() ? amount : 0;
	}


	public static int getMaxTransfer() {
		return maxTransfer;
	}


	public static int getMaxEnergy() {
		return maxEnergy;
	}

}
package xxrexraptorxx.exocraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.energy.IEnergyStorage;
import xxrexraptorxx.exocraft.utils.ArmorHelper;
import xxrexraptorxx.exocraft.utils.Config;
import xxrexraptorxx.exocraft.utils.ModEnergyStorage;
import xxrexraptorxx.exocraft.utils.enums.ExosuitTypes;
import xxrexraptorxx.exocraft.utils.enums.Modules;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class MechArmorItem extends ArmorItem {

	public MechArmorItem(ArmorMaterial material, Type type, Properties properties) {
		super(material, type, properties);
	}


	/**
	 * Counts how many armor pieces of a certain type are on the player.
	 */
	private int getMechSuitAmount(ExosuitTypes armorType, Player player) {
		int amount = 0;
		long time = player.level().getGameTime();
		ItemStack helmet = player.getInventory().getArmor(3);
		ItemStack chestplate = player.getInventory().getArmor(2);
		ItemStack leggings = player.getInventory().getArmor(1);
		ItemStack boots = player.getInventory().getArmor(0);

		if (checkArmorType(helmet, armorType) && (!Config.USE_ENERGY.get() || hasEnergy(helmet)) && helmet.getDamageValue() < helmet.getMaxDamage() - 1) {
			if (time % 5 == 0) consumeEnergy(helmet, 1);
			amount++;
		}
		if (checkArmorType(chestplate, armorType) && (!Config.USE_ENERGY.get() || hasEnergy(chestplate)) && chestplate.getDamageValue() < chestplate.getMaxDamage() - 1) {
			if (time % 5 == 0) consumeEnergy(chestplate, 1);
			amount++;
		}
		if (checkArmorType(leggings, armorType) && (!Config.USE_ENERGY.get() || hasEnergy(leggings)) && leggings.getDamageValue() < leggings.getMaxDamage() - 1) {
			if (time % 5 == 0) consumeEnergy(leggings, 1);
			amount++;
		}
		if (checkArmorType(boots, armorType) && (!Config.USE_ENERGY.get() || hasEnergy(boots)) && boots.getDamageValue() < boots.getMaxDamage() - 1) {
			if (time % 5 == 0) consumeEnergy(boots, 1);
			amount++;
		}

		return amount;
	}


	private boolean checkArmorType(ItemStack stack, ExosuitTypes armorType) {
		return stack.getItem().toString().contains(armorType.getRegistryName());
	}


	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		if(!level.isClientSide() && entity instanceof Player) {

			Player player = (Player) entity;

			int atlasCounter = getMechSuitAmount(ExosuitTypes.ATLAS, player);
			int legionCounter = getMechSuitAmount(ExosuitTypes.LEGION, player);
			int stryderCounter = getMechSuitAmount(ExosuitTypes.STRYDER, player);
			int ogreCounter = getMechSuitAmount(ExosuitTypes.OGRE, player);
			int ionCounter = getMechSuitAmount(ExosuitTypes.ION, player);

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
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> list, TooltipFlag flag) {
		if (Config.USE_ENERGY.get()) {
			if (Capabilities.EnergyStorage.ITEM == null) return; // sanity check
			stack.getCapability(Capabilities.EnergyStorage.ITEM).ifPresent(e -> {
				list.add(Component.translatable("message.exocraft.energy").withStyle(ChatFormatting.GRAY)
						.append(": " + ModEnergyStorage.formatEnergyValue(e.getEnergyStored()) + " / " + ModEnergyStorage.formatEnergyValue(e.getMaxEnergyStored())));
			});

			if (Config.USE_DURABILITY.get()) {
				Integer damagePercentage = ArmorHelper.getPercentageValue(this.getMaxDamage(stack), this.getDamage(stack));

				list.add(Component.translatable("message.exocraft.durability").withStyle(ChatFormatting.GRAY).append(Component.literal(": " + ArmorHelper.getDamageColor(damagePercentage) + String.valueOf(damagePercentage) + "%")));
			}
			list.add(Component.empty());
		}


		if (Config.ENABLE_SNOW_WALKER_MODULE.get() && stack.getOrCreateTag().getBoolean(Modules.SNOW_WALKER_MODULE.getRegistryName())) {
			list.add(Component.literal("> ").append(Component.translatable(Modules.SNOW_WALKER_MODULE.getLangKey()).withStyle(ChatFormatting.GRAY)));
		}
		if (Config.ENABLE_ADVANCED_VISOR_MODULE.get() && stack.getOrCreateTag().getBoolean(Modules.ADVANCED_VISOR_MODULE.getRegistryName())) {
			list.add(Component.literal("> ").append(Component.translatable(Modules.ADVANCED_VISOR_MODULE.getLangKey()).withStyle(ChatFormatting.GRAY)));
		}
		if (Config.ENABLE_GLIDER_MODULE.get() && stack.getOrCreateTag().getBoolean(Modules.GLIDER_MODULE.getRegistryName())) {
			list.add(Component.literal("> ").append(Component.translatable(Modules.GLIDER_MODULE.getLangKey()).withStyle(ChatFormatting.GRAY)));
		}
		if (Config.ENABLE_DETERRENCE_MODULE.get() && stack.getOrCreateTag().getBoolean(Modules.DETERRENCE_MODULE.getRegistryName())) {
			list.add(Component.literal("> ").append(Component.translatable(Modules.DETERRENCE_MODULE.getLangKey()).withStyle(ChatFormatting.GRAY)));
		}
		//if (Config.ENABLE_FIRE_RESISTANT_COATING_MODULE.get() && stack.getOrCreateTag().getBoolean(Modules.FIRE_RESISTANT_COATING_MODULE.getRegistryName())) {
		//	list.add(Component.literal("> ").append(Component.translatable(Modules.FIRE_RESISTANT_COATING_MODULE.getLangKey()).withStyle(ChatFormatting.GRAY)));
		//}
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
		IEnergyStorage energy = stack.getCapability(Capabilities.EnergyStorage.ITEM);

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


			@Nullable
			@Override
			public Optional getCapability(Object object, Object context) {
				if(cap == Capabilities.EnergyStorage.ITEM && Config.USE_ENERGY.get()) {
					return Lazy.of(() -> new ModEnergyStorage(itemStack, Config.EXOSUIT_MAX_ENERGY_AMOUNT.get(), Config.EXOSUIT_MAX_ENERGY_TRANSFER.get())).cast();
				}
				return Lazy.empty();
			}

			//@Nonnull
			//@Override
			//public <T> Optional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
			//	if(cap == ForgeCapabilities.ENERGY && Config.USE_ENERGY.get()) {
			//		return LazyOptional.of(() -> new ModEnergyStorage(itemStack, Config.EXOSUIT_MAX_ENERGY_AMOUNT.get(), Config.EXOSUIT_MAX_ENERGY_TRANSFER.get())).cast();
			//	}
			//	return LazyOptional.empty();
			//}
		};
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
	public boolean isBarVisible(ItemStack stack) {
		if (Config.USE_ENERGY.get()) {
			return true;

		} else {
			return stack.isDamaged();
		}
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
		if (Config.USE_ENERGY.get()) {
			if (Config.USE_DURABILITY.get()) {
				return stack.getDamageValue() == stack.getMaxDamage() - 1 ? 0 : amount;

			} else {
				return 0;
			}

		} else {
			return Config.USE_DURABILITY.get() ? amount : 0;
		}
	}


	public static int getMaxTransfer() {
		return Config.EXOSUIT_MAX_ENERGY_TRANSFER.get();
	}


	public static int getMaxEnergy() {
		return Config.EXOSUIT_MAX_ENERGY_AMOUNT.get();
	}


	public static boolean hasEnergy(ItemStack stack) {
		return stack.getOrCreateTag().getInt("energy") > 0;
	}


	private static void consumeEnergy(ItemStack stack, Integer maxExtract) {
		if (Config.USE_ENERGY.get() && hasEnergy(stack)) {
			Lazy<IEnergyStorage> energy = stack.getCapability(Capabilities.EnergyStorage.ITEM);

			IEnergyStorage energyStorage = energy.orElseThrow(IllegalStateException::new);
			energyStorage.extractEnergy(maxExtract, false);
		}
	}


	// MODULES //

	@Override
	public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
		if (Config.ENABLE_SNOW_WALKER_MODULE.get() && stack.hasTag()) {

			boolean snowWalkerEnabled = stack.getOrCreateTag().getBoolean(Modules.SNOW_WALKER_MODULE.getRegistryName());

			return (!Config.USE_ENERGY.get() || hasEnergy(stack)) && snowWalkerEnabled;
		}

		return false;
	}


	@Override
	public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
		if (Config.ENABLE_DETERRENCE_MODULE.get() && stack.hasTag()) {

			boolean snowWalkerEnabled = stack.getOrCreateTag().getBoolean(Modules.DETERRENCE_MODULE.getRegistryName());

			return (!Config.USE_ENERGY.get() || hasEnergy(stack)) && snowWalkerEnabled;
		}

		return false;
	}


	@Override
	public boolean isEnderMask(ItemStack stack, Player player, EnderMan entity) {
		if (Config.ENABLE_ADVANCED_VISOR_MODULE.get() && stack.hasTag()) {

			boolean snowWalkerEnabled = stack.getOrCreateTag().getBoolean(Modules.ADVANCED_VISOR_MODULE.getRegistryName());

			return (!Config.USE_ENERGY.get() || hasEnergy(stack)) && snowWalkerEnabled;
		}

		return false;
	}


	//@Override			TODO! not working
	//public boolean isFireResistant() {
	//	if (Config.ENABLE_FIRE_RESISTANT_COATING_MODULE.get()) {
	//		return new ItemStack(this.asItem()).getOrCreateTag().getBoolean(Modules.FIRE_RESISTANT_COATING_MODULE.getRegistryName());
	//
	//	} else {
	//		return false;
	//	}
	//}


	@Override
	public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
		if (Config.ENABLE_GLIDER_MODULE.get() && stack.getOrCreateTag().getBoolean(Modules.GLIDER_MODULE.getRegistryName())) {
			return isFlyEnabled(stack);

		} else {
			return false;
		}
	}


	public static boolean isFlyEnabled(ItemStack stack) {
		return stack.getDamageValue() < stack.getMaxDamage() - 1;
	}


	@Override
	public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
		if (!entity.level().isClientSide) {
			int nextFlightTick = flightTicks + 1;

			if (nextFlightTick % 10 == 0) {
				if (nextFlightTick % 20 == 0) {

					if (Config.USE_ENERGY.get() && Config.USE_ENERGY_FOR_MODULES.get()) {
						if (hasEnergy(stack)) {
							consumeEnergy(stack, 1);

						} else {
							return false;
						}

					} else {
						stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
					}
				}
				entity.gameEvent(GameEvent.ELYTRA_GLIDE);
			}
		}

		return true;
	}
}
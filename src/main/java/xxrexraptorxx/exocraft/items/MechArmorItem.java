package xxrexraptorxx.exocraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
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
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import xxrexraptorxx.exocraft.main.References;
import xxrexraptorxx.exocraft.utils.ArmorHelper;
import xxrexraptorxx.exocraft.utils.Config;
import xxrexraptorxx.exocraft.utils.ModEnergyStorage;
import xxrexraptorxx.exocraft.utils.enums.ExosuitTypes;

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
			if (ForgeCapabilities.ENERGY == null) return; // sanity check
			stack.getCapability(ForgeCapabilities.ENERGY).ifPresent(e -> {
				list.add(Component.translatable("message.exocraft.energy").withStyle(ChatFormatting.GRAY)
						.append(": " + ModEnergyStorage.formatEnergyValue(e.getEnergyStored()) + " / " + ModEnergyStorage.formatEnergyValue(e.getMaxEnergyStored())));
			});

			if (Config.USE_DURABILITY.get()) {
				Integer damagePercentage = ArmorHelper.getPercentageValue(this.getMaxDamage(stack), this.getDamage(stack));

				list.add(Component.translatable("message.exocraft.durability").withStyle(ChatFormatting.GRAY).append(Component.literal(": " + ArmorHelper.getDamageColor(damagePercentage) + String.valueOf(damagePercentage) + "%")));
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
		return maxTransfer;
	}


	public static int getMaxEnergy() {
		return maxEnergy;
	}


	public static boolean hasEnergy(ItemStack stack) {
		return stack.getOrCreateTag().getInt("energy") > 0;
	}


	private static void consumeEnergy(ItemStack stack, Integer maxExtract) {
		if (Config.USE_ENERGY.get() && hasEnergy(stack)) {
			LazyOptional<IEnergyStorage> energy = stack.getCapability(ForgeCapabilities.ENERGY);

			IEnergyStorage energyStorage = energy.orElseThrow(IllegalStateException::new);
			energyStorage.extractEnergy(maxExtract, false);
		}
	}


	// MODULES //

	@Override
	public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
		if (Config.ENABLE_SNOW_WALKER_MODULE.get()) {
			return stack.getOrCreateTag().getString("module") == References.MODID + ":snow_walker";

		} else {
			return false;
		}
	}


	@Override
	public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
		if (Config.ENABLE_DETERRENCE_MODULE.get()) {
			return stack.getOrCreateTag().getString("module") == References.MODID + ":deterrence";

		} else {
			return false;
		}
	}


	@Override
	public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
		if (Config.ENABLE_ADVANCED_VISOR_MODULE.get()) {
			return stack.getOrCreateTag().getString("module") == References.MODID + ":advanced_visor";

		} else {
			return false;
		}
	}


	@Override
	public boolean isFireResistant() {
		if (Config.ENABLE_ADVANCED_VISOR_MODULE.get()) {
			return new ItemStack(this).getOrCreateTag().getString("module") == References.MODID + ":advanced_visor";

		} else {
			return false;
		}
	}


	@Override
	public boolean canElytraFly(ItemStack stack, net.minecraft.world.entity.LivingEntity entity) {
		if (Config.ENABLE_GLIDER_MODULE.get() && stack.getOrCreateTag().getString("module") == References.MODID + ":glider") {
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
					stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
				}
				entity.gameEvent(GameEvent.ELYTRA_GLIDE);
			}
		}

		return true;
	}
}
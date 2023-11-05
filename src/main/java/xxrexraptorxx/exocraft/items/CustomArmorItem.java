package xxrexraptorxx.exocraft.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xxrexraptorxx.exocraft.utils.ArmorTypes;

public class CustomArmorItem extends ArmorItem {

	public CustomArmorItem(ArmorMaterial material, Type type, Properties properties) {
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
		return false;
	}


	@Override
	public boolean isEnchantable(ItemStack stack) {
		return false;
	}

}
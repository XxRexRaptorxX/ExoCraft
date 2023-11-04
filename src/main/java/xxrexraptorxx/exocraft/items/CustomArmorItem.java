package xxrexraptorxx.exocraft.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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

		System.err.println("############################## " + helmet.toString() + " = " + armorType.getRegistryName());

		if (helmet.toString().contains(armorType.getRegistryName())) amount++;
		if (chestplate.toString().contains(armorType.getRegistryName())) amount++;
		if (leggings.toString().contains(armorType.getRegistryName())) amount++;
		if (boots.toString().contains(armorType.getRegistryName())) amount++;

		return amount;
	}


	@Override
	public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
		player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 0));

		if(!level.isClientSide()) {

			int atlasCounter = getMechSuitAmount(ArmorTypes.ATLAS, player);
			int legionCounter = getMechSuitAmount(ArmorTypes.LEGION, player);
			int stryderCounter = getMechSuitAmount(ArmorTypes.STRYDER, player);
			int ogreCounter = getMechSuitAmount(ArmorTypes.OGRE, player);
			int ionCounter = getMechSuitAmount(ArmorTypes.ION, player);

			System.err.println("##############################" + atlasCounter);
			//ATLAS
			switch (atlasCounter) {
				case 1:
					player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 0));

				case 2:
					player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 0));
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 0));

				case 3:
					player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 0));
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 1));

				case 4:
					player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 0));
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 1));
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 0));

				default:
					break;
			}
		}
	}


}
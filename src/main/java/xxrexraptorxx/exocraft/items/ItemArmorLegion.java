package xxrexraptorxx.exocraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import xxrexraptorxx.exocraft.main.ExoCraft;
import xxrexraptorxx.exocraft.main.ModItems;

public class ItemArmorLegion extends ItemArmor {

	public ItemArmorLegion(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		this.setCreativeTab(ExoCraft.mainTab);
        }
	
	@Override
	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
	 return stack.getItem() == ModItems.reinforcedIronPlate;
	} 



	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (!world.isRemote) {
			 int gearCounter = 0;

			if(player.inventory.armorInventory.get(3) != ItemStack.EMPTY && player.inventory.armorInventory.get(3).getItem() == ModItems.legionHelmet) {
				gearCounter = gearCounter + 1;
			}
			if(player.inventory.armorInventory.get(2) != ItemStack.EMPTY && player.inventory.armorInventory.get(2).getItem() == ModItems.legionChestplate) {
				gearCounter = gearCounter + 1;
			}
			if(player.inventory.armorInventory.get(1) != ItemStack.EMPTY && player.inventory.armorInventory.get(1).getItem() == ModItems.legionLeggings) {
				gearCounter = gearCounter + 1;
			}
			if(player.inventory.armorInventory.get(0) != ItemStack.EMPTY && player.inventory.armorInventory.get(0).getItem() == ModItems.legionBoots) {	
				gearCounter = gearCounter + 1;
			}
			

			//Result
			switch (gearCounter) {
			case 4:
					this.effectPlayer(player, MobEffects.STRENGTH, 2);
					this.effectPlayer(player, MobEffects.HASTE, 2);
				break;
			case 3:
					this.effectPlayer(player, MobEffects.STRENGTH, 1);
					this.effectPlayer(player, MobEffects.HASTE, 1);
				break;
			case 2:
					this.effectPlayer(player, MobEffects.HASTE, 0);
					this.effectPlayer(player, MobEffects.STRENGTH, 0);
				break;
			case 1:
					this.effectPlayer(player, MobEffects.STRENGTH, 0);
				break;
			default:
				break;
			}
			
			gearCounter = 0;
		}
	}
	
	

	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier) {
	    if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)
	        player.addPotionEffect(new PotionEffect(potion, 10, amplifier, true, false));
	}

}

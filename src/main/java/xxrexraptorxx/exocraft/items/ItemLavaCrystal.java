package xxrexraptorxx.exocraft.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xxrexraptorxx.exocraft.main.ExoCraft;

public class ItemLavaCrystal extends Item {
	
	public ItemLavaCrystal () {
		super();
		this.setCreativeTab(ExoCraft.mainTab);
	}

	
	   @Override
	   public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	        pos = pos.offset(facing);
	        ItemStack itemstack = player.getHeldItem(hand);

	        if (!player.canPlayerEdit(pos, facing, itemstack)) {
	            return EnumActionResult.FAIL;
	        
	        } else {
	            if (worldIn.isAirBlock(pos)) {
	                worldIn.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
	                worldIn.setBlockState(pos, Blocks.FIRE.getDefaultState(), 11);
	            }

	            if (player instanceof EntityPlayerMP) {
	                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos, itemstack);
	            }

	            return EnumActionResult.SUCCESS;
	        }
	    }
}

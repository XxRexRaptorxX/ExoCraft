package xxrexraptorxx.exocraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xxrexraptorxx.exocraft.main.ExoCraft;
import xxrexraptorxx.exocraft.tileentitys.TileEntityFabricator;

public class BlockFabricator extends Block {

	public BlockFabricator() {
		super(Material.ROCK);
		this.setCreativeTab(ExoCraft.mainTab);
		this.setSoundType(SoundType.STONE);
		this.setHardness(3.5F); 
	}
	
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {		
		if (worldIn.isRemote) {
			return true;
		} else {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityFabricator) {
				playerIn.openGui(ExoCraft.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
				playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
			}

			return true;
		}
	}
	
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityFabricator();
	}
	

	@Override
	public boolean hasTileEntity(IBlockState state){
		return true;
	}

	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntity tileentity = worldIn.getTileEntity(pos);

		if (tileentity instanceof IInventory) {
			InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
			worldIn.updateComparatorOutputLevel(pos, this);
		}

		super.breakBlock(worldIn, pos, state);
	}

}

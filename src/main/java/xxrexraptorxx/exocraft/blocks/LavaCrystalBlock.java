package xxrexraptorxx.exocraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import xxrexraptorxx.exocraft.registry.CreativeModeTabs;


public class LavaCrystalBlock extends Block {

	protected static final VoxelShape CUSTOM_COLLISION_AABB = Block.box(0.0625D, 0.0625D, 0.0625D, 15.9375D, 15.9375D, 15.9375D);


	public LavaCrystalBlock() {
		super(Properties.of(Material.METAL)
				.requiresCorrectToolForDrops()
				.strength(4.0F, 8.0F)
				.sound(SoundType.METAL)
				.color(MaterialColor.COLOR_RED)
		);
	}


	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return CUSTOM_COLLISION_AABB;
	}


	@Override
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entityIn) {
		if (!level.isClientSide) {
			entityIn.setSecondsOnFire(5);
		}
	}

}
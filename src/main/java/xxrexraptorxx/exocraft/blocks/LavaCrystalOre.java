package xxrexraptorxx.exocraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.concurrent.ThreadLocalRandom;


public class LavaCrystalOre extends Block {

	public LavaCrystalOre() {
		super(Properties.of()
				.requiresCorrectToolForDrops()
				.strength(3.0F, 5.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.COLOR_RED)
				.instrument(NoteBlockInstrument.BASEDRUM)
		);

	}

	@Override
	public int getExpDrop(BlockState state, LevelReader level, RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel) {
		int random = ThreadLocalRandom.current().nextInt(3, 7 + 1);
		return silkTouchLevel == 0 ? random : 0;
	}

}
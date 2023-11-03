package xxrexraptorxx.exocraft.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;


public class LavaCrystalBlock extends Block {

	public LavaCrystalBlock() {
		super(Properties.of()
				.requiresCorrectToolForDrops()
				.strength(4.0F, 8.0F)
				.sound(SoundType.AMETHYST)
				.mapColor(MapColor.COLOR_RED)
				.instrument(NoteBlockInstrument.BIT)
		);
	}

}
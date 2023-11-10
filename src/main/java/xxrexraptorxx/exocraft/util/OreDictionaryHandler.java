package xxrexraptorxx.exocraft.util;

import net.minecraftforge.oredict.OreDictionary;
import xxrexraptorxx.exocraft.main.ModBlocks;
import xxrexraptorxx.exocraft.main.ModItems;

public class OreDictionaryHandler {
	
	public static void registerOreDictionary() {
	
		// Items
		OreDictionary.registerOre("gemCrystalLava", ModItems.lavaCrystal);
		OreDictionary.registerOre("coreEnergy", ModItems.energyCore);
		OreDictionary.registerOre("circuitRedstone", ModItems.redstoneCircuit);
		OreDictionary.registerOre("plateReinforced", ModItems.reinforcedIronPlate);
		OreDictionary.registerOre("unitAtlas", ModItems.unitAtlas);
		OreDictionary.registerOre("unitIon", ModItems.unitIon);
		OreDictionary.registerOre("unitLegion", ModItems.unitLegion);
		OreDictionary.registerOre("unitStryder", ModItems.unitStryder);
		OreDictionary.registerOre("unitOgre", ModItems.unitOgre);

		
		// Blocks
		OreDictionary.registerOre("oreCrystalLava", ModBlocks.lavaCrystalOre);
		OreDictionary.registerOre("blockCrystalLava", ModBlocks.lavaCrystalBlock);
	}

}

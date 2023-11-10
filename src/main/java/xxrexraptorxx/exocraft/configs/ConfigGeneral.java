package xxrexraptorxx.exocraft.configs;

import net.minecraftforge.common.config.Config;
import xxrexraptorxx.exocraft.main.Reference;

@Config(modid = Reference.MODID, category = "general", name = "ExoCraft - General")
public class ConfigGeneral {

		@Config.Comment(value = "Activate the ingame Update Checker from RuneCraft")
		public static boolean activateUpdateChecker = true;
		
		@Config.Comment(value = "Activate the Industrial Tools")
		@Config.RequiresWorldRestart
		public static boolean activateIndustrialTools = true;
		
		@Config.Comment(value = "Activate ore generation in existing chunks")
		@Config.RequiresWorldRestart
		public static boolean activateRetroGen = true;
		
		@Config.Comment(value = "Activate verbose logging for retrogen")
		public static boolean activateVerbose = false;

		@Config.Comment(value = "The Lava Crystal spawn chance")
		@Config.RequiresWorldRestart
		@Config.RangeInt(min = 1, max = 50)
		public static int lavaCrystalSpawnChance = 3;
}

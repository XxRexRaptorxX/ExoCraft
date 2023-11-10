package xxrexraptorxx.exocraft.world;

import java.util.ArrayDeque;
import java.util.Random;

import org.apache.logging.log4j.Level;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xxrexraptorxx.exocraft.configs.ConfigGeneral;
import xxrexraptorxx.exocraft.main.ExoCraft;
import xxrexraptorxx.exocraft.main.ModBlocks;
import xxrexraptorxx.exocraft.main.Reference;

public class WorldGenerator implements IWorldGenerator {
	
    public static final String RETRO_NAME = Reference.NAME;
    public static WorldGenerator instance = new WorldGenerator();

    		
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateWorld(random, chunkX, chunkZ, world, true);
    }
    

	public void generateWorld(Random random, int chunkX, int chunkZ, World world, boolean newGen) {
        if (!newGen && !ConfigGeneral.activateRetroGen) {
            return;
        }
		
		if(world.provider.getDimension() == DimensionType.NETHER.getId()) {
			addOre(ModBlocks.lavaCrystalOre.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, /**/ 4, ConfigGeneral.lavaCrystalSpawnChance, 3, 45, BlockMatcher.forBlock(Blocks.NETHERRACK));
		}
		
		if (!newGen) {
            world.getChunkFromChunkCoords(chunkX, chunkZ).markDirty();
        }
		
	}

	
	 private void addOre(IBlockState block, World world, Random random, int blockXPos, int blockZPos, int maxVeinSize, int chance, int minY, int maxY, Predicate<IBlockState> blockToSpawnIn){
		  int diffMinMaxY = maxY - minY;
		  for(int x = 0; x < chance; x++){
			   int posX = blockXPos + random.nextInt(16);
			   int posY = minY + random.nextInt(diffMinMaxY);
			   int posZ = blockZPos + random.nextInt(16);
			   (new WorldGenMinable(block, maxVeinSize, blockToSpawnIn)).generate(world, random, new BlockPos(posX, posY, posZ));
		  }
	 }   

	 
	 
		/** RetroGen **/
		//Code from McJty 
		
	    @SubscribeEvent
	    public void handleChunkSaveEvent(ChunkDataEvent.Save event) {
	        NBTTagCompound genTag = event.getData().getCompoundTag(RETRO_NAME);
	        if (!genTag.hasKey("generated")) {
	            // If we did not have this key then this is a new chunk and we will have proper ores generated.
	            // Otherwise we are saving a chunk for which ores are not yet generated.
	            genTag.setBoolean("generated", true);
	        }
	        event.getData().setTag(RETRO_NAME, genTag);
	    }

	    @SubscribeEvent
	    public void handleChunkLoadEvent(ChunkDataEvent.Load event) {
	        int dim = event.getWorld().provider.getDimension();

	        boolean regen = false;
	        NBTTagCompound tag = (NBTTagCompound) event.getData().getTag(RETRO_NAME);
	        ChunkPos coord = event.getChunk().getPos();

	        if (tag != null) {
	            boolean generated = ConfigGeneral.activateRetroGen && !tag.hasKey("generated");
	            if (generated) {
	                if (ConfigGeneral.activateVerbose) {
	                    ExoCraft.logger.log(Level.DEBUG, "Queuing Retrogen for chunk: " + coord.toString() + ".");
	                }
	                regen = true;
	            }
	        } else {
	            regen = ConfigGeneral.activateRetroGen;
	        }

	        if (regen) {
	            ArrayDeque<ChunkPos> chunks = WorldTickHandler.chunksToGen.get(dim);

	            if (chunks == null) {
	                WorldTickHandler.chunksToGen.put(dim, new ArrayDeque<>(128));
	                chunks = WorldTickHandler.chunksToGen.get(dim);
	            }
	            if (chunks != null) {
	                chunks.addLast(coord);
	                WorldTickHandler.chunksToGen.put(dim, chunks);
	            }
	        }
	    }

}

package xxrexraptorxx.exocraft.world;

import net.minecraft.item.Item;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xxrexraptorxx.exocraft.main.ModItems;

public class LootHandler {
	
	    private void addLoot(LootPool pool, Item plakat, int weight) {
	        pool.addEntry(new LootEntryItem(plakat, weight, 0, new LootFunction[0], new LootCondition[0], plakat.getRegistryName().toString()));
	    }

	    @SubscribeEvent
	    public void onLootLoad(LootTableLoadEvent event) {
	        if(event.getName().equals(LootTableList.CHESTS_END_CITY_TREASURE)) {
	            LootPool pool = event.getTable().getPool("main");
	            addLoot(pool, ModItems.unitAtlas, 10);
	            addLoot(pool, ModItems.unitIon, 10);
	            addLoot(pool, ModItems.unitLegion, 10);
	            addLoot(pool, ModItems.unitOgre, 10);
	            addLoot(pool, ModItems.unitStryder, 10);
	        }
	        
	        if(event.getName().equals(LootTableList.CHESTS_STRONGHOLD_CORRIDOR)) {
	            LootPool pool = event.getTable().getPool("main");
	            addLoot(pool, ModItems.unitAtlas, 5);
	            addLoot(pool, ModItems.unitIon, 5);
	            addLoot(pool, ModItems.unitLegion, 5);
	            addLoot(pool, ModItems.unitOgre, 5);
	            addLoot(pool, ModItems.unitStryder, 5);
	        }
	        
	        if(event.getName().equals(LootTableList.CHESTS_WOODLAND_MANSION)) {
	            LootPool pool = event.getTable().getPool("main");
	            addLoot(pool, ModItems.unitAtlas, 1);
	            addLoot(pool, ModItems.unitIon, 1);
	            addLoot(pool, ModItems.unitLegion, 1);
	            addLoot(pool, ModItems.unitOgre, 1);
	            addLoot(pool, ModItems.unitStryder, 1);
	        }
	        
	        if(event.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE)) {
	            LootPool pool = event.getTable().getPool("main");
	            addLoot(pool, ModItems.unitAtlas, 1);
	            addLoot(pool, ModItems.unitIon, 1);
	            addLoot(pool, ModItems.unitLegion, 1);
	            addLoot(pool, ModItems.unitOgre, 1);
	            addLoot(pool, ModItems.unitStryder, 1);
	        }
	        
	        if(event.getName().equals(LootTableList.CHESTS_NETHER_BRIDGE)) {
	            LootPool pool = event.getTable().getPool("main");
	            addLoot(pool, ModItems.unitAtlas, 1);
	            addLoot(pool, ModItems.unitIon, 1);
	            addLoot(pool, ModItems.unitLegion, 1);
	            addLoot(pool, ModItems.unitOgre, 1);
	            addLoot(pool, ModItems.unitStryder, 1);
	        }
	    }
	}

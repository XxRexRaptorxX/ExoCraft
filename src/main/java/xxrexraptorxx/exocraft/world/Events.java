package xxrexraptorxx.exocraft.world;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.VersionChecker;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.ItemStackedOnOtherEvent;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import xxrexraptorxx.exocraft.items.MechArmorItem;
import xxrexraptorxx.exocraft.items.ModuleItem;
import xxrexraptorxx.exocraft.main.Exocraft;
import xxrexraptorxx.exocraft.main.References;
import xxrexraptorxx.exocraft.registry.ModItems;
import xxrexraptorxx.exocraft.utils.Config;
import xxrexraptorxx.exocraft.utils.enums.Modules;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

@Mod.EventBusSubscriber(modid = References.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Events {


    /** Update-Checker **/
    private static boolean hasShownUp = false;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (Config.UPDATE_CHECKER.get()) {
            if (!hasShownUp && Minecraft.getInstance().screen == null) {
                if (VersionChecker.getResult(ModList.get().getModContainerById(References.MODID).get().getModInfo()).status() == VersionChecker.Status.OUTDATED ||
                        VersionChecker.getResult(ModList.get().getModContainerById(References.MODID).get().getModInfo()).status() == VersionChecker.Status.BETA_OUTDATED ) {

                    MutableComponent url = Component.literal(ChatFormatting.GREEN + "Click here to update!");
                    url.withStyle(url.getStyle().withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, References.URL)));

                    Minecraft.getInstance().player.displayClientMessage(Component.literal(ChatFormatting.BLUE + "A newer version of " + ChatFormatting.YELLOW + References.NAME + ChatFormatting.BLUE + " is available!"), false);
                    Minecraft.getInstance().player.displayClientMessage(url, false);

                    hasShownUp = true;

                } else if (VersionChecker.getResult(ModList.get().getModContainerById(References.MODID).get().getModInfo()).status() == VersionChecker.Status.FAILED) {
                    Exocraft.LOGGER.error(References.NAME + "'s version checker failed!");
                    hasShownUp = true;

                }
            }
        }
    }


    /**
     * Distributes the supporter rewards on first join.
     */
    @SubscribeEvent
    public static void SupporterRewards(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (Config.PATREON_REWARDS.get()) {

            try {
                URL SUPPORTER_URL = new URL("https://raw.githubusercontent.com/XxRexRaptorxX/Patreons/main/Supporter");
                URL PREMIUM_SUPPORTER_URL = new URL("https://raw.githubusercontent.com/XxRexRaptorxX/Patreons/main/Premium%20Supporter");
                URL ELITE_URL = new URL("https://raw.githubusercontent.com/XxRexRaptorxX/Patreons/main/Elite");

                //test if a player already has rewards
                if (!player.getInventory().contains(new ItemStack(Items.PAPER))) {

                    ServerPlayer serverPlayer = (ServerPlayer) player;
                    //test if player joins the first time
                    if (serverPlayer.getStats().getValue(Stats.CUSTOM, Stats.PLAY_TIME) < 5) {

                        //test if player is supporter
                        if (SupporterCheck(SUPPORTER_URL, player)) {

                            ItemStack certificate = new ItemStack(Items.PAPER).setHoverName((Component.literal("Thank you for supporting me in my work!").withStyle(ChatFormatting.GOLD).append(Component.literal(" - XxRexRaptorxX").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GREEN))));

                            CompoundTag ownerNBT = new CompoundTag();
                            ItemStack reward = new ItemStack(Items.PLAYER_HEAD);
                            ownerNBT.putString("SkullOwner", player.getName().getString());
                            reward.setTag(ownerNBT);

                            level.playSound((Player) null, player.blockPosition(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);
                            player.addItem(reward);
                            player.addItem(certificate);
                        }

                        //test if player is premium supporter
                        if (SupporterCheck(PREMIUM_SUPPORTER_URL, player)) {
                            ItemStack reward = new ItemStack(Items.DIAMOND_SWORD, 1).setHoverName(Component.literal("Rex's Night Sword").withStyle(ChatFormatting.DARK_GRAY));
                            reward.enchant(Enchantments.MENDING, 1);
                            reward.enchant(Enchantments.SHARPNESS, 3);
                            player.addItem(reward);
                        }

                        //test if player is elite
                        if (SupporterCheck(ELITE_URL, player)) {
                            player.addItem(new ItemStack(Items.NETHER_STAR).setHoverName(Component.literal("Elite Star")));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Tests if a player is a supporter
     *
     * @param url url to a file that contains the supporter names
     * @param player ingame player
     * @return true/false
     */
    private static boolean SupporterCheck(URL url, Player player) {
        try {
            Scanner scanner = new Scanner(url.openStream());
            List<String> supporterList = scanner.tokens().toList();

            for (String name: supporterList) {
                //test if player is in supporter list
                if (player.getName().getString().equals(name)) {
                    return true;
                }
            }

            scanner.close();

        } catch (MalformedURLException e) {
            Exocraft.LOGGER.error("Supporter list URL not found! >>" + url);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        if (Config.WANDERING_TRADES.get()) {
            List<VillagerTrades.ItemListing> trades = event.getRareTrades();
            ItemStack cost = new ItemStack(Items.EMERALD, Config.UNIT_COST.get());

            trades.add(((trader, random) -> new MerchantOffer(cost, new ItemStack(ModItems.OLD_UNIT.get()), 1, 3, 0.05F)));
        }
    }


    @SubscribeEvent
    public static void equipModules(ItemStackedOnOtherEvent event) {
        ItemStack armor = event.getCarriedItem();
        ItemStack module = event.getStackedOnItem();
        ClickAction action = event.getClickAction();
        Player player = event.getPlayer();
        Level level = player.level();
        BlockPos pos = player.getOnPos();

        if (armor.getItem() instanceof MechArmorItem && module.getItem() instanceof ModuleItem && module.getItem() != ModItems.BLANK_MODULE.get() &&
                action == ClickAction.PRIMARY && ModuleItem.isCorrectModule((MechArmorItem) armor.getItem(), module.getItem())) {

            if (module.getItem() == ModItems.SNOW_WALKER_MODULE.get() && !armor.getOrCreateTag().getBoolean(Modules.SNOW_WALKER_MODULE.getRegistryName())) {
                armor.getOrCreateTag().putBoolean(Modules.SNOW_WALKER_MODULE.getRegistryName(), true);
                level.playSound(player, pos, SoundEvents.UI_BUTTON_CLICK.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                if (!player.isCreative()) module.shrink(1);

            } else if (module.getItem() == ModItems.ADVANCED_VISOR_MODULE.get() && !armor.getOrCreateTag().getBoolean(Modules.ADVANCED_VISOR_MODULE.getRegistryName())) {
                armor.getOrCreateTag().putBoolean(Modules.ADVANCED_VISOR_MODULE.getRegistryName(), true);
                level.playSound(player, pos, SoundEvents.UI_BUTTON_CLICK.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                if (!player.isCreative()) module.shrink(1);

            } else if (module.getItem() == ModItems.GLIDER_MODULE.get() && !armor.getOrCreateTag().getBoolean(Modules.GLIDER_MODULE.getRegistryName())) {
                armor.getOrCreateTag().putBoolean(Modules.GLIDER_MODULE.getRegistryName(), true);
                level.playSound(player, pos, SoundEvents.UI_BUTTON_CLICK.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                if (!player.isCreative()) module.shrink(1);

            } else if (module.getItem() == ModItems.DETERRENCE_MODULE.get() && !armor.getOrCreateTag().getBoolean(Modules.DETERRENCE_MODULE.getRegistryName())) {
                armor.getOrCreateTag().putBoolean(Modules.DETERRENCE_MODULE.getRegistryName(), true);
                level.playSound(player, pos, SoundEvents.UI_BUTTON_CLICK.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                if (!player.isCreative()) module.shrink(1);

            } else if (module.getItem() == ModItems.FIRE_RESISTANT_COATING_MODULE.get() && !armor.getOrCreateTag().getBoolean(Modules.FIRE_RESISTANT_COATING_MODULE.getRegistryName())) {
                armor.getOrCreateTag().putBoolean(Modules.FIRE_RESISTANT_COATING_MODULE.getRegistryName(), true);
                level.playSound(player, pos, SoundEvents.UI_BUTTON_CLICK.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                if (!player.isCreative()) module.shrink(1);
            }
        }
    }


}

package xxrexraptorxx.exocraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import xxrexraptorxx.exocraft.registry.CreativeModeTabs;
import xxrexraptorxx.exocraft.registry.ModItems;

import java.util.List;
import java.util.Random;

public class UnitItem extends Item {

    public UnitItem() {
        super(new Properties()
                .stacksTo(16)
                .rarity(Rarity.RARE)
                .tab(CreativeModeTabs.MOD_TAB)
        );
    }


    @Override
    public boolean isFoil(ItemStack stack) {
        if (this == ModItems.EMPTY_UNIT.get() || this == ModItems.OLD_UNIT.get()) {
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        if (this == ModItems.OLD_UNIT.get()) {
            list.add(Component.translatable("message.exocraft.old_unit_desc").withStyle(ChatFormatting.GRAY));
        }
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (this == ModItems.OLD_UNIT.get()) {

            level.playSound(player, player.getOnPos(), SoundEvents.SOUL_SAND_FALL, SoundSource.PLAYERS, 1.0F, 1.0F);
            player.getItemInHand(hand).shrink(1);

            switch (new Random().nextInt(5)) {
                case 0:
                    player.addItem(new ItemStack(ModItems.ATLAS_UNIT.get()));
                        break;
                case 1:
                    player.addItem(new ItemStack(ModItems.OGRE_UNIT.get()));
                    break;
                case 2:
                    player.addItem(new ItemStack(ModItems.LEGION_UNIT.get()));
                    break;
                case 3:
                    player.addItem(new ItemStack(ModItems.STRYDER_UNIT.get()));
                    break;
                case 4:
                    player.addItem(new ItemStack(ModItems.ION_UNIT.get()));
                    break;
                default:
                    player.addItem(new ItemStack(ModItems.EMPTY_UNIT.get()));
                    break;
            }

            return InteractionResultHolder.consume(player.getItemInHand(hand));
        }

        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
}

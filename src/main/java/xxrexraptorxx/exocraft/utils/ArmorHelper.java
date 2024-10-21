package xxrexraptorxx.exocraft.utils;

import net.minecraft.ChatFormatting;

public class ArmorHelper {

    public static int getPercentageValue(int max, double min) {
        return (int) Math.round( 100 - (min / max) * 100);
    }


    public static ChatFormatting getDamageColor(int damagePercentage) {
        if (damagePercentage < 5) {
            return ChatFormatting.DARK_RED;

        } else if (damagePercentage < 10) {
            return ChatFormatting.RED;

        } else {
            return ChatFormatting.GRAY;
        }
    }

}

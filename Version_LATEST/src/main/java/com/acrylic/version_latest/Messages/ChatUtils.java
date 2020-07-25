package com.acrylic.version_latest.Messages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.text.DateFormat;
import java.text.Format;

public class ChatUtils {

    private static final HexColor[] BEAUTIFUL_COLORS = HexColor.values();

    /**
     *
     * @param text Input text to transform from. Use the symbol & for colour codes
     * @return Returns the colored text
     */
    public static String get(String text) {
        return ChatColor.translateAlternateColorCodes('&',text);
    }

    /**
     * This is used to showcase the colors provided in the HexCodes
     * enum. Do note that this will only work in 1.16.
     */
    public static void hexCodeTextDisplay() {
        StringBuilder str = new StringBuilder();

        for (HexColor color : BEAUTIFUL_COLORS) {
            str.append(get(color.getHexColored() + Symbols.BOX.getSymbol() + " " + color));
        }
        Bukkit.broadcastMessage(str.toString());
        Bukkit.broadcastMessage("");
    }

    public static String convertToTimeString() {
        return null;
    }

}

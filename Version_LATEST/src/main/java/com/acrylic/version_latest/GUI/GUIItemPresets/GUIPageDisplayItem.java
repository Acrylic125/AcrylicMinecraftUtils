package com.acrylic.version_latest.GUI.GUIItemPresets;

import com.acrylic.version_latest.GUI.GUIPageBuilder;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.LinkedList;
import java.util.List;

/**
 * Please avoid overusing this system!
 *
 * Placeholders usable in lore and name.
 * {PAGE}         : The current page.
 * {TOTAL_PAGE}   : The total amount of pages.
 */
public class GUIPageDisplayItem extends GUIItemPreset {

    public GUIPageDisplayItem(int slot, ItemStack item) {
        super(slot,item);
    }

    public ItemStack getItem(int page, GUIPageBuilder guiPageBuilder) {
        int lastPage = guiPageBuilder.getTotalPages();
        if (page <= 0 || page > lastPage) return null;
        ItemStack item = super.getItem().clone();
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return item;

        List<String> lore = meta.getLore();
        if (lore != null) {
            LinkedList<String> list = new LinkedList<>();
            for (String line : lore) list.add(convert(line,page,lastPage));
            meta.setLore(list);
        }
        if (meta.getDisplayName() != null) meta.setDisplayName(convert(meta.getDisplayName(),page,lastPage));
        item.setItemMeta(meta);
        return item;
    }

    private String convert(String line, int page, int lastPage) {
        return line
                .replace("{PAGE}",page + "")
                .replace("{TOTAL_PAGE}",(lastPage) + "");
    }

}

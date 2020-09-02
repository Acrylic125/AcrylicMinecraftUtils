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
public class GUIPageSelectorItem extends GUIItemPreset {

    private final static String PAGE_IDENTIFIER_TAG = "page";

    private int page = 1;

    public GUIPageSelectorItem(int slot, ItemStack item) {
        super(slot,item);
    }

    public ItemStack getItem(int page, GUIPageBuilder guiPageBuilder) {
        ItemStack item = super.getItem().clone();
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return super.getItem();

        List<String> lore = meta.getLore();
        if (lore != null) {
            LinkedList<String> list = new LinkedList<>();
            lore.forEach(line -> {
                list.add(convert(line,page,guiPageBuilder));
            });
            meta.setLore(list);
        }
        meta.setDisplayName(convert(meta.getDisplayName(),page,guiPageBuilder));

        NBTItem nbtItem = new NBTItem(item);
        nbtItem.setInteger(PAGE_IDENTIFIER_TAG,page);
        item = nbtItem.getItem();
        return item;
    }

    private String convert(String line, int page, GUIPageBuilder guiPageBuilder) {
        return line
                .replace("{CURRENT_PAGE}",page + "")
                .replace("{TOTAL_PAGE}",(guiPageBuilder.getTotalPages()) + "");
    }

}

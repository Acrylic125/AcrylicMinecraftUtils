package com.acrylic.version_latest.GUI.GUIItemPresets;

import com.acrylic.version_latest.GUI.GUIPageBuilder;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.inventory.ItemStack;

/**
 * Please avoid overusing this system!
 *
 * Placeholders usable in lore and name.
 * {CURRENT_PAGE} : The current page.
 * {NEXT_PAGE}    : The next page.
 * {LAST_PAGE}    : The last page.
 */
public class GUIPageSelectorItem extends GUIItemPreset {

    private final static String PAGE_IDENTIFIER_TAG = "page";

    private int page = 1;

    public GUIPageSelectorItem(int slot, ItemStack item) {
        super(slot,item);
    }

    public ItemStack getItem(GUIPageBuilder guiPageBuilder) {
        return super.getItem();
    }

    @Override
    public GUIItemPreset constructNBT() {
        NBTItem nbtItem = new NBTItem(super.item);
        nbtItem.setInteger(PAGE_IDENTIFIER_TAG,page);
        return this;
    }

}

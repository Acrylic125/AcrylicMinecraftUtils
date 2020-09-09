package com.acrylic.version_latest.GUI.GUIItemPresets;

import com.acrylic.version_latest.GUI.GUIExceptions.NotAValidPageSelectorException;
import com.acrylic.version_latest.GUI.GUIPageBuilder;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.inventory.ItemStack;

/**
 * Please avoid overusing this system!
 *
 * Placeholders usable in lore and name.
 * {PAGE}         : The current page.
 * {TOTAL_PAGE}   : The total amount of pages.
 */
public class GUIPageSelectorItem extends GUIPageDisplayItem {

    public enum PageType {
        NEXT, PREVIOUS
    }

    private final static String PAGE_IDENTIFIER_TAG = "page";
    private final PageType pageType;

    public GUIPageSelectorItem(int slot, ItemStack item, PageType pageType) {
        super(slot,item);
        this.pageType = pageType;
    }

    public ItemStack getItem(int page, GUIPageBuilder guiPageBuilder) {
        page = (pageType.equals(PageType.PREVIOUS)) ? page - 1 : (pageType.equals(PageType.NEXT)) ? page + 1 : page;
        ItemStack item = super.getItem(page, guiPageBuilder);
        if (item == null) return null;
        NBTItem nbtItem = new NBTItem(item);
        nbtItem.setInteger(PAGE_IDENTIFIER_TAG,page);
        return nbtItem.getItem();
    }

    public static int getClickedPage(ItemStack item) throws NotAValidPageSelectorException {
        NBTItem nbtItem = new NBTItem(item);
        int page = nbtItem.getInteger(PAGE_IDENTIFIER_TAG);
        if (page <= 0) throw new NotAValidPageSelectorException();
        return page;
    }

}

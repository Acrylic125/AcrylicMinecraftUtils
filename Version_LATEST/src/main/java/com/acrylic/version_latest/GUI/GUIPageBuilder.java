package com.acrylic.version_latest.GUI;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;

/**
 * The first page of the GUI is page 1.
 *
 * This class is designed to be create as a final static,
 * being accessed readily and NOT RECREATED!
 * This is mainly designed so for efficiency reasons.
 *
 * You may recreate this but the system designed in the backend
 * is widely unsupported.
 */
@Getter
public class GUIPageBuilder extends AbstractGUI {

    private final int maxRows;

    private boolean usingMiddleSlotSystem = false;
    private int page = 1;

    public GUIPageBuilder(int initialRow, int chunkSize, int maxRows) {
        super(initialRow, 9, chunkSize);
        this.maxRows = maxRows;
    }

    public GUIPageBuilder(int initialRow, int maxColumns, int chunkSize, int maxRows) {
        super(initialRow, maxColumns, chunkSize);
        this.maxRows = maxRows;
    }

    private int getTotalPages() {
        return (int) Math.floor((float) items.size() / getMaxItemsPerPage()) + 1;
    }

    private int getMaxItemsPerPage() {
        return (maxRows - initialRow + 1) * chunkSize;
    }

    public GUIPageBuilder setPage(int page) {
        this.page = Math.min(page, getTotalPages());
        return this;
    }

    public GUIPageBuilder setUsingMiddleSlot(boolean usingMiddleSlot) {
        this.usingMiddleSlotSystem = usingMiddleSlot;
        return this;
    }

    @Override
    public GUIPageBuilder add(ItemStack item) {
        items.add(item);
        return this;
    }

    @Override
    public void construct() {
        if (inventory == null) return;
        int max = getMaxItemsPerPage();
        int index = (page - 1) * max + 1;
        int lastIndex = page * max;
        lastIndex = Math.min(lastIndex, items.size());
        if (!usingMiddleSlotSystem || page < getTotalPages()) {
            int slot = (int) (((initialRow - 1) * 9) + Math.floor((float) offsetSlot / 2));
            for (int i = index; i <= lastIndex; i++) {
                inventory.setItem(slot,items.get(i - 1));
                if (i % chunkSize == 0) slot += offsetSlot;
                else slot++;
            }
        } else {
            GUIMiddleSlot guiMiddleSlot = new GUIMiddleSlot(inventory,initialRow,chunkSize,maxColumns);
            for (int i = index; i <= lastIndex; i++) {
                guiMiddleSlot.add(items.get(i - 1));
            }
            guiMiddleSlot.construct();
        }
    }


}

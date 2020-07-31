package com.acrylic.version_latest.GUI;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This is a GUI class that makes items centered.
 */
public class GUIMiddleSlot {

    private final ArrayList<ItemStack> items = new ArrayList<>();
    private final Inventory inventory;
    private final int offsetSlot;
    private final int chunkSize;
    private final int initialRow;
    private final int maxColumns;

    /**
     /**
     * This is not for normal chests (9 row GUIs)
     * @param inventory The inventory you want to use to center.
     * @param initialRow The starting row to center the items.
     * @param chunkSize The amount of items per row. Please refrain from using even numbers!
    */
    public GUIMiddleSlot(Inventory inventory, int initialRow, int chunkSize) {
        this.initialRow = initialRow;
        this.chunkSize = chunkSize;
        this.inventory = inventory;
        this.maxColumns = 9;
        this.offsetSlot = maxColumns - chunkSize + 1;
    }

    /**
     * This is not for normal chests (9 row GUIs)
     * @param inventory The inventory you want to use to center.
     * @param initialRow The starting row to center the items.
     * @param chunkSize The amount of items per row. Please refrain from using even numbers!
     * @param maxColumns A specification to the total amount of columns the GUI you are using
     *                   have. (i.e. Chests have 9)
     */
    public GUIMiddleSlot(Inventory inventory, int initialRow, int chunkSize, int maxColumns) {
        this.initialRow = initialRow;
        this.chunkSize = chunkSize;
        this.inventory = inventory;
        this.maxColumns = maxColumns;
        this.offsetSlot = maxColumns - chunkSize + 1;
    }

    public GUIMiddleSlot add(ItemStack item) {
        items.add(item);
        return this;
    }

    /**
     * The math is fairly complex to comprehend. What it does is, it tracks
     * the index of each item. It also clusters the items into sub groups of chunkSize.
     * With a lot of math, it then calculates the offset and the final row, then
     * it uses a simple system to calculate the centered positions.
     *
     * You can ignore the explanation but this method is to construct the GUI.
     */
    public void construct() {
        final int size = items.size();
        final int initialSlot = (int) (maxColumns * (initialRow - 1) + Math.floor((float) offsetSlot / 2) - 1);
        final int lastOffset = (int) ((Math.ceil((float) chunkSize / 2)) - Math.floor(((float) size % chunkSize) / 2));
        final int c = (int) Math.floor((float) size / chunkSize);
        final int target = c * chunkSize;

        final AtomicInteger currentSlot = new AtomicInteger(0);
        final AtomicInteger index = new AtomicInteger(0);
        items.forEach(item -> {
            int i = index.get();
            if (i % chunkSize == 0) {
                if (i == target) {
                    currentSlot.set(c * maxColumns);
                    currentSlot.addAndGet(lastOffset);
                } else if (i != 0) {
                    currentSlot.addAndGet(offsetSlot);
                } else {
                    currentSlot.addAndGet(1);
                }
            } else {
                currentSlot.addAndGet(1);
            }
            index.addAndGet(1);
            inventory.setItem(currentSlot.get() + initialSlot,item);
        });
    }

}

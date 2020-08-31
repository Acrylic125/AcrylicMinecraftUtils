package com.acrylic.version_latest.GUI;

import lombok.Getter;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

@Getter
public abstract class AbstractGUI {

    protected final int chunkSize;
    protected final int initialRow;
    protected final int maxColumns;
    //The offset slot is the amount of slots to the next row.
    protected final int offsetSlot;
    protected final ArrayList<ItemStack> items = new ArrayList<>();

    protected Inventory inventory;

    protected AbstractGUI(int initialRow, int maxColumns, int chunkSize) {
        this.chunkSize = chunkSize;
        this.initialRow = initialRow;
        this.maxColumns = maxColumns;
        offsetSlot = maxColumns - chunkSize + 1;
    }

    public AbstractGUI setInventory(Inventory inventory) {
        this.inventory = inventory;
        return this;
    }

    public abstract AbstractGUI add(ItemStack item);

    public abstract void construct();

}

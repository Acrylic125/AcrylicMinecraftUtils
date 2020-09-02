package com.acrylic.version_latest.GUI;

import com.acrylic.version_latest.GUI.GUIItemPresets.GUIItemPresets;
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

    private GUIItemPresets guiItemPresets;

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

    public AbstractGUI setItemPresets(GUIItemPresets guiItemPresets) {
        this.guiItemPresets = guiItemPresets;
        return this;
    }

    /**
     * Construct with gui item presets.
     */
    public void constructAll() {
        construct();
        if (guiItemPresets != null) guiItemPresets.construct(inventory);
    }

    public abstract AbstractGUI add(ItemStack item);

    /**
     * Construct without gui item presets.
     */
    public abstract void construct();

}
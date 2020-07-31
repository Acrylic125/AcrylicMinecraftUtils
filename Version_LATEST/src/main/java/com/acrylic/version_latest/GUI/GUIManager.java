package com.acrylic.version_latest.GUI;

import com.acrylic.version_latest.Annotations.ForEvents;
import com.acrylic.version_latest.Annotations.NotForEvents;
import com.acrylic.version_latest.Items.ItemCreator;
import com.acrylic.version_latest.Messages.ChatUtils;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class GUIManager {

    @Getter
    private Inventory inventory;
    private String guiName;

    /**
     *
     * @param guiName GUI name
     * @param rows The amount of rows in the GUI
     */
    public GUIManager(String guiName, int rows) {
        this.guiName = ChatUtils.get(guiName);
        inventory = Bukkit.createInventory(null,rows * 9,this.guiName);
    }

    /**
     *
     * @param guiName GUI name
     * @param inventoryType Inventory Type (i.e. Dispenser, Furnace) so no
     *                      slots needed. AVOID USING IT FOR CHESTS!
     */
    public GUIManager(String guiName, InventoryType inventoryType) {
        this.guiName = ChatUtils.get(guiName);
        inventory = Bukkit.createInventory(null, inventoryType,this.guiName);
    }

    /**
     *
     * @param inventory Inventory to modify
     *                  This should be used for events.
     */
    @NotForEvents
    public GUIManager(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     *
     * @param inventoryView inventory player view
     *                  This should be used for events. The inventory variable is defined as the TOP
     *                  inventory. In most cases, the top inventory is used for comparisons.
     */
    @ForEvents
    public GUIManager(InventoryView inventoryView) {
        this.inventory = inventoryView.getTopInventory();
    }

    /**
     *
     * @param p Shows the inventory to the specified player.
     */
    public void show(Player p) {
        p.openInventory(inventory);
    }

    /**
     * Fills up the entire inventory with an item
     */
    public void fill() {
        for (int i = 0;i<=inventory.getSize() - 1;i++) {
            inventory.setItem(i, new ItemCreator(Material.BLACK_STAINED_GLASS_PANE).setItemName("&0").getItem());
        }
    }

    /**
     *
     * @param item Specify an item to fill the entire inventory with.
     */
    public void fill(ItemStack item) {
        for (int i = 0;i<=inventory.getSize() - 1;i++) {
            inventory.setItem(i, item);
        }
    }

}

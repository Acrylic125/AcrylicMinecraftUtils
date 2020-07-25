package com.acrylic.version_latest.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemChecks {

    private Material material;
    private ItemStack item;

    public ItemChecks(ItemStack item) {
        material = item.getType();
        this.item = item;
    }

    


}

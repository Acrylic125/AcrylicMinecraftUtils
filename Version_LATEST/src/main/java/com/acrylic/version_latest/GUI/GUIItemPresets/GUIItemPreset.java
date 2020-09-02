package com.acrylic.version_latest.GUI.GUIItemPresets;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Getter
public class GUIItemPreset {

    private final int slot;
    protected ItemStack item;

    public GUIItemPreset(int slot, ItemStack item) {
        this.slot = slot;
        this.item = item;
    }

}

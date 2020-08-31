package com.acrylic.version_latest.GUI.GUIItemPresets;

import lombok.Getter;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class GUIItemPresets {

    @Getter
    private final ArrayList<GUIItemPreset> itemPresets = new ArrayList<>();

    public GUIItemPresets setItem(GUIItemPreset guiItemPreset) {
        itemPresets.add(guiItemPreset);
        return this;
    }

    public GUIItemPresets clear() {
        itemPresets.clear();
        return this;
    }

    public void construct(Inventory inventory) {
        itemPresets.forEach(guiItemPreset -> {
            inventory.setItem(guiItemPreset.getSlot(),guiItemPreset.getItem());
        });
    }

}

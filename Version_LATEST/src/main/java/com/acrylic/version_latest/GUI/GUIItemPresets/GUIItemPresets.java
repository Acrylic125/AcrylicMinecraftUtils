package com.acrylic.version_latest.GUI.GUIItemPresets;

import com.acrylic.version_latest.GUI.AbstractGUI;
import com.acrylic.version_latest.GUI.GUIPageBuilder;
import lombok.Getter;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public final class GUIItemPresets {

    @Getter
    private final ArrayList<GUIItemPreset> itemPresets = new ArrayList<>();

    public GUIItemPresets setItem(GUIItemPreset guiItemPreset) {
        itemPresets.add(guiItemPreset);
        return this;
    }

    public GUIItemPresets setItem(int slot, ItemStack item) {
        itemPresets.add(new GUIItemPreset(slot, item));
        return this;
    }

    public GUIItemPresets clear() {
        itemPresets.clear();
        return this;
    }

    public void construct(AbstractGUI abstractGUI) {
        final Inventory inventory = abstractGUI.getInventory();
        final GUIPageBuilder guiPageBuilder = (abstractGUI instanceof GUIPageBuilder) ? ((GUIPageBuilder) abstractGUI) : null;
        itemPresets.forEach(guiItemPreset -> {
            if (guiPageBuilder != null && guiItemPreset instanceof GUIPageDisplayItem) {
                ItemStack item = ((GUIPageDisplayItem) guiItemPreset).getItem(guiPageBuilder.getPage(),guiPageBuilder);
                if (item != null) inventory.setItem(guiItemPreset.getSlot(), item);
            }
            else inventory.setItem(guiItemPreset.getSlot(),guiItemPreset.getItem());
        });
    }

    public void construct(Inventory inventory) {
        itemPresets.forEach(guiItemPreset -> {
            inventory.setItem(guiItemPreset.getSlot(),guiItemPreset.getItem());
        });
    }

}

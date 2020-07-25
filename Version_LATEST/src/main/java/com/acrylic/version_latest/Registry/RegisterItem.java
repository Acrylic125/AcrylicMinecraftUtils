package com.acrylic.version_latest.Registry;

import com.acrylic.version_latest.Items.ItemMaker.ItemMaker.ItemMakerInterface;

import java.util.HashMap;
import java.util.Map;

public final class RegisterItem {

    private static final Map<String, ItemMakerInterface> itemMakerMaterialMap = new HashMap<>();

    public static ItemMakerInterface getItem(String item) {
        return itemMakerMaterialMap.get(item);
    }

    public static void register(final ItemMakerInterface itemMakerInterface) {
        itemMakerMaterialMap.put(itemMakerInterface.getItemID().toUpperCase(),itemMakerInterface);
        if (itemMakerInterface.getMaterial() != null && itemMakerInterface.getItemType() != null) {
            RegisterItemType.register(itemMakerInterface.getMaterial(),itemMakerInterface.getItemType());
        }
    }

}

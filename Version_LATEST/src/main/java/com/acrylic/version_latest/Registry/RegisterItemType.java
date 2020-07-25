package com.acrylic.version_latest.Registry;

import com.acrylic.version_latest.Items.ItemMaker.ItemType.ItemType;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public final class RegisterItemType {

    /**
     * Caches.
     */
    private final static Map<Material, ItemType> itemTypeMaterialMap = new HashMap<>();
    private final static Map<String, ItemType> itemTypeStringMap = new HashMap<>();

    /**
     *
     * @param itemType The item type must be given in all CAPS. This is
     *                so there is a form of item type getter without using extremely
     *                costly implementations.
     * @return The specified Item Type.
     */
    public static ItemType getItemType(String itemType) {
        return itemTypeStringMap.get(itemType);
    }
    /**
     *
     * @param itemType Material bound to the item type.
     * @return The specified Item Type.
     */
    public static ItemType getItemType(Material itemType) {
        return itemTypeMaterialMap.get(itemType);
    }

    public static void register(final ItemType itemType) {
        itemTypeStringMap.put(itemType.getItemTypeName().toUpperCase(),itemType);
    }

    public static void register(final Material material, final ItemType itemType) {
        itemTypeMaterialMap.put(material,itemType);
    }



}

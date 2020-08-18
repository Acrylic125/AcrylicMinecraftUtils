package com.acrylic.version_latest.Items.Utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public final class NormalItemTypeManager {

    private final static HashMap<Material, NormalItemType> materialMap = new HashMap<>();

    public static void cache(NormalItemType itemType, Material... materials) {
        for (Material material : materials) {
            materialMap.put(material,itemType);
        }
    }

    public static NormalItemType get(Material material) {
        NormalItemType type = materialMap.get(material);
        return (type == null) ? NormalItemType.OTHER : type;
    }

    public static NormalItemType get(ItemStack item) {
        if (ItemUtils.isAir(item)) return NormalItemType.OTHER;
        NormalItemType type = materialMap.get(item.getType());
        return (type == null) ? NormalItemType.OTHER : type;
    }

}

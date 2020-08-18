package com.acrylic.version_1_8;

import com.acrylic.version_latest.Items.ItemMaker.ItemType.ItemType;
import com.acrylic.version_latest.Items.Utils.NormalItemType;
import com.acrylic.version_latest.Items.Utils.NormalItemTypeManager;
import org.bukkit.Material;

public class NormalItemTypeRegistry_1_8 {

    public static void register() {
        NormalItemTypeManager.cache(NormalItemType.BOW,
                Material.BOW);
        NormalItemTypeManager.cache(NormalItemType.SKULL,
                Material.SKULL, Material.SKULL_ITEM);
        NormalItemTypeManager.cache(NormalItemType.HELMET,
                Material.LEATHER_HELMET, Material.GOLD_HELMET, Material.CHAINMAIL_HELMET, Material.IRON_HELMET, Material.DIAMOND_HELMET);
        NormalItemTypeManager.cache(NormalItemType.CHESTPLATE,
                Material.LEATHER_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.IRON_CHESTPLATE, Material.DIAMOND_CHESTPLATE);
        NormalItemTypeManager.cache(NormalItemType.LEGGINGS,
                Material.LEATHER_LEGGINGS, Material.GOLD_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.IRON_LEGGINGS, Material.DIAMOND_LEGGINGS);
        NormalItemTypeManager.cache(NormalItemType.BOOTS,
                Material.LEATHER_BOOTS, Material.GOLD_BOOTS, Material.CHAINMAIL_BOOTS, Material.IRON_BOOTS, Material.DIAMOND_BOOTS);
        NormalItemTypeManager.cache(NormalItemType.SWORD,
                Material.WOOD_SWORD, Material.STONE_SWORD, Material.GOLD_SWORD, Material.IRON_SWORD, Material.DIAMOND_SWORD);
        NormalItemTypeManager.cache(NormalItemType.AXE,
                Material.WOOD_AXE, Material.STONE_AXE, Material.GOLD_AXE, Material.IRON_AXE, Material.DIAMOND_AXE);
        NormalItemTypeManager.cache(NormalItemType.PICKAXE,
                Material.WOOD_PICKAXE, Material.STONE_PICKAXE, Material.GOLD_PICKAXE, Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE);
        NormalItemTypeManager.cache(NormalItemType.SHOVEL,
                Material.WOOD_SPADE, Material.STONE_SPADE, Material.GOLD_SPADE, Material.IRON_SPADE, Material.DIAMOND_SPADE);
        NormalItemTypeManager.cache(NormalItemType.HOE,
                Material.WOOD_HOE, Material.STONE_HOE, Material.GOLD_HOE, Material.IRON_HOE, Material.DIAMOND_HOE);
    }

}

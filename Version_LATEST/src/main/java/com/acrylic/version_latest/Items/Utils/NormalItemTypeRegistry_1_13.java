package com.acrylic.version_latest.Items.Utils;

import org.bukkit.Material;

public class NormalItemTypeRegistry_1_13 {

    public static void register() {
        NormalItemTypeManager.cache(NormalItemType.BOW,
                Material.BOW);
        NormalItemTypeManager.cache(NormalItemType.SKULL,
                Material.SKELETON_WALL_SKULL, Material.SKELETON_SKULL, Material.WITHER_SKELETON_SKULL, Material.WITHER_SKELETON_WALL_SKULL, Material.CREEPER_HEAD, Material.CREEPER_WALL_HEAD, Material.DRAGON_HEAD, Material.DRAGON_WALL_HEAD, Material.PLAYER_HEAD, Material.PLAYER_WALL_HEAD, Material.ZOMBIE_HEAD, Material.ZOMBIE_WALL_HEAD);
        NormalItemTypeManager.cache(NormalItemType.HELMET,
                Material.LEATHER_HELMET, Material.GOLDEN_HELMET, Material.CHAINMAIL_HELMET, Material.IRON_HELMET, Material.DIAMOND_HELMET, Material.TURTLE_HELMET);
        NormalItemTypeManager.cache(NormalItemType.CHESTPLATE,
                Material.LEATHER_CHESTPLATE, Material.GOLDEN_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.IRON_CHESTPLATE, Material.DIAMOND_CHESTPLATE,Material.ELYTRA);
        NormalItemTypeManager.cache(NormalItemType.LEGGINGS,
                Material.LEATHER_LEGGINGS, Material.GOLDEN_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.IRON_LEGGINGS, Material.DIAMOND_LEGGINGS);
        NormalItemTypeManager.cache(NormalItemType.BOOTS,
                Material.LEATHER_BOOTS, Material.GOLDEN_BOOTS, Material.CHAINMAIL_BOOTS, Material.IRON_BOOTS, Material.DIAMOND_BOOTS);
        NormalItemTypeManager.cache(NormalItemType.SWORD,
                Material.WOODEN_SWORD, Material.STONE_SWORD, Material.GOLDEN_SWORD, Material.IRON_SWORD, Material.DIAMOND_SWORD);
        NormalItemTypeManager.cache(NormalItemType.AXE,
                Material.WOODEN_AXE, Material.STONE_AXE, Material.GOLDEN_AXE, Material.IRON_AXE, Material.DIAMOND_AXE);
        NormalItemTypeManager.cache(NormalItemType.PICKAXE,
                Material.WOODEN_PICKAXE, Material.STONE_PICKAXE, Material.GOLDEN_PICKAXE, Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE);
        NormalItemTypeManager.cache(NormalItemType.SHOVEL,
                Material.WOODEN_SHOVEL, Material.STONE_SHOVEL, Material.GOLDEN_SHOVEL, Material.IRON_SHOVEL, Material.DIAMOND_SHOVEL);
        NormalItemTypeManager.cache(NormalItemType.HOE,
                Material.WOODEN_HOE, Material.STONE_HOE, Material.GOLDEN_HOE, Material.IRON_HOE, Material.DIAMOND_HOE);
    }

}

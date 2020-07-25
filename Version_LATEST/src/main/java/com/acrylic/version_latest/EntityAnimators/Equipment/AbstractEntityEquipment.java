package com.acrylic.version_latest.EntityAnimators.Equipment;

import org.bukkit.inventory.ItemStack;

/**
 * This is just to make equipping entities easy... Because
 * Bukkit is fucking dumb.
 */
public interface AbstractEntityEquipment {

    AbstractEntityEquipment setItemInMainHand(ItemStack item);

    AbstractEntityEquipment setHelmet(ItemStack item);

    AbstractEntityEquipment setChestplate(ItemStack item);

    AbstractEntityEquipment setLeggings(ItemStack item);

    AbstractEntityEquipment setBoots(ItemStack item);

    AbstractEntityEquipment getInstance();

}

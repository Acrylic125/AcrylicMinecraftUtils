package com.acrylic.version_latest.Events.ArmorEquipEvent;

/**
 * The ways players can equip armour.
 * PHYSICAL:  Right Click (Supports hotswap) Use the method event.isHotSwap to check if it is
 *            hotswap.
 * INVENTORY: Inventory based checks.
 * DISPENSER: Dispenser based check.
 * LOGIN:     This is not caused by a normal event! Do a simple check if you do not want to
 *            refresh the armor change event upon login.
 * CUSTOM:    This is not caused by a normal event! This is caused by a custom mean.
 */
public enum ArmorEquipType {

    PHYSICAL,
    INVENTORY,
    DISPENSER,
    LOGIN,
    ITEM_BREAK,
    DEATH,
    CUSTOM;

}

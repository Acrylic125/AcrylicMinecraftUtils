package com.acrylic.version_latest.Items.ItemMaker.ItemType;

/**
 * Implement this interface to create an item type class.
 * Alternatively, you can use ItemMainType to have a collection of
 * ItemTypes within one ItemType. For example, 'Armor' can be used to
 * classify 'Helmet', 'Chestplate', 'Leggings', and 'Boots'.
 *
 * You MUST register the item type.
 */
public interface ItemType {

    String getItemTypeName();

}

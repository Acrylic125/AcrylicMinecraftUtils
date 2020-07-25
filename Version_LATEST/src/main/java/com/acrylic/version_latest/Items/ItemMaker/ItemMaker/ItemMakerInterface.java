package com.acrylic.version_latest.Items.ItemMaker.ItemMaker;

import com.acrylic.version_latest.Items.ItemMaker.ItemType.ItemType;
import org.bukkit.Material;

public interface ItemMakerInterface {

    /**
     *
     * @return This is a string identifier for the item.
     */
    String getItemID();

    /**
     *
     * @return The identifying material that is bound to this item.
     * Put 'null' if there is no real material bound. This is used to identify
     * an item type from a material.
     *
     * For example, the material MATERIAL.IRON_SWORD can be returned
     * which will be used to identify Iron_Sword item type.
     */
    Material getMaterial();

    /**
     *
     * @return The item type of the item. Specify 'null' i there is no item type
     * that defines this item.
     */
    ItemType getItemType();

}

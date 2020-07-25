package com.acrylic.version_latest.EnchantAPI.Creator;

import com.acrylic.version_latest.Items.ItemMaker.ItemType.ItemType;

import java.util.List;

public interface CustomEnchant {

    /**
     *
     * @return The enchant name (Excludes color code)
     */
    String getName();

    /**
     *
     * @return The enchant description (Excludes color code)
     */
    String[] getDescription();

    /**
     *
     * @return The highest level of the enchant that can be obtained
     *        legitamately.
     */
    int getMaxLevel();

    /**
     *
     * @return The enchant rarity.
     */
    EnchantRarity getRarity();

    /**
     *
     * @return Retrieves the list of applicable items (This uses
     *          the custom ItemMaker/ItemTypeMaker.
     */
    List<ItemType> getApplicable();


}

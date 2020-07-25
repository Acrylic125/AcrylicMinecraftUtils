package com.acrylic.version_latest.Items.ItemMaker.Test;


import com.acrylic.version_latest.Items.ItemMaker.ItemType.ItemMainType;
import com.acrylic.version_latest.Items.ItemMaker.ItemType.ItemType;
import com.acrylic.version_latest.Items.ItemMaker.Test.Helmet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * This is an example and a global item type that can be used
 * as a reference to all item types.
 */
public class ItemTypeALL implements ItemMainType {

    @Override
    public String getItemTypeName() {
        return "ALL";
    }

    @Override
    public List<ItemType> getItemTypes() {
        return Arrays.asList(new ItemType[]{new Helmet()});
    }
}

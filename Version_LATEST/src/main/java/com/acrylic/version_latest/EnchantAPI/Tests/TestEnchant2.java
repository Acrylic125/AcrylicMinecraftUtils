package com.acrylic.version_latest.EnchantAPI.Tests;

import com.acrylic.version_latest.EnchantAPI.AbstractEnchant;
import com.acrylic.version_latest.EnchantAPI.Creator.CustomEnchant;
import com.acrylic.version_latest.EnchantAPI.Creator.EnchantRarity;
import com.acrylic.version_latest.Items.ItemMaker.ItemType.ItemType;
import com.acrylic.version_latest.Items.ItemMaker.Test.ItemTypeALL;

import java.util.Arrays;
import java.util.List;

public class TestEnchant2 extends AbstractEnchant implements CustomEnchant {

    @Override
    public void activate() {

    }

    @Override
    public String getName() {
        return "TestEnchant2";
    }

    @Override
    public String[] getDescription() {
        return new String[]{
            "This is just a sample description.", "Hello there!", "No!"
        };
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public EnchantRarity getRarity() {
        return new SampleRarity2();
    }

    @Override
    public List<ItemType> getApplicable() {
        return Arrays.asList(new ItemType[]{ new ItemTypeALL()});
    }


}

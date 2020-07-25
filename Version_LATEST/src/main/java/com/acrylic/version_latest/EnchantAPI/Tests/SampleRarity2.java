package com.acrylic.version_latest.EnchantAPI.Tests;

import com.acrylic.version_latest.EnchantAPI.Creator.EnchantRarity;

public class SampleRarity2 implements EnchantRarity {
    @Override
    public byte getTier() {
        return 2;
    }

    @Override
    public String getColor() {
        return "&5";
    }

    @Override
    public String getName() {
        return "Rare";
    }
}

package com.acrylic.version_latest.EnchantAPI.Tests;

import com.acrylic.version_latest.EnchantAPI.Creator.EnchantRarity;

public class SampleRarity implements EnchantRarity {
    @Override
    public byte getTier() {
        return 1;
    }

    @Override
    public String getColor() {
        return "&d";
    }

    @Override
    public String getName() {
        return "Common";
    }
}

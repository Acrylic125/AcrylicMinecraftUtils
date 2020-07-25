package com.acrylic.version_latest.EnchantAPI.Exceptions;

public class InvalidEnchantAction extends Exception{

    @Override
    public String toString() {
        return "The enchant does not have this method overridden (@Overide).";
    }
}

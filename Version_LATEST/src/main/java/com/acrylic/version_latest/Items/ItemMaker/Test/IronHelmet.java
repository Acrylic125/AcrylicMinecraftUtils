package com.acrylic.version_latest.Items.ItemMaker.Test;

import com.acrylic.version_latest.Items.ItemMaker.ItemMaker.EquipmentWeaponInterface;
import com.acrylic.version_latest.Items.ItemMaker.ItemType.ItemType;
import com.acrylic.version_latest.Items.MainItemTypes;
import org.bukkit.Material;

public class IronHelmet implements EquipmentWeaponInterface {
    @Override
    public double getDamage() {
        return 0;
    }

    @Override
    public double getDMaxDurability() {
        return 0;
    }

    @Override
    public ItemType getItemType() {
        return new Helmet();
    }

    @Override
    public String getItemID() {
        return "IRON_HELMET";
    }

    @Override
    public Material getMaterial() {
        return null;
    }

}

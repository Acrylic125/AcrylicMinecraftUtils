package com.acrylic.version_latest.Items.Utils;

public enum NormalItemType {

    SKULL,
    HELMET,
    CHESTPLATE,
    LEGGINGS,
    BOOTS,
    SWORD,
    AXE,
    BOW,
    PICKAXE,
    SHOVEL,
    HOE,
    OTHER;

    public boolean isArmor() {
        return this.equals(HELMET) || this.equals(CHESTPLATE) || this.equals(LEGGINGS) || this.equals(BOOTS);
    }

    public boolean isWeapon() {
        return this.equals(SWORD) || this.equals(AXE) || this.equals(BOW);
    }

    public boolean isTool() {
        return this.equals(PICKAXE) || this.equals(AXE) || this.equals(SHOVEL) || this.equals(HOE);
    }

    public int getArmorSlot() {
        if (this.equals(HELMET)) return 5;
        else if (this.equals(CHESTPLATE)) return 6;
        else if (this.equals(LEGGINGS)) return 7;
        else if (this.equals(BOOTS)) return 8;
        else return -1;
    }

}

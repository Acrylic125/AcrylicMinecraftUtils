package com.acrylic.version_latest.Items;

public enum MainItemTypes {

    HELMET,
    CHESTPLATE,
    LEGGINGS,
    BOOTS,

    SWORD,
    AXE,
    BOW,

    PICKAXE,
    SHOVEL,
    HOE;

    public boolean isArmor() {
        return this.equals(HELMET) ||
                this.equals(CHESTPLATE) ||
                this.equals(LEGGINGS) ||
                this.equals(BOOTS);
    }

    public boolean isWeapon() {
        return this.equals(SWORD) ||
                this.equals(AXE) ||
                this.equals(BOW);
    }

    public boolean isMeleeWeapon() {
        return this.equals(SWORD) ||
                this.equals(AXE);
    }

    public boolean isTool() {
        return this.equals(PICKAXE) ||
                this.equals(SHOVEL) ||
                this.equals(HOE) ||
                this.equals(AXE);
    }

}

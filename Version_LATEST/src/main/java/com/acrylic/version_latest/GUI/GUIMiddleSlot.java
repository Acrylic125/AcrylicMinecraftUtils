package com.acrylic.version_latest.GUI;

public class GUIMiddleSlot {

    private final int initialRow;
    private final int middleOffsetPerRow;
    private final int initialSlot;

    public GUIMiddleSlot(int initialSlot) {
        initialSlot++;
        middleOffsetPerRow = initialSlot % 9;
        this.initialSlot = initialSlot;
        initialRow = (int) Math.floor((float) initialSlot / 9);
    }

    public int getSlot(int index) {
        int offset = (index % 2 == 0) ? index / 2 : index / -2;
        int s = initialSlot + offset;
        return s;
    }

}

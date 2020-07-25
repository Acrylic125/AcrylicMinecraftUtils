package com.acrylic.acrylicutils.Versions;

public enum Version {

    VERSION_1_8(0),
    VERSION_LATEST(1);

    private final int id;

    Version(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

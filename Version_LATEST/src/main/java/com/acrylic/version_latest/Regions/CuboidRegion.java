package com.acrylic.version_latest.Regions;

import org.bukkit.Location;

public class CuboidRegion extends AbstractRegion {

    public CuboidRegion(Location center) {
        super(center);
    }

    @Override
    public double getDistance(Location location) {
        return 0;
    }

    @Override
    public boolean pointIsWithinRegion(Location location) {
        return false;
    }
}

package com.acrylic.version_latest.Regions;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

@Getter @Setter
public abstract class AbstractRegion {

    private Location center;

    public AbstractRegion(Location center) {
        this.center = center;
    }

    public AbstractRegion(String abstractRegionString) {
        this.center = center;
    }

    public abstract double getDistance(Location location);

    public abstract boolean pointIsWithinRegion(Location location);



}

package com.acrylic.version_latest.Utils.LocationObjects;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class SimpleLocation extends SimpleRawLocation {

    private final float yaw;
    private final float pitch;

    public SimpleLocation(Location location) {
        super(location);
        this.yaw = location.getYaw();
        this.pitch = location.getPitch();
    }

    @Override
    public Location getLocation() {
        return new Location(Bukkit.getWorld(super.getWorld()),super.getX(),super.getY(),super.getZ(),yaw,pitch);
    }
}

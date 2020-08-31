package com.acrylic.version_latest.Utils.LocationObjects;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;

@Getter
public class SimpleRawLocation {

    private final float x;
    private final float y;
    private final float z;

    private final String world;

    public SimpleRawLocation(Location location) {
        this.x = (float) location.getX();
        this.y = (float) location.getY();
        this.z = (float) location.getZ();
        world = location.getWorld().getName();
    }

    public Location getLocation() {
        return new Location(Bukkit.getWorld(world), x,y,z);
    }

    public Block getBlock() {
        return new Location(Bukkit.getWorld(world), x,y,z).getBlock();
    }

}

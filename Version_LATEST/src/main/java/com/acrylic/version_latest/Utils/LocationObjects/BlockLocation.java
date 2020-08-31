package com.acrylic.version_latest.Utils.LocationObjects;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;

@Getter
public class BlockLocation {

    private final int x;
    private final int y;
    private final int z;

    private final String world;

    public BlockLocation(Block block) {
        this.x = block.getX();
        this.y = block.getY();
        this.z = block.getZ();
        world = block.getWorld().getName();
    }

    public Location getLocation() {
        return new Location(Bukkit.getWorld(world), x,y,z);
    }

    public Block getBlock() {
        return new Location(Bukkit.getWorld(world), x,y,z).getBlock();
    }

}

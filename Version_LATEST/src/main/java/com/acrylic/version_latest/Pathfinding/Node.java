package com.acrylic.version_latest.Pathfinding;

import org.bukkit.Location;

public class Node {

    private final float fCost;
    private final Location loc;

    private Location parent;

    public Node(Location loc, float fCost, Location parent) {
        this.fCost = fCost;
        this.loc = loc;
        this.parent = parent;
    }

    public Location getLoc() {
        return loc;
    }

    public Location getParent() {
        return parent;
    }

    public float getfCost() {
        return fCost;
    }
}

package com.acrylic.version_latest.Shapes.Lines;

import lombok.Getter;
import org.bukkit.Location;

@Getter
public class DifferencePoint {

    private float dx;
    private float dy;
    private float dz;

    public DifferencePoint(Location location1,Location location2, int amount) {
        dx = (float) ((location2.getX() - location1.getX()) / amount);
        dy = (float) ((location2.getY() - location1.getY()) / amount);
        dz = (float) ((location2.getZ() - location1.getZ()) / amount);
    }


}

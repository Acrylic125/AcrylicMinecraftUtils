package com.acrylic.version_latest.Shapes.Lines;

import lombok.Getter;
import org.bukkit.Location;

/**
 * This class is used for general lines
 */
@Getter
public abstract class Lines {

    protected final int amount;

    protected final Location location1;
    protected final Location location2;

    protected final float X;
    protected final float Y;
    protected final float Z;

    protected abstract Location getLocation(int index);

    protected abstract Location getLocationFromEnd(int index);

    public Lines(Location location1, Location location2, int amount) {
        this.location1 = location1;
        this.location2 = location2;

        this.X = (float) location1.getX();
        this.Y = (float) location1.getY();
        this.Z = (float) location1.getZ();

        this.amount = amount;
    }

    public Lines(Location location1, Location location2) {
        this(location1,location2,(int) (location1.distance(location2) * 2));
    }


}

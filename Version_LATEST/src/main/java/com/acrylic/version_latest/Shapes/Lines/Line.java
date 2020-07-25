package com.acrylic.version_latest.Shapes.Lines;

import org.bukkit.Location;

public class Line extends Lines {

    private DifferencePoint differencePoint;

    public Line(Location location1, Location location2, int amount) {
        super(location1, location2, amount);
        differencePoint = new DifferencePoint(location1,location2,getAmount());
    }

    public Line(Location location1, Location location2) {
        super(location1, location2);
        differencePoint = new DifferencePoint(location1,location2,getAmount());
    }

    @Override
    public Location getLocation(int index) {
        return location1.clone().add((differencePoint.getDx() * index),(differencePoint.getDy()  * index),(differencePoint.getDz()  * index));
    }

    @Override
    public Location getLocationFromEnd(int index) {
        return location2.clone().add((differencePoint.getDx() * -index),(differencePoint.getDy()  * -index),(differencePoint.getDz()  * -index));
    }

}

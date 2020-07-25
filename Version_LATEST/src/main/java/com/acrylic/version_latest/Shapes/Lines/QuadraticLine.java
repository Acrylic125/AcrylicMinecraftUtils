package com.acrylic.version_latest.Shapes.Lines;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class QuadraticLine extends Lines {

    private DifferencePoint differencePoint;
    private final float heightOffsetMultiplier;
    private float distance;

    public QuadraticLine(Location location1, Location location2, int amount, float heightOffsetMultiplier) {
        super(location1, location2, amount);
        differencePoint = new DifferencePoint(location1,location2,getAmount());
        this.heightOffsetMultiplier = heightOffsetMultiplier;
        setup();
    }

    public QuadraticLine(Location location1, Location location2, float heightOffsetMultiplier) {
        super(location1, location2);
        differencePoint = new DifferencePoint(location1,location2,getAmount());
        this.heightOffsetMultiplier = heightOffsetMultiplier;
        setup();
    }

    private void setup() {
        Location tempLoc = location1.clone();
        tempLoc.setY(location2.getY());
        distance = (float) location2.distance(tempLoc);
    }

    private float getYOffset(int index) {
        float i = 2 * (index / distance);
        Bukkit.broadcastMessage((i * (i - distance) * heightOffsetMultiplier) + " " + distance + " " + i);
        return (i * (i - distance) * heightOffsetMultiplier);
    }

    @Override
    public Location getLocation(int index) {
        return location1.clone().add((differencePoint.getDx() * index),(differencePoint.getDy() * index) + getYOffset(index) ,(differencePoint.getDz() * index));
    }

    @Override
    public Location getLocationFromEnd(int index) {
        return location2.clone().add((differencePoint.getDx() * -index),(differencePoint.getDy() * -index) + getYOffset((int) (distance - index)),(differencePoint.getDz() * -index));
    }

}

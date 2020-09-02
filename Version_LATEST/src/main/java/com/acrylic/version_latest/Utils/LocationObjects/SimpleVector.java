package com.acrylic.version_latest.Utils.LocationObjects;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

/**
 * Why this implementation?
 * This class is intentionally designed to be a more simplified version of
 * Bukkit's Vector implementation.
 * Additionally, this removes the need to clone vectors as this is immutable.
 */
@Getter @Setter
public final class SimpleVector {

    private final static float RADIAN_CONSTANT = (float) (Math.PI / 180);

    private double x;
    private double y;
    private double z;

    public SimpleVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public SimpleVector(Vector vector) {
        adapt(vector);
    }

    public SimpleVector getRadians() {
        return new SimpleVector(x,y,z).toRadians();
    }

    public SimpleVector getDegrees() {
        return new SimpleVector(x,y,z).toDegrees();
    }

    public SimpleVector add(SimpleVector simpleVector) {
        x += simpleVector.getX();
        y += simpleVector.getY();
        z += simpleVector.getZ();
        return this;
    }

    public SimpleVector subtract(SimpleVector simpleVector) {
        x -= simpleVector.getX();
        y -= simpleVector.getY();
        z -= simpleVector.getZ();
        return this;
    }

    public SimpleVector add(double x, double y, double z) {
        this.x += z;
        this.y += y;
        this.z += z;
        return this;
    }

    public SimpleVector add(double number) {
        return add(number,number,number);
    }

    public SimpleVector subtract(double number) {
        return add(-number);
    }

    public SimpleVector multiply(float multiplier) {
        x *= multiplier;
        y *= multiplier;
        z *= multiplier;
        return this;
    }

    public SimpleVector divide(float divisor) {
        return multiply(1 / divisor);
    }

    public SimpleVector toRadians() {
        x *= RADIAN_CONSTANT;
        y *= RADIAN_CONSTANT;
        z *= RADIAN_CONSTANT;
        return this;
    }

    public SimpleVector toDegrees() {
        x /= RADIAN_CONSTANT;
        y /= RADIAN_CONSTANT;
        z /= RADIAN_CONSTANT;
        return this;
    }

    public SimpleVector adapt(Vector vector) {
        this.x = vector.getX();
        this.y = vector.getY();
        this.z = vector.getZ();
        return this;
    }

    public Vector getBukkitVector() {
        return new Vector(x,y,z);
    }

    public Location getLocation(World world) {
        return new Location(world,x,y,z);
    }

    public String toString() {
        return x + ", " + y + ", " + z;
    }

}

package com.acrylic.version_latest.Shapes;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Circle extends Shapes{

    private float cosThetaYaw;
    private float sinThetaYaw;
    private float rad;

    /**
     * Both the costTheta and sinTheta are dynamic, meaning it will change
     * when the circle location changes.
     *
     * This is so there would not be a need to recalculate the sin and cos
     * of both values.
     */
    @Getter
    private float cosTheta;
    @Getter
    private float sinTheta;


    public Circle(float radius, Location center, float amount) {
        super(radius, center,amount);
        setup();
    }
    
    public Circle(float radius, Location center, float yaw, float amount) {
        super(radius, center, yaw, amount);
        setup();
    }

    private void setup() {
        rad = (float) Math.toRadians((360 / amount));
        cosThetaYaw = (float) Math.cos(yaw);
        sinThetaYaw = (float) Math.sin(yaw);
    }

    public Location getVerticalCirclePoint(int index) {
        Location location = center;
        cosTheta = (float) (Math.cos(rad * index));
        sinTheta = (float) (Math.sin(rad * index));

        location.setX((radius * cosTheta * cosThetaYaw) + super.getCenterX());
        location.setY((radius * sinTheta) + super.getCenterY());
        location.setZ((radius * cosTheta * sinThetaYaw) + super.getCenterZ());
        return location;
    }

    public Location getCirclePoint(int index) {
        Location location = center;
        cosTheta = (float) (Math.cos(rad * index + yaw - (Math.PI / 2)));
        sinTheta = (float) (Math.sin(rad * index + yaw - (Math.PI / 2)));

        location.setX((radius * cosTheta) + super.getCenterX());
        location.setZ((radius * sinTheta) + super.getCenterZ());
        return location;
    }
}

package com.acrylic.version_latest.Shapes;

import org.bukkit.Location;

public class Square extends Shapes{
    protected Square(float radius, Location center, float amount) {
        super(radius, center, amount);
    }

    protected Square(float radius, Location center, float yaw, float amount) {
        super(radius, center, yaw, amount);
    }
}

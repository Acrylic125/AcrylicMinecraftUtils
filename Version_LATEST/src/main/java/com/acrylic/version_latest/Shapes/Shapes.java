package com.acrylic.version_latest.Shapes;

import lombok.Getter;
import org.bukkit.Location;

/**
 * This class is used for general shapes
 */
public class Shapes {

    protected final float radius;
    protected final Location center;
    protected final float yaw;
    protected final float amount;

    @Getter
    private float centerX;
    @Getter
    private float centerY;
    @Getter
    private float centerZ;

    protected Shapes(float radius, Location center, float amount) {
        this.center = center;
        this.radius = radius;
        this.yaw = 0;
        this.amount = amount;
        setup();
    }

    protected Shapes(float radius, Location center, float yaw, float amount) {
        this.center = center;
        this.radius = radius;
        this.yaw = (float) Math.toRadians(getFixedYaw(yaw));
        this.amount = amount;
        setup();
    }

    private void setup() {
        this.centerX = (float) center.getX();
        this.centerY = (float) center.getY();
        this.centerZ = (float) center.getZ();
    }

    /**
     *
     * @param yaw Bukkit shit ass yaw
     * @return Returns the correct yaw from N=0
     */
    private float getFixedYaw(float yaw) {
        yaw = (yaw - 90.0F) % 360.0F;
        if (yaw < 0.0D) {
            yaw += 360.0D;
        }
        yaw -= 90;
        return yaw;
    }
}

package com.acrylic.version_latest.Utils.Directions;

import org.bukkit.util.Vector;

public class Direction {

    public static float getYaw(Vector vector) {
        float yaw = (float) Math.toDegrees(Math.atan2(vector.getZ(), vector.getX()));
        return yaw + 180;
    }

    public static DirectionEnum getDirection(Vector vector) {
        final float yaw = getYaw(vector);
        for (DirectionEnum directionEnum : DirectionEnum.values()) {
            float baseYaw = directionEnum.getAngle1();
            float upperYaw = directionEnum.getAngle2();

            if (baseYaw < 0) {
                if (yaw > (360 + baseYaw) || yaw <= upperYaw) {
                    return directionEnum;
                }
            } else if (upperYaw > 360) {
                if (yaw > baseYaw || yaw <= (upperYaw - 360)) {
                    return directionEnum;
                }
            } else if (yaw > baseYaw && yaw <= upperYaw) {
                return directionEnum;
            }
        }
        return null;
    }
}

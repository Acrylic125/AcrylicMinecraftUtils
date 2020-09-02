package com.acrylic.version_latest.Animations;

import com.acrylic.version_latest.EntityAnimators.EntityAnimator;
import com.acrylic.version_latest.Utils.Teleport;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.EulerAngle;

public class HeadRotatorAnimation extends AbstractAnimations {

    private final static EulerAngle TILTED_EULER_ANGLE = new EulerAngle(-0.7, 0, 0);
    private final static float DEFAULT_ROTATION = 15;

    private float rotation = DEFAULT_ROTATION;
    private int index = 0;

    public HeadRotatorAnimation(EntityAnimator entityAnimator) {
        super(entityAnimator);
    }

    public HeadRotatorAnimation(LivingEntity entity) {
        super(entity);
    }

    public HeadRotatorAnimation setRotation(float rotation) {
        this.rotation = rotation;
        return this;
    }

    public HeadRotatorAnimation setTilted() {
        if (entity instanceof ArmorStand) {
            ((ArmorStand) entity).setHeadPose(TILTED_EULER_ANGLE);
        }
        return this;
    }

    public HeadRotatorAnimation setTilted(EulerAngle eulerAngle) {
        if (entity instanceof ArmorStand) {
            ((ArmorStand) entity).setHeadPose(eulerAngle);
        }
        return this;
    }

    @Override
    public Location getLocation() {
        return entity.getLocation();
    }

    @Override
    public void teleport(Location location) {
        float yaw = (rotation * index);
        location.setYaw(yaw);
        Teleport.tp(entity,location);
        index++;
    }
}

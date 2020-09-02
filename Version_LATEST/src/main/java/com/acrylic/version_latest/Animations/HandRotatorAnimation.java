package com.acrylic.version_latest.Animations;

import com.acrylic.version_latest.Animations.Exceptions.UnsupportedEntityType;
import com.acrylic.version_latest.EntityAnimators.EntityAnimator;
import com.acrylic.version_latest.Shapes.Circle;
import com.acrylic.version_latest.Utils.Teleport;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

/**
 * This is an animation class.
 *
 * Rundown on how this works:
 * ARMOR STANDS:
 * Armor stands will rotate about point with an arm
 * euler angle of DANGLE_EULER_ANGLE. This causes the item
 * the entity is holding to look like it is rotating about
 * it's center.
 *
 * GIANT:
 * Similar to armor stands, however, it requires an offset
 * vector to help achieve a similar outcome. Otherwise it will
 * look as if the item the giant is holding spins about the closest
 * vertex of the item.
 */

public class HandRotatorAnimation extends AbstractAnimations {

    private final static EulerAngle DANGLE_EULER_ANGLE = new EulerAngle(-1.75, -0.7, 0);

    private Location location;
    private int index = 0;

    /**
     * NMS SUPPORT!
     * @param entity The NMS entity you want to use with this
     *               system.
     */
    public HandRotatorAnimation(LivingEntity entity) {
        super(entity);
        this.location = entity.getLocation();
    }

    public HandRotatorAnimation(EntityAnimator entityAnimator) {
        super(entityAnimator);
        this.location = entity.getLocation();
        if (entity.getType().equals(EntityType.ARMOR_STAND)) {
            ArmorStand as = (ArmorStand) entity;
            as.setArms(false);
            as.setRightArmPose(DANGLE_EULER_ANGLE);
        }
    }

    @Override
    public void teleport(final Location location) {
        this.location = location.clone();
        index++;
        Circle circle = new Circle(armLength, location, 32);
        Location loc = circle.getCirclePoint(index);
        Vector difference = this.location.toVector().subtract(loc.toVector());
        if (entity.getType().equals(EntityType.GIANT)) {
            loc.add(2 * circle.getSinTheta(), 0, - 2 * circle.getCosTheta());  //Offset Vector.
        }
        loc.setDirection(difference);
        Teleport.tp(entity,loc);
    }

    @Override
    public Location getLocation() {
        return location;
    }


}

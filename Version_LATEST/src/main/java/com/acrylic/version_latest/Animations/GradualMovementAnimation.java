package com.acrylic.version_latest.Animations;

import com.acrylic.version_latest.EntityAnimators.EntityAnimator;
import com.acrylic.version_latest.Shapes.Circle;
import com.acrylic.version_latest.Utils.LocationObjects.SimpleVector;
import com.acrylic.version_latest.Utils.StringConverters.LocationString;
import com.acrylic.version_latest.Utils.Teleport;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

@Getter
public class GradualMovementAnimation extends AbstractAnimations {

    private final AbstractAnimations animation;
    private final int gradualCount;

    private int index = 0;

    public GradualMovementAnimation(AbstractAnimations animation, int gradualCount) {
        super(animation.getEntity());
        this.animation = animation;
        this.gradualCount = gradualCount;
    }

    public GradualMovementAnimation(EntityAnimator entityAnimator, int gradualCount) {
        super(entityAnimator);
        this.animation = null;
        this.gradualCount = gradualCount;
    }

    public GradualMovementAnimation(LivingEntity entity, int gradualCount) {
        super(entity);
        this.animation = null;
        this.gradualCount = gradualCount;
    }

    private void tp(Location location) {
        if (animation != null) animation.teleport(location);
        else entity.teleport(location);
    }

    @Override
    public void teleport(Location location) {
        if (index > gradualCount) {
            tp(location);
            return;
        }
        SimpleVector current = new SimpleVector(getLocation().toVector());
        SimpleVector diff = new SimpleVector(location.toVector())
                .subtract(current)
                .divide((float) gradualCount)
                ;
        current.add(diff);
        tp(current.getLocation(location.getWorld()));
        index++;
    }

    @Override
    public Location getLocation() {
        return (animation == null) ? entity.getLocation() : animation.getLocation();
    }
}

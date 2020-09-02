package com.acrylic.version_latest.Animations;

import com.acrylic.version_latest.Animations.Exceptions.UnsupportedEntityType;
import com.acrylic.version_latest.EntityAnimators.EntityAnimator;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.LivingEntity;

/**
 * Within the whole animation system, NMS entities ARE NOT FULLY SUPPORTED!
 * The alternative is to use the entity methods (i.e. .setHologram(ArmorStand... hologram)).
 */
@Getter
public abstract class AbstractAnimations {

    protected LivingEntity entity;
    protected Holograms holograms;
    protected float armLength; //Arm length
    protected float height; //The height is NOT the entity's height but the Y OFFSET of the holograms based on the entity/

    public AbstractAnimations(EntityAnimator entityAnimator) {
        entity = entityAnimator.getEntity();
        setup();
    }

    public AbstractAnimations(LivingEntity entity) {
        this.entity = entity;
        setup();
    }

    public void setHologram(String... hologram) {
        holograms = new Holograms(entity.getLocation(),height,hologram);
    }

    public void setHologram(Holograms holograms) {
        this.holograms = holograms;
    }

    /**
     * This makes use of NMS entities.
     * @param hologram
     */
    public void setHologram(ArmorStand... hologram) {
        holograms = new Holograms(entity.getLocation(),height,hologram);
    }

    private void setup() {
        switch (entity.getType()) {
            case ARMOR_STAND:
                if (((ArmorStand) entity).isSmall()) {
                    armLength = 0.25f;
                    height = 1.2f;
                    return;
                }
                armLength = 0.5f;
                height = 2.2f;
                return;
            case GIANT:
                armLength = 3.5f;
                height = 3f;
                return;
            default:
                throw new UnsupportedEntityType(entity);
        }
    }

    public boolean isUsingHolograms() {
        return holograms != null;
    }

    public void delete() {
        entity.remove();
        if (holograms != null) holograms.delete();
    }

    public abstract void teleport(Location location);

    public abstract Location getLocation();

}

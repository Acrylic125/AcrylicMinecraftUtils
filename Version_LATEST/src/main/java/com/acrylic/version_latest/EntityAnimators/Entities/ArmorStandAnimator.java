package com.acrylic.version_latest.EntityAnimators.Entities;

import com.acrylic.version_latest.EntityAnimators.EntityAnimator;
import com.acrylic.version_latest.EntityAnimators.Equipment.AbstractEntityEquipment;
import com.acrylic.version_latest.Utils.Teleport;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

/**
 * Armor Stand preset for animations.
 */
public class ArmorStandAnimator implements EntityAnimator {

    private AbstractEntityEquipment entityEquipment;
    private ArmorStand animator;

    public ArmorStandAnimator(Location location) {
        animator = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        animator.setGravity(false);
        animator.setVisible(false);
        animator.setBasePlate(false);
    }

    public ArmorStandAnimator setSmall() {
        animator.setSmall(true);
        return this;
    }

    public boolean isSmall() {
        return animator.isSmall();
    }

    @Override
    public EntityAnimator setEntityEquipment(AbstractEntityEquipment entityEquipment) {
        this.entityEquipment = entityEquipment;
        return this;
    }

    @Override
    public AbstractEntityEquipment getEntityEquipment() {
        return entityEquipment;
    }

    @Override
    public EntityAnimator getInstance() {
        return this;
    }

    @Override
    public ArmorStand getEntity() {
        return animator;
    }

}

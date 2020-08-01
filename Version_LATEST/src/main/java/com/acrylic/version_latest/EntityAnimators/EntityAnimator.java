package com.acrylic.version_latest.EntityAnimators;

import com.acrylic.version_latest.EntityAnimators.Equipment.AbstractEntityEquipment;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

/**
 * This class gives entity presets for animations.
 */
public interface EntityAnimator {

    EntityAnimator setEntityEquipment(AbstractEntityEquipment entityEquipment);

    AbstractEntityEquipment getEntityEquipment();

    EntityAnimator getInstance();

    LivingEntity getEntity();
    
}

package com.acrylic.version_latest.EntityAnimators.Entities;

import com.acrylic.version_latest.EntityAnimators.EntityAnimator;
import com.acrylic.version_latest.EntityAnimators.Equipment.AbstractEntityEquipment;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GiantAnimator implements EntityAnimator {

    private AbstractEntityEquipment entityEquipment;
    private Giant animator;

    public GiantAnimator(Location location) {
        animator = (Giant) location.getWorld().spawnEntity(location, EntityType.GIANT);
        animator.setCustomName("Dinnerbone");
        animator.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,10000000,1,false,false));
        animator.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,10000000,100,false,false));
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
    public Giant getEntity() {
        return animator;
    }
}

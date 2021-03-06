package com.acrylic.version_1_8.EntityAnimator;

import com.acrylic.version_latest.EntityAnimators.Equipment.AbstractEntityEquipment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public class EntityEquipment implements AbstractEntityEquipment {

    private LivingEntity entity;

    public EntityEquipment(LivingEntity entity) {
        this.entity = entity;
    }

    @Override
    public AbstractEntityEquipment setItemInMainHand(ItemStack item) {
        entity.getEquipment().setItemInHand(item);
        return this;
    }

    @Override
    public AbstractEntityEquipment setHelmet(ItemStack item) {
        entity.getEquipment().setHelmet(item);
        return this;
    }

    @Override
    public AbstractEntityEquipment setChestplate(ItemStack item) {
        entity.getEquipment().setChestplate(item);
        return this;
    }

    @Override
    public AbstractEntityEquipment setLeggings(ItemStack item) {
        entity.getEquipment().setLeggings(item);
        return this;
    }

    @Override
    public AbstractEntityEquipment setBoots(ItemStack item) {
        entity.getEquipment().setBoots(item);
        return this;
    }

    @Override
    public AbstractEntityEquipment getInstance() {
        return null;
    }
}

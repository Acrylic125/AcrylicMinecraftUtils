package com.acrylic.version_latest.Animations.Exceptions;

import org.bukkit.entity.Entity;

/**
 * As of now, only armor stands and giants are supported for animation entities.
 */
public class UnsupportedEntityType extends RuntimeException{

    private final Entity entity;

    public UnsupportedEntityType(Entity entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "Unsupported Entity Type! " + entity.getType() + " is not supported for animations.";
    }
}

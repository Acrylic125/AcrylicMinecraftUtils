package com.acrylic.version_latest.Utils.AOE;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.function.Consumer;

public class EntityAction extends AbstractAOEAction {

    public EntityAction(Location location) {
        super(location);
    }

    public void actOnEntity(Consumer<Entity> action) {
        World world = super.getLocation().getWorld();
        if (world == null) return;
        world.getNearbyEntities(super.getLocation(), super.getX(),super.getY(),super.getZ()).forEach(action::accept);
    }

    public void actOnPlayer(Consumer<Player> action) {
        World world = super.getLocation().getWorld();
        if (world == null) return;
        world.getNearbyEntities(super.getLocation(), super.getX(),super.getY(),super.getZ()).forEach(entity -> {
            if (entity instanceof Player) action.accept((Player) entity);
        });
    }

    public void actOnPlayer(float radius, Consumer<Player> action) {
        final float r = radius * radius;
        final Location loc = super.getLocation();
        Bukkit.getOnlinePlayers().forEach(player -> {
            if (loc.distanceSquared(player.getLocation()) <= r) action.accept(player);
        });
    }

    public void actOnAllPlayers(Consumer<Player> action) {
        Bukkit.getOnlinePlayers().forEach(action);
    }

}

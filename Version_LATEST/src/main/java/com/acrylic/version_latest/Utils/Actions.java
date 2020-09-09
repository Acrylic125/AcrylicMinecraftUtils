package com.acrylic.version_latest.Utils;

import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.function.Consumer;

@UtilityClass
public class Actions {

    public void act(Location location, final float radius, Consumer<Player> action) {
        final float r = radius * radius;
        Bukkit.getOnlinePlayers().forEach(player -> {
            if (location.distanceSquared(player.getLocation()) <= radius) action.accept(player);
        });
    }


}

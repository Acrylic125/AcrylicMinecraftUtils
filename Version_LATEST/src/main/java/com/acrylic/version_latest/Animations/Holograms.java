package com.acrylic.version_latest.Animations;

import com.acrylic.version_latest.EntityAnimators.Entities.ArmorStandAnimator;
import com.acrylic.version_latest.EntityAnimators.EntityAnimator;
import com.acrylic.version_latest.Messages.ChatUtils;
import com.acrylic.version_latest.Utils.Teleport;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.LivingEntity;

import java.util.LinkedList;

public class Holograms {

    /**
     * This is the offset height between each hiologram armor stand.
     */
    private final static float OFFSET_HEIGHT = 0.25f;

    @Getter
    private LinkedList<Hologram> holograms = new LinkedList<>();
    private Location location;

    /**
     * This method DOES NOT SUPPORT NMS!
     * @param location The location of the hologram.
     * @param yOffset The MAIN offset height of the entire hologram.
     * @param hologram What the hologram will display.
     */
    public Holograms(Location location, float yOffset, String... hologram) {
        this.location = location;
        int i = 0;
        for (String s : hologram) {
            if (!s.equals("")) {
                holograms.add(new Hologram(location,i, ChatUtils.get(s),yOffset));
            }
            i++;
        }
    }

    /**
     * NMS is not fully supported. This method is used in conjunction with NMS
     * entities/client side entities.
     * @param location The location of the hologram.
     * @param yOffset The MAIN offset height of the entire hologram.
     * @param holograms The entities to be used as holograms.
     */
    public Holograms(Location location, float yOffset, ArmorStand... holograms) {
        this.location = location;
        int i = 0;
        for (ArmorStand entity : holograms) {
            this.holograms.add(new Hologram(location,i, entity,yOffset));
            i++;
        }
    }

    /**
     * Try to avoid using Hologram.teleport. Please use this instead.
     * @param location
     */
    public void teleport(Location location) {
        holograms.forEach(hologram -> {
            hologram.teleport(location);
        });
    }

    public void delete() {
        holograms.forEach(hologram -> {
            hologram.getHologram().remove();
        });
    }

    public void delete(Hologram hologram) {
        holograms.remove(hologram);
        hologram.getHologram().remove();
    }

    @Getter
    public final static class Hologram {

        private final float offsetHeight;
        private final ArmorStand hologram;

        public Hologram(Location location, int index, String hologramText, float yOffset) {
            offsetHeight = (index * OFFSET_HEIGHT) + yOffset;
            ArmorStandAnimator armorStandAnimator = new ArmorStandAnimator(location.clone().add(0,offsetHeight,0)).setSmall();
            hologram = armorStandAnimator.getEntity();
            hologram.setCustomName(hologramText);
            setup();
        }

        public Hologram(Location location, int index, ArmorStand hologram, float yOffset) {
            offsetHeight = (index * OFFSET_HEIGHT) + yOffset;
            Teleport.tp(hologram,location.clone().add(0,offsetHeight,0));
            this.hologram = hologram;
            setup();
        }

        private void setup() {
            hologram.setCustomNameVisible(true);
            hologram.setMarker(true);
        }

        /**
         * RAW USE! Do not use this method unless you are using it for NMS
         * entities.
         * @param location The location where you want to teleport the INDIVIDUAL
         *                 hologram armor stands to.
         */
        public void teleport(Location location) {
            Teleport.tp(hologram,location.getX(),location.getY() + offsetHeight, location.getZ());
        }

    }

}

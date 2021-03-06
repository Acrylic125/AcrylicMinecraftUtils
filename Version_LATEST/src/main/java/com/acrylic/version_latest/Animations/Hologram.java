package com.acrylic.version_latest.Animations;

import com.acrylic.version_latest.EntityAnimators.Entities.ArmorStandAnimator;
import com.acrylic.version_latest.Utils.Teleport;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

@Getter
public class Hologram {

    private final float offsetHeight;
    private final ArmorStand hologram;

    public Hologram(Location location, int index, String hologramText, float yOffset) {
        offsetHeight = (index * Holograms.OFFSET_HEIGHT) + yOffset;
        ArmorStandAnimator armorStandAnimator = new ArmorStandAnimator(location.clone().add(0,offsetHeight,0)).setSmall();
        hologram = armorStandAnimator.getEntity();
        hologram.setCustomName(hologramText);
        setup();
    }

    public Hologram(Location location, int index, ArmorStand hologram, float yOffset) {
        offsetHeight = (index * Holograms.OFFSET_HEIGHT) + yOffset;
        teleport(location.clone().add(0,offsetHeight,0));
        this.hologram = hologram;
        setup();
    }

    /**
     * NMS USE ONLY!
     */
    public Hologram(int index, float yOffset) {
        offsetHeight = (index * Holograms.OFFSET_HEIGHT) + yOffset;
        hologram = null;
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

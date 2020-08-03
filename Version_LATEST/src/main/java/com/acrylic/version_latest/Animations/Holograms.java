package com.acrylic.version_latest.Animations;

import com.acrylic.version_latest.Messages.ChatUtils;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import java.util.LinkedList;

@Getter
public class Holograms {

    /**
     * This is the offset height between each hiologram armor stand.
     */
    protected final static float OFFSET_HEIGHT = 0.25f;

    @Setter
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

    public Holograms(Location location, float yOffset) {
        this.location = location;
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


}

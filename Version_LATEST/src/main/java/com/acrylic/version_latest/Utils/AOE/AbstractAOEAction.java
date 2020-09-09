package com.acrylic.version_latest.Utils.AOE;

import com.acrylic.version_latest.Messages.ChatUtils;
import lombok.Getter;
import org.bukkit.Location;

@Getter
public abstract class AbstractAOEAction {

    private final Location location;

    private float x = 1;
    private float y = 1;
    private float z = 1;

    public AbstractAOEAction(Location location) {
        this.location = location;
    }

    public AbstractAOEAction setRadius(float radius) {
        return setX(radius).setY(radius).setZ(radius);
    }

    public AbstractAOEAction setX(float xRadius) {
        x = xRadius;
        return this;
    }

    public AbstractAOEAction setY(float yRadius) {
        y = yRadius;
        return this;
    }

    public AbstractAOEAction setZ(float zRadius) {
        z = zRadius;
        return this;
    }

    @Override
    public String toString() {
        return "r=" + x + "," + y + "," + z + " at=" + location;
    }
}

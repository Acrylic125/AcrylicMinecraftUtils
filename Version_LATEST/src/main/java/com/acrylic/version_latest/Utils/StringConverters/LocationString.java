package com.acrylic.version_latest.Utils.StringConverters;

import com.acrylic.version_latest.Messages.ChatUtils;
import org.bukkit.Location;

public class LocationString extends MultiStringBase {

    /**
     *
     * @param location The Location you want to convert to a string
     * @param world
     * @return
     */
    public String convert(Location location, boolean world, boolean exact) {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append((exact) ? convert(location.getX()) + "x " + convert(location.getY()) + "y " + convert(location.getZ()) + "z " :
                convert((int) location.getX()) + "x " + convert((int) location.getY()) + "y " + convert((int) location.getZ()) + "z ");
        return ChatUtils.get((world) ? stringBuilder.append(convert(location.getWorld().getName())).toString() : stringBuilder.toString());
    }

    private String convert(String world) {
        return super.getColorText() + "in " + super.getColorNumber() + world + "&r";
    }

    private String convert(double coord) {
        return super.getColorNumber() + coord + super.getColorText();
    }

    private String convert(int coord) {
        return super.getColorNumber() + coord + super.getColorText();
    }

}

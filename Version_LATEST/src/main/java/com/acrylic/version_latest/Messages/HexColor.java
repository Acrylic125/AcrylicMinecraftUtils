package com.acrylic.version_latest.Messages;

/**
 * This enum is only meant for color consistency purposes
 * and is only meant for MC versions 1.16+.
 *
 * Do note that these colors are selected based on MY
 * preference.
 *
 * Real neat color picker wesite:
 * https://www.w3schools.com/colors/colors_picker.asp
 */
public enum HexColor {

    SOFT_PINK("#ffcccc"),
    PINK("#ff9999"),
    REDDISH_PINK("#ff4d4d"),
    PEACHY_PINK("#ffc6b3"),
    PEACH("#ffd9b3"),
    LIGHT_GREEN("#00ff99"),
    GREEN("#00e68a"),
    DARK_GREEN("#00b36b");

    private final String hexCode;

    HexColor(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getHexCode() {
        return hexCode;
    }

    public String getHexColored() {
        return hexCode;
    }
}

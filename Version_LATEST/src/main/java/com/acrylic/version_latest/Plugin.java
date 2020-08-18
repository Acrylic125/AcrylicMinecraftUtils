package com.acrylic.version_latest;

import lombok.Getter;

public class Plugin {

    @Getter
    private static org.bukkit.plugin.Plugin plugin;
    @Getter
    private static int versionID = 0;

    public static void setPlugin(org.bukkit.plugin.Plugin pluginToUse, int version) {
        plugin = pluginToUse;
        versionID = version;
    }

}

package com.acrylic.acrylicutils;

import com.acrylic.acrylicutils.Commands.TestCommand;
import com.acrylic.acrylicutils.Versions.Version;
import com.acrylic.version_1_8.Events.ItemProtectionPickupListener_1_8;
import com.acrylic.version_1_8.NormalItemTypeRegistry_1_8;
import com.acrylic.version_latest.Events.ArmorEquipEvent.ArmorEquipListeners;
import com.acrylic.version_latest.Events.ArmorEquipEvent.ArmorEquipListeners_LATEST;
import com.acrylic.version_latest.Items.ItemProtection.ItemDropProtectionManager;
import com.acrylic.version_latest.Items.ItemProtection.ItemProtectionEvent;
import com.acrylic.version_latest.Items.ItemProtection.ItemProtectionPickupListener;
import com.acrylic.version_latest.Items.Utils.NormalItemTypeRegistry;
import com.acrylic.version_latest.Items.Utils.NormalItemTypeRegistry_1_13;
import com.acrylic.version_latest.Items.Utils.NormalItemTypeRegistry_1_9;
import com.acrylic.version_latest.Messages.ChatUtils;
import com.acrylic.version_latest.Plugin;
import com.mongodb.MongoClient;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class AcrylicUtils extends JavaPlugin {

    private static AcrylicUtils acrylicUtils;
    private static Version version;
    @Getter
    private static MongoClient mongoClient;
    @Getter
    private static int versionID = 0;

    @SneakyThrows
    @Override
    public void onEnable() {

        acrylicUtils = this;
        String version = Bukkit.getBukkitVersion();

        versionID = Integer.parseInt(version.split("\\.")[1]);

        System.out.println(ChatUtils.get("&3&l======================================="));
        System.out.println(ChatUtils.get("  &3API Developed by: &fAcrylic"));
        System.out.println(ChatUtils.get("  &3ukkit Version: &f" + version));

        Server server = this.getServer();
        PluginManager pluginManager = server.getPluginManager();

        server.getPluginCommand("Test").setExecutor(new TestCommand());
        pluginManager.registerEvents(new ArmorEquipListeners(), this);
        pluginManager.registerEvents(new ItemProtectionEvent(), this);
        Plugin.setPlugin(this,versionID);
        System.out.println(ChatUtils.get("&3&l======================================="));
        try {
            System.out.println(ChatUtils.get("&3Loading MongoClient:"));
            //Add mongo url connection !!
            mongoClient = new MongoClient();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ChatUtils.get("&e&lFailed to load! Something went wrong!"));
        }

        System.out.println(ChatUtils.get("&7Loading from versionID: &f" + versionID));
        if (versionID >= 16) {
            NormalItemTypeRegistry.register();
        } else if (versionID >= 13) {
            NormalItemTypeRegistry_1_13.register();
        } else if (versionID >= 9) {
            pluginManager.registerEvents(new ArmorEquipListeners_LATEST(), this);
            NormalItemTypeRegistry_1_9.register();
        }
        if (versionID <= 8) {
            NormalItemTypeRegistry_1_8.register();
            pluginManager.registerEvents(new ItemProtectionPickupListener_1_8(),this);
        } else {
            pluginManager.registerEvents(new ItemProtectionPickupListener(),this);
        }

        ItemDropProtectionManager.start();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatUtils.get("&3&l======================================="));
        System.out.println(ChatUtils.get("  &3API Developed by: &fAcrylic"));
        System.out.println(ChatUtils.get("  &fShut Down: &c&l%%"));
        System.out.println(ChatUtils.get("&3&l======================================="));
        try {
            mongoClient.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ChatUtils.get("&e&lFailed to close Mongo Connection!"));
        }
    }

    public static AcrylicUtils getAcrylicUtils() {
        return acrylicUtils;
    }
}

package com.acrylic.acrylicutils;

import com.acrylic.acrylicutils.Versions.Version;
import com.acrylic.version_latest.EnchantAPI.Tests.TestEnchant;
import com.acrylic.version_latest.EnchantAPI.Tests.TestEnchant2;
import com.acrylic.version_latest.EnchantAPI.Tests.TestEnchant3;
import com.acrylic.version_latest.Messages.ChatUtils;
import com.acrylic.acrylicutils.Commands.TestCommand;
import com.acrylic.version_latest.Registry.RegisterEnchant;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AcrylicUtils extends JavaPlugin {

    static private AcrylicUtils acrylicUtils;
    static private Version version;
    @Getter
    static private MongoClient mongoClient;

    @SneakyThrows
    @Override
    public void onEnable() {

        acrylicUtils = this;
        Bukkit.broadcastMessage("Testttt");
        String version = Bukkit.getBukkitVersion();

         System.out.println(ChatUtils.get("&3&l======================================="));
         System.out.println(ChatUtils.get("  &3API Developed by: &fAcrylic"));
         System.out.println(ChatUtils.get("  &3ukkit Version: &f" + version));

         this.getServer().getPluginCommand("Test").setExecutor(new TestCommand());
         System.out.println(ChatUtils.get("&3&l======================================="));
         try {
             System.out.println(ChatUtils.get("&3Loading MongoClient:"));
            //Add mongo url connection !!
             mongoClient = new MongoClient();

         } catch (Exception ex) {
             ex.printStackTrace();
             System.out.println(ChatUtils.get("&e&lFailed to load! Something went wrong!"));
         }
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

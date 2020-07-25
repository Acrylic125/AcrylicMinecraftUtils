package com.acrylic.version_latest.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

import java.lang.reflect.Method;
import java.util.function.Supplier;

public class Teleport {

    public static void tp (LivingEntity entity, Location location) {
        try {
            methods[1].invoke(methods[0].invoke(entity), location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        } catch (Exception ex) {
        }
    }

    public static void tp (LivingEntity entity, double x, double y, double z, float yaw, float pitch) {
        try {
            methods[1].invoke(methods[0].invoke(entity), x, y, z, yaw, pitch);
        } catch (Exception ex) {
        }
    }

    public static void tp (LivingEntity entity, double x, double y, double z) {
        try {
            methods[1].invoke(methods[0].invoke(entity), x, y, z, 0, 0);
        } catch (Exception ex) {
        }
    }

    private static final Method[] methods = ((Supplier<Method[]>) () -> {
        try {
            Method getHandle = Class.forName(Bukkit.getServer().getClass().getPackage().getName() + ".entity.CraftEntity").getDeclaredMethod("getHandle");
            return new Method[] {
                    getHandle, getHandle.getReturnType().getDeclaredMethod("setPositionRotation", double.class, double.class, double.class, float.class, float.class)
            };
        } catch (Exception ex) {
            return null;
        }
    }).get();

}

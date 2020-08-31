package com.acrylic.version_latest.Items.ItemProtection;

import com.acrylic.version_latest.Plugin;
import org.bukkit.entity.Item;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class ItemDropProtectionManager {

    private static HashMap<Item,ItemDropProtection> dropProtections = new HashMap<>();

    public static void cache(Item item, ItemDropProtection itemDropProtection) {
        dropProtections.put(item,itemDropProtection);
    }

    public static ItemDropProtection get(Item item) {
        return dropProtections.get(item);
    }

    public static void start() {
        new BukkitRunnable() {
            @Override
            public void run() {
                HashMap<Item,ItemDropProtection> map = new HashMap<>();
                dropProtections.forEach((entity, itemDropProtection) -> {
                    if (!(entity == null || !entity.isValid() || itemDropProtection.getProtectedDuration() <= System.currentTimeMillis())) map.put(entity,itemDropProtection);
                });
                dropProtections = map;
            }
        }.runTaskTimerAsynchronously(Plugin.getPlugin(),1,20);
    }


}

package com.acrylic.version_latest.Items.ItemProtection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class ItemProtectionPickupListener implements Listener {

    @EventHandler
    public void listen(EntityPickupItemEvent e) {
        ItemDropProtection.State state = ItemDropProtection.isOwnedBy(e.getItem(), (Player) e.getEntity());
        Bukkit.broadcastMessage(state + "");
    }

}

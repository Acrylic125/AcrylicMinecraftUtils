package com.acrylic.version_1_8.Events;

import com.acrylic.version_latest.Items.ItemProtection.ItemDropProtection;
import com.acrylic.version_latest.Items.ItemProtection.ItemProtectionPickupEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class ItemProtectionPickupListener_1_8 implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void listen(PlayerPickupItemEvent e) {
        Item item = e.getItem();
        Player player = e.getPlayer();

        ItemDropProtection.State state = ItemDropProtection.isOwnedBy(item, player);
        if (state.equals(ItemDropProtection.State.PLAYER_OWNS_ITEM)) {
            ItemProtectionPickupEvent event = new ItemProtectionPickupEvent(player,item.getItemStack());
            Bukkit.getPluginManager().callEvent(event);
            e.setCancelled(event.isCancelled());
        } else {
            e.setCancelled(state.equals(ItemDropProtection.State.PLAYER_DOES_NOT_OWN_ITEM));
        }
    }

}

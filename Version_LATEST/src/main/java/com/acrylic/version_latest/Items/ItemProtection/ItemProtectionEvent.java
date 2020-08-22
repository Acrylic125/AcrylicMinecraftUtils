package com.acrylic.version_latest.Items.ItemProtection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class ItemProtectionEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void listen(EntityPickupItemEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        Item item = e.getItem();
        Player player = (Player) e.getEntity();

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

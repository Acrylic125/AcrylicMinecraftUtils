package com.acrylic.version_latest.Items.ItemProtection;

import lombok.Getter;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * Item Protection Pickup event is called when a drop protected item is being picked up.
 */
public class ItemProtectionPickupEvent extends Event implements Cancellable {

    @Getter
    private final ItemStack item;
    @Getter
    private final LivingEntity entity;

    public static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;

    /**
     *
     * @param entity The entity/player.
     * @param item The new item.
     */
    public ItemProtectionPickupEvent(LivingEntity entity, ItemStack item) {
        this.entity = entity;
        this.item = item;
        this.isCancelled = false;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

}

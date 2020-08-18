package com.acrylic.version_latest.Events.ArmorEquipEvent;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;

/**
 * This is MY IMPLEMENTATION of armor equip event. The old system by Armurh was
 * very poorly designed therefore it was deleted.
 */
public class ArmorChangeEvent extends Event implements Cancellable {

    @Getter
    private final ArmorEquipType equipType;
    @Getter
    private final ItemStack previousItem;
    @Getter
    private final ItemStack item;
    @Getter
    private final LivingEntity entity;
    @Getter
    private final boolean hotswap;

    public static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;

    /**
     *
     * @param entity The entity/player.
     * @param previousItem The previous item.
     * @param item The new item.
     * @param armorEquipType How the item was equipped.
     * @param hotswap If the event was successful. (In this case, if the
     *                item was able to be equipped)
     */
    public ArmorChangeEvent(LivingEntity entity, ItemStack item, ItemStack previousItem, ArmorEquipType armorEquipType, boolean hotswap) {
        this.entity = entity;
        this.item = item;
        this.previousItem = previousItem;
        this.equipType = armorEquipType;
        this.hotswap = hotswap;
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

    public static ArmorChangeEvent call(LivingEntity entity, ItemStack newItem, ItemStack oldItem, ArmorEquipType armorEquipType, boolean hotswap) {
        ArmorChangeEvent event = new ArmorChangeEvent(entity,newItem,oldItem,armorEquipType,hotswap);
        Bukkit.getPluginManager().callEvent(event);
        return event;
    }

    public static void refresh(LivingEntity entity, ArmorEquipType armorEquipType) {
        EntityEquipment entityEquipment = entity.getEquipment();
        PluginManager pluginManager = Bukkit.getPluginManager();
        if (entityEquipment == null) return;
        pluginManager.callEvent(new ArmorChangeEvent(entity,entityEquipment.getHelmet(),null,armorEquipType,false));
        pluginManager.callEvent(new ArmorChangeEvent(entity,entityEquipment.getChestplate(),null,armorEquipType,false));
        pluginManager.callEvent(new ArmorChangeEvent(entity,entityEquipment.getLeggings(),null,armorEquipType,false));
        pluginManager.callEvent(new ArmorChangeEvent(entity,entityEquipment.getBoots(),null,armorEquipType,false));
    }

}

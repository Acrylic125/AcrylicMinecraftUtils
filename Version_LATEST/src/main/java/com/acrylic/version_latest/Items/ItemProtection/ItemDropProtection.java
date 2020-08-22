package com.acrylic.version_latest.Items.ItemProtection;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTEntity;
import de.tr7zw.nbtinjector.NBTInjector;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

@Getter
public class ItemDropProtection {

    public enum State {
        NOT_A_PROTECTED_ITEM,
        PLAYER_DOES_NOT_OWN_ITEM,
        PLAYER_OWNS_ITEM
    }

    private final ArrayList<String> owners = new ArrayList<>();
    private final long protectedDuration;

    public ItemDropProtection(Location location, ItemStack item) {
        Item entity = location.getWorld().dropItem(location,item);
        protectedDuration = 60000 + System.currentTimeMillis();
        ItemDropProtectionManager.cache(entity,this);
    }

    public ItemDropProtection(Location location, ItemStack item, long protectedDuration) {
        Item entity = location.getWorld().dropItem(location,item);
        this.protectedDuration = protectedDuration + System.currentTimeMillis();
        ItemDropProtectionManager.cache(entity,this);
    }

    public ItemDropProtection addPlayer(Player player) {
        owners.add(player.getName());
        return this;
    }

    public ItemDropProtection addPlayer(String name) {
        owners.add(name);
        return this;
    }

    public static State isOwnedBy(Item item, Player player) {
        ItemDropProtection itemDropProtection = ItemDropProtectionManager.get(item);
        if (itemDropProtection == null || itemDropProtection.getProtectedDuration() < System.currentTimeMillis()) return State.NOT_A_PROTECTED_ITEM;
        return (itemDropProtection.getOwners().contains(player.getName())) ? State.PLAYER_OWNS_ITEM : State.PLAYER_DOES_NOT_OWN_ITEM;
    }



}

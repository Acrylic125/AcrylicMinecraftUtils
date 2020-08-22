package com.acrylic.version_latest.Items.Utils;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemPropertyUtils extends ItemUtils {

    private final NBTItem nbtItem;

    public ItemPropertyUtils(ItemStack item) {
        super(item);
        nbtItem = new NBTItem(item);
    }

    public ItemPropertyUtils setShiny() {
        ItemMeta meta = super.getItemMeta();
        meta.addEnchant((getItem().getType().equals(Material.FISHING_ROD)) ? Enchantment.OXYGEN : Enchantment.LURE, 1,true);
        getItem().setItemMeta(meta);
        return hideFlags(true);
    }

    public ItemPropertyUtils hideFlags(boolean hide) {
        nbtItem.setByte("HideFlags",(hide) ? (byte) 1 : (byte) 0);
        return this;
    }

    public ItemStack getItem() {
        return nbtItem.getItem();
    }

}

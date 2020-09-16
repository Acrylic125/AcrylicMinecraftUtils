package com.acrylic.version_latest.Items.Utils;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemPropertyUtils extends ItemUtils {

    public ItemPropertyUtils(ItemStack item) {
        super(item);
    }

    public ItemPropertyUtils setShiny() {
        ItemMeta meta = super.getItemMeta();
        meta.addEnchant((super.getItem().getType().equals(Material.FISHING_ROD)) ? Enchantment.OXYGEN : Enchantment.LURE, 1,true);
        return hideFlags(true);
    }

    public ItemPropertyUtils hideFlags(boolean hide) {
        if (hide) getItemMeta().addItemFlags(ItemFlag.HIDE_ENCHANTS);
        else getItemMeta().removeItemFlags(ItemFlag.HIDE_ENCHANTS);
        return this;
    }

    @Override
    public ItemStack getItem() {
        ItemStack item = super.getItem();
        item.setItemMeta(super.getItemMeta());
        return item;
    }
}

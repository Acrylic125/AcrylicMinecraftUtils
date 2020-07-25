package com.acrylic.version_1_8;

import com.acrylic.version_latest.Items.ItemInterface;
import com.acrylic.version_latest.Messages.ChatUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemCreator implements ItemInterface {
    ItemStack item;
    ItemMeta meta;

    public ItemCreator(ItemCreator itemCreator) {
        item = itemCreator.getItem();
        meta = item.getItemMeta();

    }
    public ItemCreator(Material material) {
        this(material,1);
    }
    public ItemCreator(Material material, int quantity) {
        item = new ItemStack(material,quantity);
        meta = item.getItemMeta();
    }

    @Override
    public ItemStack getItem() {
        setMetaData();
        return item;
    }

    @Override
    public ItemInterface setMaterial(Material material) {
        return this;
    }

    @Override
    public ItemInterface setLore(final String... lore) {
        List<String> lores = new ArrayList<>();
        for (String lime : lore) {
            lores.add(ChatUtils.get(lime));
        }
        meta.setLore(lores);
        return this;
    }

    @Override
    public ItemInterface setRawLore(String... lore) {
        meta.setLore(Arrays.asList(lore));
        return this;
    }

    @Override
    public ItemInterface setItemName(String name) {
        meta.setDisplayName(ChatUtils.get(name));
        return this;
    }

    @Override
    public ItemInterface setSkullOwner(String offlinePlayerName) {
        if (meta instanceof SkullMeta) {
            setItemDamage((short)3);
            SkullMeta skullMeta = (SkullMeta) meta;
            skullMeta.setOwner(offlinePlayerName);
            setMetaData(meta);
        }
        return this;
    }

    @Override
    public ItemInterface setItemDamage(short damage) {
        item.setDurability(damage);
        return this;
    }

    @Override
    public ItemInterface setMetaData(ItemMeta itemMeta) {
        item.setItemMeta(itemMeta);
        return this;
    }

    @Override
    public ItemInterface setMetaData() {
        item.setItemMeta(meta);
        return this;
    }

    @Override
    public ItemInterface getInstance() {
        return this;
    }

    @Override
    public ItemInterface setQuantity(int quantity) {
        item.setAmount(quantity);
        return this;
    }
}

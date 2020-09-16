package com.acrylic.version_latest.Items;

import com.acrylic.version_latest.Annotations.Discouraged;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.function.Consumer;

public interface ItemInterface {

    /**
     *
     * @return The item output
     */
    ItemStack getItem();

    /**
     *
     * @param material The material of the itemstack (Kind of pointless)
     * @return
     */
    ItemInterface setMaterial(Material material);

    /**
     *
     * @param lore The lore displayed on the item.
     *             Do note that the lore are iterated through and the lines
     *             are colorized. Use "setRawLore" if you do not want to iterate
     *             through the lore however, you will need to manually modify the
     *             lore with ChatUtils.get() if you want to colorize the lore.
     * @return
     */
    ItemInterface setLore(String... lore);


    @Discouraged
    ItemInterface setRawLore(String... lore);

    ItemInterface setItemName(String name);

    ItemInterface setSkullOwner(String offlinePlayerName);

    /**
     *
     * @param damage
     * This should only be used for version 1.8
     * @return
     */
    @Deprecated
    ItemInterface setItemDamage(short damage);

    ItemInterface setMetaData(ItemMeta itemMeta);

    ItemInterface setMetaData();

    ItemInterface getInstance();

    ItemInterface setQuantity(int quantity);

    ItemMeta getIteMeta();

    default ItemInterface setShiny() {
        modifyItemMeta(meta -> {
            meta.addEnchant((getItem().getType().equals(Material.FISHING_ROD)) ? Enchantment.OXYGEN : Enchantment.LURE, 1,true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        });
        return this;
    }

    default ItemInterface modifyItemMeta(Consumer<ItemMeta> action) {
        action.accept(getIteMeta());
        return this;
    }

    default ItemInterface modifyItemStack(Consumer<ItemStack> action) {
        action.accept(getItem());
        return this;
    }

}

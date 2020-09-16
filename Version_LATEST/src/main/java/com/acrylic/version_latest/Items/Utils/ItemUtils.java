package com.acrylic.version_latest.Items.Utils;

import com.acrylic.version_latest.Messages.ChatUtils;
import com.acrylic.version_latest.Plugin;
import com.acrylic.version_latest.Utils.StringConverters.MultiStringBase;
import de.tr7zw.nbtapi.NBTItem;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils extends MultiStringBase {

    private final boolean isAir;

    @Getter
    private ItemStack item;
    @Setter @Getter
    private ItemMeta itemMeta;

    public ItemUtils(ItemStack item) {
        this.item = item;
        isAir = isAir(item);
        itemMeta = (!isAir) ? item.getItemMeta() : null;
    }

    public boolean isAir() {
        return isAir;
    }

    public String getDisplayName() {
        if (!isAir) {
           return (itemMeta != null && itemMeta.hasDisplayName()) ? itemMeta.getDisplayName() : getItemTypeName();
        } else {
            return "Air";
        }
    }

    public String getItemTypeName() {
        if (!isAir) {
            return WordUtils.capitalize(item.getType().toString().replace("_"," ").toLowerCase());
        } else {
            return "Air";
        }
    }

    public String getItemDisplayName() {
        return ChatUtils.get(super.getColorNumber() + item.getAmount() + super.getColorText() + "x&r&f " + getDisplayName() + "&r");
    }

    public static boolean isAir(ItemStack item) {
        return item == null || item.getType().equals(Material.AIR);
    }

}

package com.acrylic.version_latest.Items.Utils;

import com.acrylic.version_latest.Messages.ChatUtils;
import com.acrylic.version_latest.Utils.StringConverters.MultiStringBase;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils extends MultiStringBase {

    private final boolean isAir;

    private ItemStack item;
    private ItemMeta itemMeta;

    public ItemUtils(ItemStack item) {
        this.item = item;
        isAir = item == null || item.getType().equals(Material.AIR) || !item.hasItemMeta();
    }

    public boolean isAir() {
        return isAir;
    }

    public String getDisplayName() {
        if (!isAir) {
           return (itemMeta.hasDisplayName()) ? "" : itemMeta.getDisplayName();
        } else {
            return "Air";
        }
    }

    public String getItemTypeName() {
        if (!isAir) {
            return StringUtils.capitalize(item.getType().toString().toLowerCase());
        } else {
            return "Air";
        }
    }

    public String getItemDisplayName() {
        return ChatUtils.get(super.getColorNumber() + item.getAmount() + super.getColorText() + "x " + getDisplayName() + "&r");
    }

}

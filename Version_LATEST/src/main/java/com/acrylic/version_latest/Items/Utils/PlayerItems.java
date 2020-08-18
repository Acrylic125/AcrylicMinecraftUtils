package com.acrylic.version_latest.Items.Utils;

import com.acrylic.version_latest.Items.ItemProtection.ItemDropProtection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerItems {

    public static ItemStack[] getInventory(Player player) {
        return player.getInventory().getContents();
    }

    public static int getAmount(Player player, ItemStack item) {
        if (ItemUtils.isAir(item)) return 0;
        int total = 0;
        for (ItemStack inventoryItem : getInventory(player)) {
            if (!ItemUtils.isAir(inventoryItem)) total += inventoryItem.getAmount();
        }
        return total;
    }

    /**
     * This system determines if the player has enough space to get an item.
     * If they do, the item is directed into their inventory. If not, the item will
     * be dropped onto the ground.
     *
     * @param player Player
     * @param item The item
     * @return true : If the player has enough space in their inventory to get
     *         the item.
     *         false : If the player does not have enough space in their inventory
     *         to get the item.
     */
    public static boolean give(Player player, ItemStack item) {
        return give(player,item,false);
    }

    /**
     * @param dropProtection If the item dropped should have drop protection support.
     * @return See above.
     */
    public static boolean give(Player player, ItemStack item, boolean dropProtection) {
        boolean hasEnoughSpace = hasEnoughSpace(player,item);
        if (hasEnoughSpace) player.getInventory().addItem(item);
        else if (dropProtection) new ItemDropProtection(player.getLocation(),item).addPlayer(player.getName());
        else player.getWorld().dropItem(player.getLocation(), item);
        return hasEnoughSpace;
    }

    public static boolean hasEnoughSpace(Player player, ItemStack item) {
        if (ItemUtils.isAir(item)) return true;
        int quantityToCompare = 0;
        for (ItemStack inventoryItem : getInventory(player)) {
            if (ItemUtils.isAir(inventoryItem)) {
                quantityToCompare += item.getMaxStackSize();
            } else if (inventoryItem.isSimilar(item)) {
                quantityToCompare += (item.getMaxStackSize() - inventoryItem.getAmount());
            }
        }
        return item.getAmount() <= quantityToCompare;
    }


}

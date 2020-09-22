package com.acrylic.version_latest.Events.ArmorEquipEvent;

import com.acrylic.version_latest.Events.Exceptions.ItemIsNotAnArmor;
import com.acrylic.version_latest.Items.Utils.ItemUtils;
import com.acrylic.version_latest.Items.Utils.NormalItemType;
import com.acrylic.version_latest.Items.Utils.NormalItemTypeManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ArmorEquipListeners implements Listener {

    public static boolean HOT_SWAP_ENABLED = true;

    private static ArmorChangeEvent interact(Player player, ItemStack item){
        if (ItemUtils.isAir(item)) return null;
        NormalItemType normalItemType = NormalItemTypeManager.get(item.getType());
        if (!normalItemType.isArmor()) return null;
        ItemStack previousItem;
        ItemStack newItem;
        try {
            previousItem = getArmorItem(player,normalItemType);
            newItem = item.clone();
            if (HOT_SWAP_ENABLED || ItemUtils.isAir(previousItem)) setArmorItem(player,normalItemType,item,(previousItem == null) ? null : previousItem.clone());
        } catch (ItemIsNotAnArmor ex) {
            return null;
        }
        return ArmorChangeEvent.call(player,newItem,previousItem,ArmorEquipType.PHYSICAL,!ItemUtils.isAir(previousItem));
    }

    private static void setArmorItem(Player player, NormalItemType normalItemType, ItemStack item, ItemStack previousItem) {
        EntityEquipment equipment = player.getEquipment();
        if (equipment == null) return;
        if (normalItemType.equals(NormalItemType.HELMET)) equipment.setHelmet(item);
        else if (normalItemType.equals(NormalItemType.CHESTPLATE)) equipment.setChestplate(item);
        else if (normalItemType.equals(NormalItemType.LEGGINGS)) equipment.setLeggings(item);
        else if (normalItemType.equals(NormalItemType.BOOTS)) equipment.setBoots(item);
        player.setItemInHand(previousItem);
    }

    private static ItemStack getArmorItem(Player player, NormalItemType normalItemType) throws ItemIsNotAnArmor {
        EntityEquipment equipment = player.getEquipment();
        if (equipment == null) return null;
        if (normalItemType.equals(NormalItemType.HELMET)) return equipment.getHelmet();
        else if (normalItemType.equals(NormalItemType.CHESTPLATE)) return equipment.getChestplate();
        else if (normalItemType.equals(NormalItemType.LEGGINGS)) return equipment.getLeggings();
        else if (normalItemType.equals(NormalItemType.BOOTS)) return equipment.getBoots();
        else throw new ItemIsNotAnArmor();
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void listen(PlayerJoinEvent e) {
        ArmorChangeEvent.refresh(e.getPlayer(),ArmorEquipType.LOGIN);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void listen(PlayerInteractEvent e) {
        Action action = e.getAction();
        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
            ArmorChangeEvent event = interact(e.getPlayer(),e.getItem());
            if (event == null) return;
            e.setCancelled(event.isCancelled());
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void listen(PlayerInteractEntityEvent e) {
        ArmorChangeEvent event = interact(e.getPlayer(),e.getPlayer().getItemInHand());
        if (event == null) return;
        e.setCancelled(event.isCancelled());
    }

    @EventHandler(priority =  EventPriority.HIGHEST, ignoreCancelled = true)
    public void inventoryClick(InventoryClickEvent e){
        InventoryAction action = e.getAction();
        if(action == InventoryAction.NOTHING) return;// Why does this get called if nothing happens??
        ClickType clickType = e.getClick();

        ItemStack newItem;
        ItemStack oldItem;

        Inventory inventory = e.getClickedInventory();
        if (inventory == null || !(inventory.getType() == InventoryType.PLAYER || inventory.getType() == InventoryType.CRAFTING)) return;
        InventoryType.SlotType slotType = e.getSlotType();
        switch (clickType) {
            case LEFT:
            case RIGHT:
            case CONTROL_DROP:
            case CREATIVE:
            case DROP:
                if (!slotType.equals(InventoryType.SlotType.ARMOR)) return;
                newItem = e.getCursor();
                oldItem = e.getCurrentItem();
                break;
            case SHIFT_LEFT:
            case SHIFT_RIGHT:
                newItem = e.getCurrentItem();
                try {
                    oldItem = getArmorItem((Player) e.getWhoClicked(),NormalItemTypeManager.get(newItem));
                    if (!slotType.equals(InventoryType.SlotType.ARMOR)) {
                        if (!e.getView().getType().equals(InventoryType.CRAFTING)) return;
                        if (!(ItemUtils.isAir(oldItem))) return;
                    } else {
                        if (inventory.firstEmpty() == -1) return;
                        newItem = null;
                        if (NormalItemTypeManager.get(oldItem).getArmorSlot() != e.getRawSlot()) return;
                    }
                } catch (ItemIsNotAnArmor ex) {
                    return;
                }
                break;
            case NUMBER_KEY:
                if (!e.getClickedInventory().getType().equals(InventoryType.PLAYER)) return;
                int rawSlot = e.getRawSlot();
                if (!(rawSlot >= 5 && rawSlot <= 8)) return;
                int slot = e.getSlot();

                oldItem = inventory.getItem(slot);
                newItem = inventory.getItem(e.getHotbarButton());
                if(!ItemUtils.isAir(newItem)) {
                    oldItem = inventory.getItem(slot);
                }
                if (NormalItemTypeManager.get(newItem).getArmorSlot() != rawSlot) newItem = null;
                break;
            default:
                return;
        }
        e.setCancelled(ArmorChangeEvent.call(e.getWhoClicked(),newItem,oldItem,ArmorEquipType.INVENTORY,false).isCancelled());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void listen(InventoryDragEvent e) {
        ItemStack newItem = e.getOldCursor();
        NormalItemType type = NormalItemTypeManager.get(newItem);
        int slot = type.getArmorSlot();
        if (slot != -1 && slot == e.getRawSlots().stream().findFirst().orElse(0)) {
            ArmorChangeEvent changeEvent = ArmorChangeEvent.call(e.getWhoClicked(),newItem,null,ArmorEquipType.INVENTORY,false);
            if(changeEvent.isCancelled()){
                e.setResult(Event.Result.DENY);
                e.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void listen(PlayerItemBreakEvent e) {
        ItemStack oldItem = e.getBrokenItem();
        NormalItemType type = NormalItemTypeManager.get(oldItem);
        if (type.isArmor()) {
            ArmorChangeEvent.call(e.getPlayer(),null,oldItem,ArmorEquipType.ITEM_BREAK,false);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void listen(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        for (ItemStack item : e.getPlayer().getInventory().getArmorContents()) {
            if (NormalItemTypeManager.get(item).isArmor()) ArmorChangeEvent.call(player,item,null,ArmorEquipType.DEATH,false);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void listen(PlayerDeathEvent e) {
        Player player = e.getEntity();
        for (ItemStack item : e.getEntity().getInventory().getArmorContents()) {
            if (NormalItemTypeManager.get(item).isArmor()) ArmorChangeEvent.call(player,null,item,ArmorEquipType.DEATH,false);
        }
    }

}

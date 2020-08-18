package com.acrylic.version_latest.Events.ArmorEquipEvent;

import com.acrylic.version_latest.Items.Utils.NormalItemType;
import com.acrylic.version_latest.Items.Utils.NormalItemTypeManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseArmorEvent;
import org.bukkit.inventory.ItemStack;

public class ArmorEquipListeners_LATEST implements Listener {

    @EventHandler
    public void listen(BlockDispenseArmorEvent e) {
        ItemStack newItem = e.getItem();
        NormalItemType type = NormalItemTypeManager.get(newItem);
        if (type.isArmor()) {
            ArmorChangeEvent changeEvent = ArmorChangeEvent.call(e.getTargetEntity(),newItem,null,ArmorEquipType.DISPENSER,false);
            e.setCancelled(changeEvent.isCancelled());
        }
    }

}

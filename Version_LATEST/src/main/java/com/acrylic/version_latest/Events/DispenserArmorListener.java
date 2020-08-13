package com.acrylic.version_latest.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseArmorEvent;

/**
 * THIS IS NOT MY CODE! This is only a requested addon.
 * Ref: https://github.com/Arnuh/ArmorEquipEvent
 */

/**
 * @author Arnah
 * @since Feb 08, 2019
 */
public class DispenserArmorListener implements Listener{
	
	
	@EventHandler
	public void dispenseArmorEvent(BlockDispenseArmorEvent event){
		ArmorType type = ArmorType.matchType(event.getItem());
		if(type != null){
			if(event.getTargetEntity() instanceof Player){
				Player p = (Player) event.getTargetEntity();
				ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(p, ArmorEquipEvent.EquipMethod.DISPENSER, type, null, event.getItem());
				Bukkit.getServer().getPluginManager().callEvent(armorEquipEvent);
				if(armorEquipEvent.isCancelled()){
					event.setCancelled(true);
				}
			}
		}
	}
}
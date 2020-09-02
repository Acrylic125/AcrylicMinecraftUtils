package com.acrylic.acrylicutils.Commands;

import com.acrylic.acrylicutils.AcrylicUtils;
import com.acrylic.version_1_8.EntityAnimator.EntityEquipment;
import com.acrylic.version_latest.Animations.GradualMovementAnimation;
import com.acrylic.version_latest.Animations.HandRotatorAnimation;
import com.acrylic.version_latest.Animations.ItemDangle;
import com.acrylic.version_latest.EntityAnimators.Entities.ArmorStandAnimator;
import com.acrylic.version_latest.GUI.GUIItemPresets.GUIItemPresets;
import com.acrylic.version_latest.GUI.GUIItemPresets.GUIPageSelectorItem;
import com.acrylic.version_latest.GUI.GUIManager;
import com.acrylic.version_latest.GUI.GUIPageBuilder;
import com.acrylic.version_latest.Utils.Weight.WeightComparator;
import com.acrylic.version_latest.Utils.Weight.WeightProducer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class TestCommand implements CommandExecutor{

    private static GUIPageBuilder guiPageBuilder = new GUIPageBuilder(2,7,4);

    static {
        for (int i = 0; i < 300; i++) {
            guiPageBuilder.add(new ItemStack(Material.STONE));
        }
        guiPageBuilder.setUsingMiddleSlot(true);
        guiPageBuilder.setItemPresets(
                new GUIItemPresets()
                        .setItem(4,new ItemStack(Material.EMERALD_BLOCK))
                        .setItem(49,new ItemStack(Material.BARRIER))

        );
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        /**GUIManager manager = new GUIManager("&e&lFuck you",6);
        manager.show(p);
        guiPageBuilder.
                setInventory(manager.getInventory()).
                constructAll();**/
         return true;
    }



}

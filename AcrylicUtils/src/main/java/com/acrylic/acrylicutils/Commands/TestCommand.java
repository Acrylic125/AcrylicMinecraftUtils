package com.acrylic.acrylicutils.Commands;

import com.acrylic.acrylicutils.AcrylicUtils;
import com.acrylic.version_1_8.EntityAnimator.EntityEquipment;
import com.acrylic.version_latest.Animations.HandRotatorAnimation;
import com.acrylic.version_latest.Animations.HeadRotatorAnimation;
import com.acrylic.version_latest.Animations.ItemDangle;
import com.acrylic.version_latest.EntityAnimators.Entities.ArmorStandAnimator;
import com.acrylic.version_latest.EntityAnimators.Entities.GiantAnimator;
import com.acrylic.version_latest.EntityAnimators.EntityAnimator;
import com.acrylic.version_latest.Messages.Symbols;
import com.acrylic.version_latest.Shapes.Circle;
import com.acrylic.version_latest.Utils.Teleport;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitRunnable;

public class TestCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        Location center = p.getLocation().clone();

        ItemDangle itemDangle = new ItemDangle(p);
        for (int i = 1;i<=Integer.parseInt(args[0]);i++) {
            EntityAnimator entityManager = new GiantAnimator(center);
            entityManager.setEntityEquipment(
                    new EntityEquipment(entityManager.getEntity()).setItemInMainHand(p.getItemInHand()));
            HandRotatorAnimation d = new HandRotatorAnimation(entityManager);
            d.setHologram("&6&lLevel Up!","&eYou are a cunt","&eA genuine cuck.");
            itemDangle.addAnimator(d);
        }
        new BukkitRunnable() {

            int i = 0;

            @Override
            public void run() {
                itemDangle.update();
                if (i % 25 == 0) {
                    itemDangle.delete(itemDangle.getAnimators().get(0));
                }
                if (i > 200) {
                    itemDangle.delete();
                }
                i++;
            }
        }.runTaskTimer(AcrylicUtils.getAcrylicUtils(), 1, 1);


         return true;
    }


   
}

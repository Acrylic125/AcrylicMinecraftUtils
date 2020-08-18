package com.acrylic.acrylicutils.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

public class TestCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
       // Bukkit.broadcastMessage("Test ");
      //  PlayerItems.give(p,new ItemStack(Material.DIAMOND_SWORD),true);
        return true;
    }


   
}

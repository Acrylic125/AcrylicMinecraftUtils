package com.acrylic.acrylicutils.Commands;

import com.acrylic.version_latest.Utils.RomanNumerals;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

public class TestCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
       // Bukkit.broadcastMessage(RomanNumerals.toRoman(Integer.parseInt(args[0])));
       // Bukkit.broadcastMessage("Test ");
      //  PlayerItems.give(p,new ItemStack(Material.DIAMOND_SWORD),true);
        return true;
    }


   
}

package com.acrylic.acrylicutils.Commands;

import com.acrylic.version_latest.Items.ItemProtection.ItemDropProtection;
import com.acrylic.version_latest.Items.Utils.ItemPropertyUtils;
import com.acrylic.version_latest.Items.Utils.PlayerItems;
import com.acrylic.version_latest.Utils.StringConverters.ProgressBar;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

public class TestCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        return true;
    }


   
}

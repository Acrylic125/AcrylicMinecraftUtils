package com.acrylic.acrylicutils.Commands;

import com.acrylic.version_latest.GUI.GUIBuilder;
import com.acrylic.version_latest.GUI.GUIItemPresets.GUIItemPresets;
import com.acrylic.version_latest.GUI.GUIItemPresets.GUIPageSelectorItem;
import com.acrylic.version_latest.GUI.GUIPageBuilder;
import com.acrylic.version_latest.Items.ItemCreator;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class TestCommand implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        return true;
    }

}

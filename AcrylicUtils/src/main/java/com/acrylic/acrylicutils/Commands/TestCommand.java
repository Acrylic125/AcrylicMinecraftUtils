package com.acrylic.acrylicutils.Commands;

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

import java.util.ArrayList;

public class TestCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        /**GUIManager manager = new GUIManager("Hello",6);
        manager.show(p);
        GUIPageBuilder guiMiddleSlot = new GUIPageBuilder(2,7,4);
        for (int i = 0; i < Integer.parseInt(args[1]); i++) {
            guiMiddleSlot.add(new ItemStack(Material.STONE));
        }
        guiMiddleSlot.setInventory(manager.getInventory());
        guiMiddleSlot.setUsingMiddleSlot(true);
        guiMiddleSlot.setPage(Integer.parseInt(args[0]));
        guiMiddleSlot.construct();
       // GUIPageBuilder pageBuilder = new GUIPageBuilder(1,7,3);
        **/
         return true;
    }

    private static class TestComparator implements WeightComparator<Material> {

        private final int weight;
        private final Material output;

        private TestComparator(int weight, Material output) {
            this.weight = weight;
            this.output = output;
        }

        @Override
        public int getWeight() {
            return weight;
        }

        @Override
        public Material getProduced() {
            return output;
        }
    }



}

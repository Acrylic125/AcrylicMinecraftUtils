package com.acrylic.version_latest.GUI;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.LinkedList;

@Getter
public class MultiPageUIBuilder {

    private final Inventory inventory;
    private final int maxSlots;

    @Setter
    private ArrayList<ItemStack> items = new ArrayList<>();
    private int maxPages;

    public MultiPageUIBuilder(Inventory inventory) {
        this.inventory = inventory;
        maxSlots = inventory.getSize();
    }

    public void view(Player player, int page) {

    }

    public MultiPageUIBuilder add() {
        return null;
    }





}

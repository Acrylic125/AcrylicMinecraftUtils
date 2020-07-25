package com.acrylic.version_latest.EnchantAPI;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

public class Enchants extends EnchantInitializer {

    public Enchants(ItemStack item, Entity user) {
        setUser(user);
        setItem(item);
    }


    @Override
    public EnchantInitializer setUser(Entity user) {
        super.user = user;
        return this;
    }

    @Override
    public EnchantInitializer setActivationMultiplier(float multiplier) {
        super.activationMultiplier = multiplier;
        return this;
    }

    @Override
    public EnchantInitializer setTarget(Entity target) {
        super.target = target;
        return this;
    }

    @Override
    public EnchantInitializer setBlock(Block block) {
        super.block = block;
        return this;
    }

    @Override
    public EnchantInitializer setItem(ItemStack item) {
        super.item = item;
        return this;
    }

    @Override
    public EnchantInitializer getInstance() {
        return this;
    }
}

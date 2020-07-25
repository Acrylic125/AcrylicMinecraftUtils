package com.acrylic.version_latest.EnchantAPI;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

@Getter
public abstract class EnchantInitializer {

    protected Entity user;
    protected Entity target;
    protected ItemStack item;
    protected Block block;
    protected float activationMultiplier = 1;

    /**
     *
     * @param user The entity user. It is recommended that you instantiate a new
     *               enchant object.
     * @return
     */
    public abstract EnchantInitializer setUser(Entity user);

    /**
     *
     * @param multiplier The activation multiplier. For example, if the multiplier
     *                   is set to 0, there will be no chance of enchant activation.
     *                   If it is set to 1, the multiplier will be 1x. If it is set to 2,
     *                   the chance of activation will be twice as likely.
     * @return
     */
    public abstract EnchantInitializer setActivationMultiplier(float multiplier);

    /**
     *
     * @param entity The target of the enchant. For example, the victim of
     *               combat enchants.
     * @return
     */
    public abstract EnchantInitializer setTarget(Entity target);

    /**
     *
     * @param block This is mainly used for
     * @return
     */
    public abstract EnchantInitializer setBlock(Block block);

    /**
     *
     * @param item Sets the item to test for. It is recommended that you
     *             instantiate a new enchant object.
     * @return
     */
    public abstract EnchantInitializer setItem(ItemStack item);

    public abstract EnchantInitializer getInstance();


}

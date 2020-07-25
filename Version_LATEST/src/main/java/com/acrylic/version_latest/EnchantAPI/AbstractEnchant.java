package com.acrylic.version_latest.EnchantAPI;

import com.acrylic.version_latest.EnchantAPI.Exceptions.InvalidEnchantAction;
import org.bukkit.Location;

/**
 *
 * @throws InvalidEnchantAction If the method is not overridden, this
 * exception will be thrown.
 */
public abstract class AbstractEnchant {


    /**
     * This is the main method to activate the enchant.
     */
    public void activate() throws InvalidEnchantAction {
        throw new InvalidEnchantAction();
    }

    /**
     * This method retrieves an integer of the enchant.
     */
    public int getInt() throws InvalidEnchantAction {
        throw new InvalidEnchantAction();
    }

    /**
     * This method retrieves a double of the enchant.
     */
    public double getDouble() throws InvalidEnchantAction {
        throw new InvalidEnchantAction();
    }

    /**
     * This method retrieves a float of the enchant.
     */
    public float getFloat() throws InvalidEnchantAction {
        throw new InvalidEnchantAction();
    }

    /**
     * This method retrieves a Location of the enchant.
     */
    public Location getLocation() throws InvalidEnchantAction {
        throw new InvalidEnchantAction();
    }

    /**
     * This method retrieves an object of the enchant.
     */
    public Object getObject() throws InvalidEnchantAction {
        throw new InvalidEnchantAction();
    }

}

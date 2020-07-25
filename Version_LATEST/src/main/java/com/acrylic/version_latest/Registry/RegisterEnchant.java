package com.acrylic.version_latest.Registry;

import com.acrylic.version_latest.EnchantAPI.AbstractEnchant;
import com.acrylic.version_latest.EnchantAPI.Creator.CustomEnchant;
import com.acrylic.version_latest.Items.ItemMaker.ItemType.ItemMainType;
import com.acrylic.version_latest.Items.ItemMaker.ItemType.ItemType;
import com.acrylic.version_latest.Registry.Exceptions.ClassDoesNotExtend;

import java.util.*;

/**
 * HOW TO REGISTER AN ENCHANT:
 * 1. Create a class that extends AbstractEnchant and implements CustomEnchant.
 * 2. Override (@Override) the enchant effects. (Read more under the AbstractEnchant class).
 * 3. Specify the properties under the Override methods. Please read the ItemType class
 * (interface) for more information on item types.
 * 4. To register the enchant, put the following method in your onEnable method in your main class:
 *        "RegisterEnchant.register();".
 */
public final class RegisterEnchant {

    /**
     * Caches.
     */
    private final static Map<String, ArrayList<CustomEnchant>> customEnchantMapByItemType = new HashMap<>(); //Item Type Enchant List Cache
    private final static Map<String, CustomEnchant> customEnchantMapByString = new HashMap<>(); //Enchant Cache

    /**
     *
     * @param enchant The enchantment name must be given in all CAPS. This is
     *                so there is a form of enchant getter without using extremely
     *                costly implementations.
     * @return The specified enchant.
     */
    public static CustomEnchant getEnchant(String enchant) {
        return customEnchantMapByString.get(enchant);
    }

    /**
     *
     * @param itemType Lists all the enchants registered under this item type.
     * @return List of enchants under the specified item type.
     */
    public static ArrayList<CustomEnchant> getEnchants(ItemType itemType) {
        ArrayList<CustomEnchant> list = customEnchantMapByItemType.get(itemType.getItemTypeName());
        return list == null ? new ArrayList<>() : list;
    }
    /**
     *
     * @param itemType String based item type. THIS IS CASE SENSITIVE!
     * @return List of enchants under the specified item type.
     */
    public static ArrayList<CustomEnchant> getEnchants(String itemType) {
        ArrayList<CustomEnchant> list = customEnchantMapByItemType.get(itemType);
        return list == null ? new ArrayList<>() : list;
    }

    /**
     * Put this method under the main class onEnable method.
     * @param customEnchant The custom enchant class.
     */
    public static void register(final CustomEnchant customEnchant) throws ClassDoesNotExtend {
        if (!(customEnchant instanceof AbstractEnchant)) {
            throw new ClassDoesNotExtend("Custom enchant classes MUST extend AbstractEnchant.","AbstractEnchant");
        }
        customEnchantMapByString.put(customEnchant.getName().toUpperCase(), customEnchant);
        customEnchant.getApplicable().forEach(itemType -> {
            if (itemType instanceof ItemMainType) {
                ((ItemMainType) itemType).getItemTypes().forEach(itemType1 -> {
                    addToItemTypeRegistry(itemType1, customEnchant);
                });
            } else {
                addToItemTypeRegistry(itemType, customEnchant);
            }
        });
    }

    /**
     * Use this method after all the enchant are registered.
     * PLEASE USE THIS OTHERWISE ENCHANT LISTS WILL BE MESSED UP!
     */
    public static void sort() {
        customEnchantMapByItemType.keySet().forEach(itemType -> {
            ArrayList<CustomEnchant> list = getEnchants(itemType);
            list.sort(new EnchantRaritySorter());
            customEnchantMapByItemType.put(itemType, list);
        });
    }

    /**
     *
     * @param itemType ItemType of the enchant.
     * @param customEnchant The enchant you want to register.
     */
    private static void addToItemTypeRegistry(ItemType itemType, CustomEnchant customEnchant) {
        ArrayList<CustomEnchant> list = getEnchants(itemType);
        if (!list.contains(customEnchant)) {
            list.add(customEnchant);
        }
        customEnchantMapByItemType.put(itemType.getItemTypeName(),list);
    }

    /**
     * Comparator/Sorter class.
     */
    private final static class EnchantRaritySorter implements Comparator<CustomEnchant> {
        @Override
        public int compare(CustomEnchant enchant1, CustomEnchant enchant2) {
            return enchant1.getRarity().getTier() - enchant2.getRarity().getTier();
        }
    }
}

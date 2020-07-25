package com.acrylic.version_latest.GlobalObjects;

import java.util.HashMap;

public class UtilityUser extends UserUtilityObject {

    /**
     * Utility User Cache
     */
    protected static HashMap<String, UtilityUser> utilityUserMap = new HashMap<>();

    /**
     * Methods to retrieve the EntityUser
     */
    public UtilityUser getUser(String name) {
        return utilityUserMap.get(name);
    }


    public UtilityUser(String playerName) {
        utilityUserMap.put(playerName,this);
    }








}

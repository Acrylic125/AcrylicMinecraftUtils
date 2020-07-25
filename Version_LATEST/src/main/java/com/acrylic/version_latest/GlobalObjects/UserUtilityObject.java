package com.acrylic.version_latest.GlobalObjects;

import com.acrylic.version_latest.Cooldowns.Cooldown;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

import java.util.Map;

@Getter @Setter
public class UserUtilityObject {

    private long lastUpdated = 0;

    private Map<String, Cooldown> cooldownMap;

    /**
     * For factory cache remover
     */
    public void setLastUpdated() {
        lastUpdated = System.currentTimeMillis();
    }

}

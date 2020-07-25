package com.acrylic.version_latest.Cooldowns;

public class CooldowObject {

    long expires;

    public CooldowObject(String cooldown, long expires) {
        this.expires = expires;
    }

    public boolean hasExpired() {
        return expires < System.currentTimeMillis();
    }

    public long timeMillsLeft() {
        return expires > System.currentTimeMillis() ? expires - System.currentTimeMillis() : 0;
    }

}

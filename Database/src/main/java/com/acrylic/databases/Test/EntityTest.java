package com.acrylic.databases.Test;

import com.acrylic.version_latest.Items.ItemCreator;
import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;

import java.util.List;

@Entity
public class EntityTest extends AbstractEntity{

    private String name;
    private List<String> accounts;
    @Embedded
    private ItemCreator address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }

    public ItemCreator getAddress() {
        return address;
    }

    public void setAddress(ItemCreator address) {
        this.address = address;
    }


}

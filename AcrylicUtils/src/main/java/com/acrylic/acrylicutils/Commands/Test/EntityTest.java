package com.acrylic.acrylicutils.Commands.Test;

import com.acrylic.version_latest.Items.ItemCreator;
import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;
import org.bson.types.ObjectId;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

@Entity("Entity")
public class EntityTest  {

    @Id
    private String isbn;
    private String title;
    private String author;
    @Property("price")
    private double cost;

    public EntityTest(String isbn, String title, String author, double cost) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.cost = cost;
    }
    // constructors, getters, setters and hashCode, equals, toString implementations

}

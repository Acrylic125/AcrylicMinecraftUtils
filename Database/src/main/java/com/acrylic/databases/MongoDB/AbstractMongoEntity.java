package com.acrylic.databases.MongoDB;

import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;
import lombok.Getter;
import org.bson.types.ObjectId;

/**
 * This is just a base entity class. As all morphia
 * entities must have an ID, this class is designed to providde
 * one.
 */
public class AbstractMongoEntity {

    @Getter
    @Id
    @Property("id")
    private ObjectId id;

}

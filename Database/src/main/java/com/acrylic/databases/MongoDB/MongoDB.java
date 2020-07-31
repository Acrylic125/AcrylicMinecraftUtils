package com.acrylic.databases.MongoDB;

import com.mongodb.MongoClient;
import dev.morphia.Morphia;
import lombok.Getter;

/**
 * For performance sakes, please only register this only ONCE
 * and cache it with as a singleton.
 */
@Getter
public class MongoDB {

    private Morphia morphia;
    private MongoClient client;

    public MongoDB(MongoClient mongoClient) {
        client = mongoClient;
        morphia = new Morphia();
    }

    public MongoDB registerEntity(Class<? extends AbstractMongoEntity> entityClass) {
        morphia.map(entityClass);
        return this;
    }

    public MongoDB registerEntities(Class<? extends AbstractMongoEntity> entityClasses) {
        morphia.map(entityClasses);
        return this;
    }


}

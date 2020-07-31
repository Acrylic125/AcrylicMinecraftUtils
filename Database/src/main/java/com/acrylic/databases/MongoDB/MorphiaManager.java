package com.acrylic.databases.MongoDB;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import lombok.Getter;

@Getter
public class MorphiaManager {

    private Datastore datastore;

    private MongoClient mongoClient;

    public MorphiaManager(MongoDB mongoDB) {
        mongoClient = mongoDB.getClient();

    }



}

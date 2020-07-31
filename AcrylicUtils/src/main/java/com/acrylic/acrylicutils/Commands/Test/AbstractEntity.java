package com.acrylic.acrylicutils.Commands.Test;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;
import dev.morphia.annotations.Version;
import org.bson.types.ObjectId;
 
public abstract class AbstractEntity {

    @Id
    @Property("id")
    protected ObjectId id;

    @Version
    @Property("version")
    private Long version;

    public AbstractEntity() {
        super();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


}

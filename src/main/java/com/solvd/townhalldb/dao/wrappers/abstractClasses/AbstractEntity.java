package com.solvd.townhalldb.dao.wrappers.abstractClasses;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class AbstractEntity {
    @XmlAttribute(name = "id")
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AbstractEntity(long id) {
        this.id = id;
    }

    public AbstractEntity(){}
}

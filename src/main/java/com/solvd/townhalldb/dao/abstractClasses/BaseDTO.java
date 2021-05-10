package com.solvd.townhalldb.dao.abstractClasses;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class BaseDTO {
    @XmlAttribute(name = "id")
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BaseDTO(long id) {
        this.id = id;
    }

    public BaseDTO(){}
}

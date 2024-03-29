package com.solvd.townhalldb.dao.models.misc;

import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class City extends AbstractEntity {
    @XmlElement(name = "name")
    private String name;

    public City(long id, String city) {
        super(id);
        this.name = city;
    }
    public City(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

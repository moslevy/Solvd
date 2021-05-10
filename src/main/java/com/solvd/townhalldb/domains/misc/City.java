package com.solvd.townhalldb.domains.misc;

import com.solvd.townhalldb.dao.abstractClasses.BaseDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class City extends BaseDTO {
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

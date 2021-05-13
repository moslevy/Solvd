package com.solvd.townhalldb.dao.models.buildings;

import com.solvd.townhalldb.dao.abstractClasses.BaseDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TownHall extends BaseDTO {
    @XmlElement(name = "county")
    private String county;

    public TownHall(){}

    public TownHall(long id, String county) {
        super(id);
        this.county = county;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}

package com.solvd.townhalldb.jaxb.wrappers.misc;


import com.solvd.townhalldb.jaxb.models.misc.City;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "cities")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cities {
    private final File FILE = new File("src/main/resources/xmls/jaxb/cities.xml");

    @XmlElement(name = "city")
    private List<City> citiesList = null;

    public File getFILE() {
        return FILE;
    }

    public List<City> getCitiesList() {
        return citiesList;
    }

    public void setCitiesList(List<City> citiesList) {
        this.citiesList = citiesList;
    }
}

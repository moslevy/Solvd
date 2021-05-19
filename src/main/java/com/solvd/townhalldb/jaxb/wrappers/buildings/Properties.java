package com.solvd.townhalldb.jaxb.wrappers.buildings;


import com.solvd.townhalldb.jaxb.models.buildings.Property;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "properties")
@XmlAccessorType(XmlAccessType.FIELD)
public class Properties {
    private final File FILE = new File("src/main/resources/xmls/jaxb/properties.xml");

    @XmlElement(name = "property")
    private List<Property> propertyList = null;

    public File getFILE() {
        return FILE;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }
}

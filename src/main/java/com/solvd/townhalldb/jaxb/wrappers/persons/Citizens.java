package com.solvd.townhalldb.jaxb.wrappers.persons;

import com.solvd.townhalldb.jaxb.models.persons.Citizen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Citizens {
    private final static File FILE = new File("src/main/resources/xmls/jaxb/citizens.xml");

    private List<Citizen> citizenList = null;

    public static File getFILE() {
        return FILE;
    }

    public List<Citizen> getCitizenList() {
        return citizenList;
    }

    public void setCitizenList(List<Citizen> citizenList) {
        this.citizenList = citizenList;
    }
}

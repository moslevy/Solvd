package com.solvd.townhalldb.jaxb.wrappers.misc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "telephones")
@XmlAccessorType(XmlAccessType.FIELD)
public class Telephones {
    private final File FILE = new File("src/main/resources/xmls/jaxb/telephones.xml");

    @XmlElement(name = "telephone")
    List<Telephones> telephonesList = null;

    public File getFILE() {
        return FILE;
    }

    public List<Telephones> getTelephonesList() {
        return telephonesList;
    }

    public void setTelephonesList(List<Telephones> telephonesList) {
        this.telephonesList = telephonesList;
    }
}

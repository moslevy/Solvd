package com.solvd.townhalldb.jaxb.wrappers.vehicles;

import com.solvd.townhalldb.jaxb.models.vehicles.SmogCheck;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "smogchecks")
@XmlAccessorType(XmlAccessType.FIELD)
public class SmogChecks {
    private static final File FILE = new File("src/main/resources/xmls/jaxb/smogchecks.xml");

    @XmlElement(name = "smogcheck")
    private List<SmogCheck> smogCheckList = null;

    public static File getFILE() {
        return FILE;
    }

    public List<SmogCheck> getSmogCheckList() {
        return smogCheckList;
    }

    public void setSmogCheckList(List<SmogCheck> smogCheckList) {
        this.smogCheckList = smogCheckList;
    }
}

package com.solvd.townhalldb.jaxb.wrappers.buildings;

import com.solvd.townhalldb.jaxb.models.buildings.Dmv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "dmvs")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dmvs {
    private final File FILE = new File("src/main/resources/xmls/jaxb/dmvs.xml");

    @XmlElement(name = "dmv")
    private List<Dmv> dmvList = null;

    public File getFILE() {
        return FILE;
    }

    public List<Dmv> getDmvList() {
        return dmvList;
    }

    public void setDmvList(List<Dmv> dmvList) {
        this.dmvList = dmvList;
    }
}

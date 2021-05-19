package com.solvd.townhalldb.jaxb.wrappers.misc;



import com.solvd.townhalldb.jaxb.models.misc.State;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "states")
@XmlAccessorType(XmlAccessType.FIELD)
public class States {
    private final File FILE = new File("src/main/resources/xmls/jaxb/states.xml");

    @XmlElement(name = "state")
    private List<State> stateList = null;

    public File getFILE() {
        return FILE;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }
}

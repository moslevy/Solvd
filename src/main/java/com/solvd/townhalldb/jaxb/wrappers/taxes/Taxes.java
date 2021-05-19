package com.solvd.townhalldb.jaxb.wrappers.taxes;


import com.solvd.townhalldb.jaxb.models.taxes.Tax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "taxes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Taxes {
    private final static File FILE = new File("src/main/resources/xmls/jaxb/taxes.xml");

    @XmlElement(name = "tax")
    private List<Tax> taxList = null;

    public static File getFILE() {
        return FILE;
    }

    public List<Tax> getTaxList() {
        return taxList;
    }

    public void setTaxList(List<Tax> taxList) {
        this.taxList = taxList;
    }
}

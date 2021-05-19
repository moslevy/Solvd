package com.solvd.townhalldb.jaxb.wrappers.vehicles;

import com.solvd.townhalldb.jaxb.models.vehicles.License;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "licenses")
@XmlAccessorType(XmlAccessType.FIELD)
public class Licenses {
    private static final File FILE = new File("src/main/resources/xmls/jaxb/licenses.xml");

    @XmlElement(name = "license")
    private List<License> licenseList = null;

    public static File getFILE() {
        return FILE;
    }

    public List<License> getLicenseList() {
        return licenseList;
    }

    public void setLicenseList(List<License> licenseList) {
        this.licenseList = licenseList;
    }
}

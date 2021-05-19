package com.solvd.townhalldb.jaxb.wrappers.taxes;

import com.solvd.townhalldb.jaxb.models.taxes.TaxBill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "taxbills")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaxBills {

    private static final File FILE = new File("src/main/resources/xmls/jaxb/taxbills.xml");

    @XmlElement(name = "taxbill")
    private List<TaxBill> taxBillList = null;

    public static File getFILE() {
        return FILE;
    }

    public List<TaxBill> getTaxBillList() {
        return taxBillList;
    }

    public void setTaxBillList(List<TaxBill> taxBillList) {
        this.taxBillList = taxBillList;
    }
}

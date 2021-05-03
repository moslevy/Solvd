package com.solvd.townhalldb.domains.taxes;

import com.solvd.townhalldb.dao.abstractClasses.BaseDTO;
import com.solvd.townhalldb.domains.buildings.Property;
import com.solvd.townhalldb.domains.buildings.TownHall;

public class TaxBill extends BaseDTO {

    private TownHall townHall;
    private Property property;


    public TaxBill(long id) {
        super(id);
    }

    public  TaxBill (){}

    public TownHall getTownHall() {
        return townHall;
    }

    public void setTownHall(TownHall townHall) {
        this.townHall = townHall;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}

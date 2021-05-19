package com.solvd.townhalldb.dao.models.taxes;

import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;
import com.solvd.townhalldb.dao.models.buildings.Property;
import com.solvd.townhalldb.dao.models.buildings.TownHall;

import java.util.Objects;

public class TaxBill extends AbstractEntity {

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

    @Override
    public String toString() {
        return "TaxBill{" +
                "id=" + id +
                ", townHall=" + townHall +
                ", property=" + property +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxBill taxBill = (TaxBill) o;
        return Objects.equals(getTownHall(), taxBill.getTownHall()) && Objects.equals(getProperty(), taxBill.getProperty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTownHall(), getProperty());
    }
}

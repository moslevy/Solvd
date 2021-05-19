package com.solvd.townhalldb.jaxb.services;


import com.solvd.townhalldb.jaxb.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.jaxb.dao.jaxb.impl.buildings.PropertyDAO;
import com.solvd.townhalldb.jaxb.dao.jaxb.impl.buildings.TownHallDAO;
import com.solvd.townhalldb.jaxb.dao.jaxb.impl.taxes.TaxBillDAO;
import com.solvd.townhalldb.jaxb.dao.jaxb.impl.taxes.TaxDAO;
import com.solvd.townhalldb.jaxb.models.buildings.Property;
import com.solvd.townhalldb.jaxb.models.buildings.TownHall;
import com.solvd.townhalldb.jaxb.models.taxes.Tax;
import com.solvd.townhalldb.jaxb.models.taxes.TaxBill;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TaxService extends AbstractJdbcDao {

    private final static Logger logger = LogManager.getLogger(TaxService.class);

    private final TownHallDAO townHallDAO = new TownHallDAO();
    private final TaxDAO taxDAO = new TaxDAO();
    private final TaxBillDAO taxBillDAO = new TaxBillDAO();
    private final PropertyDAO propertyDAO = new PropertyDAO();

    public void getTaxesById(long id) {
        TownHall townHall = townHallDAO.getById(id);
        townHall.setCounty("Los Angeles");
        Tax tax = taxDAO.getById(id);
        TaxBill taxBill = taxBillDAO.getById(tax.getTaxBill().getId());
        tax.setTaxBill(taxBill);
        Property property = propertyDAO.getById(taxBill.getProperty().getId());
        taxBill.setProperty(property);
        logger.info("Got Taxes by Id " + id + " in class " + tax.toString());
    }

    public void createTax(Tax tax) {

        tax.setTaxBill(taxBillDAO.getById(tax.getId()));
        taxDAO.create(tax);
        logger.info("Created tax in DB with id " + tax.getId());
    }

    public void update(Tax tax){
        taxDAO.update(tax);
        logger.info("Updated tax from DB with id " + tax.getId());
    }

    public void deleteTax(Tax tax) {
        taxDAO.delete(tax);
        logger.info("Deleted Tax with id " + tax.getId());
    }

    public Tax getById(long id){
        Tax tax = taxDAO.getById(id);
        logger.info("Got Tax from DB with the following information: " + tax.toString());
        return tax;
    }

}

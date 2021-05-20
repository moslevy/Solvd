package com.solvd.townhalldb.jackson.services;


import com.solvd.townhalldb.jackson.impl.buildings.PropertyDAO;
import com.solvd.townhalldb.jackson.impl.buildings.TownHallDAO;
import com.solvd.townhalldb.jackson.impl.taxes.TaxBillDAO;
import com.solvd.townhalldb.jackson.models.buildings.Property;
import com.solvd.townhalldb.jackson.models.buildings.TownHall;
import com.solvd.townhalldb.jackson.models.taxes.TaxBill;
import com.solvd.townhalldb.jaxb.abstractClasses.AbstractJdbcDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TaxBillService extends AbstractJdbcDao {

    private final static Logger logger = LogManager.getLogger(TaxBillService.class);

    private final TaxBillDAO taxBillDAO = new TaxBillDAO();
    private final TownHallDAO townHallDAO = new TownHallDAO();
    private final PropertyDAO propertyDAO = new PropertyDAO();

    public TaxBill getTaxBillById(long id){
        TaxBill taxBill = taxBillDAO.getById(id);
        TownHall townHall = townHallDAO.getById(taxBill.getId());
        Property property = propertyDAO.getById(taxBill.getId());
        taxBill.setTownHall(townHall);
        taxBill.setProperty(property);
        return taxBill;
    }

    public void create(TaxBill taxBill ){
        taxBillDAO.create(taxBill);
        logger.info("Created TaxBill with id " + taxBill.getId());
    }

    public void update(TaxBill taxBill){
        taxBillDAO.update(taxBill);
        logger.info("Updated TaxBill with id " + taxBill.getId());
    }

    public void delete(TaxBill taxBill){
        taxBillDAO.delete(taxBill);
        logger.info("Deleted TaxBill with id " + taxBill.getId());
    }
}

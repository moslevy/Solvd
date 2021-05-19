package com.solvd.townhalldb.dao.services;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.jdbc.buildings.PropertyDAO;
import com.solvd.townhalldb.dao.jdbc.buildings.TownHallDAO;
import com.solvd.townhalldb.dao.jdbc.taxes.TaxBillDAO;
import com.solvd.townhalldb.dao.models.buildings.Property;
import com.solvd.townhalldb.dao.models.buildings.TownHall;
import com.solvd.townhalldb.dao.models.taxes.TaxBill;
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

package com.example.hw3.townhallinterfaces.classcreation;

import com.example.hw3.townhallinterfaces.TownHallTest;
import com.example.hw3.townhallinterfaces.models.taxes.CommercialTax;
import com.example.hw3.townhallinterfaces.models.taxes.ResidentialTax;
import com.example.hw3.townhallinterfaces.models.taxes.Tax;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClassCreation {

    private static final Logger logger = LogManager.getLogger(TownHallTest.class);

    public static ResidentialTax createResidentialTax() {
        logger.info("Created residential taxes in: " + ClassCreation.class);
       return new ResidentialTax(2f, 1.4f, true, 0.78f, 0.1f);
    }

    public static CommercialTax createCommercialTax(){
        logger.info("Created commercial taxes in: " + ClassCreation.class);
        return new CommercialTax(2.5f, 1.8f, true, 0.98f, 1.1f, 8.0f);
    }




}

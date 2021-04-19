package com.example.hw6.enums;

import com.example.hw3.townhallinterfaces.models.properties.Residential;
import com.example.hw3.townhallinterfaces.models.taxes.ResidentialTax;
import com.example.hw4.models.properties.Property;
import com.example.hw4.models.taxes.Tax;

public enum Usuarios {
    RESIDENTIAL{
        public void calculateTaxes(){
            //do something with taxes
        }
    }, COMMERCIAL{
        public void calculateTaxes(){
            //do something with taxes
        }
    }
}

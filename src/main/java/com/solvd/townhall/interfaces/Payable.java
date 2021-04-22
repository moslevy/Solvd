package com.solvd.townhall.interfaces;

import com.solvd.townhall.models.people.Person;
import com.solvd.townhall.models.properties.Property;

public interface Payable {
    public float paymentDue(Property property);
}

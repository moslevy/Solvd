package com.solvd.townhalldb.utils;

import com.solvd.townhalldb.dao.models.buildings.TownHall;
import com.solvd.townhalldb.dao.models.persons.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParser {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        TownHall townHall = (TownHall) unmarshaller.unmarshal(new File("/Users/mlevy/Projects/Solvd/src/main/resources/parsers/dom/dbSchema.xml"));
        System.out.println(townHall.toString());
    }
}
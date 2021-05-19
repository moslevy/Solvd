package com.solvd.townhalldb.parsers;


import com.solvd.townhalldb.jaxb.wrappers.persons.Employees;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxBParser {

    private final static Logger logger = LogManager.getLogger(JaxBParser.class);

    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Employees employees = (Employees) unmarshaller.unmarshal(new File("src/main/resources/parsers/jaxb/employees.xml"));
            logger.info("Unmarshalled file Employees.xml.");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

package com.solvd.townhalldb.parsers;


import com.solvd.townhalldb.dao.models.persons.Employee;
import com.solvd.townhalldb.dao.wrappers.persons.Employees;
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
            Employee employee = (Employee) unmarshaller.unmarshal(new File("src/main/resources/parsers/jaxb/employees.xml"));
            logger.info("Unmarshalled file dbSchema.xml utilizing JaxB " + employee.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

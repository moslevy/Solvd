package com.solvd.townhalldb.jaxb.dao.jaxb.impl.buildings;


import com.solvd.townhalldb.jaxb.dao.interfaces.buildings.ITownHallDAO;
import com.solvd.townhalldb.jaxb.models.buildings.TownHall;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.File;

public class TownHallDAO implements ITownHallDAO {
    private static final Logger logger = (Logger) LogManager.getLogger(TownHallDAO.class);
    private static final File FILE = new File("src/main/resources/xml/townhall.xml");


    @Override
    public void create(TownHall entity) {
        TownHall townHall = new TownHall();
        townHall.setId(entity.getId());
        townHall.setCounty(entity.getCounty());
        townHall.setEmployeeList(entity.getEmployeeList());
    }

    @Override
    public void update(TownHall entity) {

    }

    @Override
    public TownHall getById(long id) {
        return null;
    }

    @Override
    public void delete(TownHall entity) {

    }


    private static synchronized TownHall unmarshall() {
        TownHall townHall = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TownHall.class);
            Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
            townHall = (TownHall) jaxUnmarshaller.unmarshal(FILE);
        } catch (JAXBException e) {
            logger.error(e);
        }
        return townHall;
    }

    private static synchronized void marshall(TownHall townHall) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TownHall.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(townHall, FILE);
        } catch (JAXBException e) {
            logger.error(e);
        }
    }


}

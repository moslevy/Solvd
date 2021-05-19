package com.solvd.townhalldb.jaxb.dao.jaxb.impl.persons;

import com.solvd.townhalldb.jaxb.dao.interfaces.persons.ICitizenDAO;
import com.solvd.townhalldb.jaxb.models.persons.Citizen;
import com.solvd.townhalldb.jaxb.wrappers.misc.Cities;
import com.solvd.townhalldb.jaxb.wrappers.persons.Citizens;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class CitizenDAO implements ICitizenDAO {
    private static final Logger logger = (Logger) LogManager.getLogger(CitizenDAO.class);
    private static final File FILE = new File("src/main/resources/xmls/jaxb/citizens.xml");

    @Override
    public void create(Citizen citizen) {
        Citizens citizens = new Citizens();
        citizens.setCitizenList(unmarshall());
        citizens.getCitizenList().add(citizen);
        marshall(citizens);
    }

    @Override
    public void update(Citizen citizen) {
        Citizens citizens = new Citizens();
        citizens.setCitizenList(unmarshall());
        citizens.getCitizenList().stream()
                .filter(citizenStream -> citizenStream.getId() == citizen.getId())
                .findAny()
                .ifPresent(editCitizen -> editCitizen.setId(citizen.getId()));
        marshall(citizens);

    }

    @Override
    public Citizen getById(long id) {
        Citizens citizens = new Citizens();
        citizens.setCitizenList(unmarshall());
        return citizens.getCitizenList().stream()
                .filter(citizen -> citizen.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void delete(Citizen citizen) {
        Citizens citizens = new Citizens();
        citizens.setCitizenList(unmarshall());
        citizens.getCitizenList().stream()
                .filter(citizenStream -> citizenStream.getId() == citizen.getId())
                .findAny()
                .ifPresent(editCitizen -> citizens.getCitizenList().remove(editCitizen));
    }

    private static synchronized List<Citizen> unmarshall() {
        Citizens citizens = new Citizens();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Citizens.class);
            Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
            citizens = (Citizens) jaxUnmarshaller.unmarshal(FILE);
        } catch (JAXBException e) {
            logger.error(e);
        }
        return citizens.getCitizenList();
    }

    private static synchronized void marshall(Citizens citizens) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Cities.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(citizens, FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

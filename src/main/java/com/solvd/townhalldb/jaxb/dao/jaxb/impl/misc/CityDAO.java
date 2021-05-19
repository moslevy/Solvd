package com.solvd.townhalldb.jaxb.dao.jaxb.impl.misc;

import com.solvd.townhalldb.jaxb.dao.interfaces.misc.ICityDAO;
import com.solvd.townhalldb.jaxb.dao.jaxb.impl.buildings.DmvDAO;
import com.solvd.townhalldb.jaxb.models.misc.City;
import com.solvd.townhalldb.jaxb.wrappers.misc.Cities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class CityDAO  implements ICityDAO {

    private static final Logger logger = (Logger) LogManager.getLogger(DmvDAO.class);
    private static final File FILE = new File("src/main/resources/xmls/jaxb/cities.xml");

    @Override
    public void create(City city) {
        Cities cities = new Cities();
        cities.setCitiesList(unmarshall());
        cities.getCitiesList().add(city);
    }

    @Override
    public void update(City city) {
        Cities cities = new Cities();
        cities.setCitiesList(unmarshall());
        cities.getCitiesList().stream()
                .filter(cityStream -> cityStream.getId() == city.getId())
                .findAny()
                .ifPresent(editCity -> editCity.setId(city.getId()));
        marshall(cities);
    }

    @Override
    public City getById(long id) {
        Cities cities = new Cities();
        cities.setCitiesList(unmarshall());
        return cities.getCitiesList().stream()
                .filter(city -> city.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void delete(City city) {
        Cities cities = new Cities();
        cities.setCitiesList(unmarshall());
        cities.getCitiesList().stream()
                .filter(cityStream -> cityStream.getId() == city.getId())
                .findAny()
                .ifPresent(editCity -> cities.getCitiesList().remove(editCity));

    }


    private static synchronized List<City> unmarshall() {
        Cities cities = new Cities();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Cities.class);
            Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
            cities = (Cities) jaxUnmarshaller.unmarshal(FILE);
        } catch (JAXBException e) {
            logger.error(e);
        }
        return cities.getCitiesList();
    }

    private static synchronized void marshall(Cities cities) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Cities.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(cities, FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}


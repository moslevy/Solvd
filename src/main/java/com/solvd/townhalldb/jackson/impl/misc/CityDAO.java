package com.solvd.townhalldb.jackson.impl.misc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.townhalldb.jackson.interfaces.misc.ICityDAO;
import com.solvd.townhalldb.jackson.models.misc.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements ICityDAO {

    private static final Logger logger = LogManager.getLogger(CityDAO.class);
    private static final File FILE = new File("src/main/resources/jsons/cities.json");
    List<City> cityList = new ArrayList<City>();

    @Override
    public void create(City city) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            cityList = objectMapper.readValue(FILE, new TypeReference<List<City>>() {
            });
            cityList.add(city);
            objectMapper.writeValue(FILE, cityList);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void update(City city) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            cityList = objectMapper.readValue(FILE, new TypeReference<List<City>>(){});
            cityList.stream()
                    .filter(dmvElement -> dmvElement.getId() == city.getId())
                    .findAny()
                    .ifPresent(updateDmv -> updateDmv.setId(city.getId()));
            objectMapper.writeValue(FILE, cityList);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public City getById(long id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            cityList = objectMapper.readValue(FILE, new TypeReference<List<City>>(){});
        } catch (IOException e) {
            logger.error(e);
        }
        return cityList.stream().filter(dmv -> dmv.getId() == id).findAny().orElse(null);
    }

    @Override
    public void delete(City city) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            cityList = objectMapper.readValue(FILE, new TypeReference<List<City>>(){});
            cityList.stream()
                    .filter(propElement -> propElement.getId() == city.getId())
                    .findAny()
                    .ifPresent(deleteProp -> cityList.remove(deleteProp));
        } catch (IOException e){
            logger.error(e);
        }
    }
}

package com.solvd.townhalldb.jackson.impl.buildings;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.townhalldb.jackson.interfaces.buildings.IPropertyDAO;
import com.solvd.townhalldb.jackson.models.buildings.Property;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PropertyDAO implements IPropertyDAO {

    private static final Logger logger = LogManager.getLogger(PropertyDAO.class);
    private static final File FILE = new File("src/main/resources/jsons/properties.json");
    List<Property> propertyList = new ArrayList<Property>();

    @Override
    public void create(Property property) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            propertyList = objectMapper.readValue(FILE, new TypeReference<List<Property>>() {
            });
            propertyList.add(property);
            objectMapper.writeValue(FILE, propertyList);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void update(Property property) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            propertyList = objectMapper.readValue(FILE, new TypeReference<List<Property>>(){});
            propertyList.stream()
                    .filter(dmvElement -> dmvElement.getId() == property.getId())
                    .findAny()
                    .ifPresent(updateDmv -> updateDmv.setId(property.getId()));
            objectMapper.writeValue(FILE, propertyList);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public Property getById(long id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            propertyList = objectMapper.readValue(FILE, new TypeReference<List<Property>>(){});
        } catch (IOException e) {
            logger.error(e);
        }
        return propertyList.stream().filter(dmv -> dmv.getId() == id).findAny().orElse(null);
    }

    @Override
    public void delete(Property property) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            propertyList = objectMapper.readValue(FILE, new TypeReference<List<Property>>(){});
            propertyList.stream()
                    .filter(propElement -> propElement.getId() == property.getId())
                    .findAny()
                    .ifPresent(deleteProp -> propertyList.remove(deleteProp));
        } catch (IOException e){
            logger.error(e);
        }
    }
}

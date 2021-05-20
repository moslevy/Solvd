package com.solvd.townhalldb.jackson.impl.taxes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.townhalldb.jackson.impl.persons.EmployeeDAO;
import com.solvd.townhalldb.jackson.interfaces.taxes.ITaxDAO;
import com.solvd.townhalldb.jackson.models.taxes.Tax;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaxDAO implements ITaxDAO {

    private static final Logger logger = LogManager.getLogger(EmployeeDAO.class);
    private static final File FILE = new File("src/main/resources/jsons/taxes.json");
    List<Tax> list = new ArrayList<Tax>();
    @Override
    public void create(Tax entity) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(FILE, new TypeReference<List<Tax>>() {
            });
            list.add(entity);
            objectMapper.writeValue(FILE, list);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void update(Tax entity) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(FILE, new TypeReference<List<Tax>>() {
            });
            list.stream()
                    .filter(entityElement -> entityElement.getId() == entity.getId())
                    .findAny()
                    .ifPresent(updateEntity -> updateEntity.setId(entity.getId()));
            objectMapper.writeValue(FILE, list);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public Tax getById(long id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(FILE, new TypeReference<List<Tax>>() {
            });
        } catch (IOException e) {
            logger.error(e);
        }
        return list.stream().filter(entity -> entity.getId() == id).findAny().orElse(null);
    }

    @Override
    public void delete(Tax entity) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(FILE, new TypeReference<List<Tax>>() {
            });
            list.stream()
                    .filter(entityElement -> entityElement.getId() == entity.getId())
                    .findAny()
                    .ifPresent(deleteEntity -> list.remove(deleteEntity));
        } catch (IOException e) {
            logger.error(e);
        }
    }
}

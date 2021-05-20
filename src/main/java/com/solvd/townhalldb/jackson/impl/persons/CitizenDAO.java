package com.solvd.townhalldb.jackson.impl.persons;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.townhalldb.jackson.interfaces.persons.ICitizenDAO;
import com.solvd.townhalldb.jackson.models.persons.Citizen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CitizenDAO implements ICitizenDAO {

    private static final Logger logger = LogManager.getLogger(CitizenDAO.class);
    private static final File FILE = new File("src/main/resources/jsons/citizens.json");
    List<Citizen> list = new ArrayList<Citizen>();

    @Override
    public void create(Citizen entity) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(FILE, new TypeReference<List<Citizen>>() {
            });
            list.add(entity);
            objectMapper.writeValue(FILE, list);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void update(Citizen entity) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(FILE, new TypeReference<List<Citizen>>() {
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
    public Citizen getById(long id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(FILE, new TypeReference<List<Citizen>>() {
            });
        } catch (IOException e) {
            logger.error(e);
        }
        return list.stream().filter(entity -> entity.getId() == id).findAny().orElse(null);
    }

    @Override
    public void delete(Citizen entity) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(FILE, new TypeReference<List<Citizen>>() {
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

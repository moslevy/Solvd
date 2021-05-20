package com.solvd.townhalldb.jackson.impl.vehicles;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.townhalldb.jackson.impl.persons.EmployeeDAO;
import com.solvd.townhalldb.jackson.interfaces.vehicles.IVehicleDAO;
import com.solvd.townhalldb.jackson.models.vehicles.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO implements IVehicleDAO {

    private static final Logger logger = LogManager.getLogger(EmployeeDAO.class);
    private static final File FILE = new File("src/main/resources/jsons/vehicles.json");
    List<Vehicle> list = new ArrayList<Vehicle>();

    @Override
    public void create(Vehicle entity) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(FILE, new TypeReference<List<Vehicle>>() {
            });
            list.add(entity);
            objectMapper.writeValue(FILE, list);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void update(Vehicle entity) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(FILE, new TypeReference<List<Vehicle>>() {
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
    public Vehicle getById(long id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(FILE, new TypeReference<List<Vehicle>>() {
            });
        } catch (IOException e) {
            logger.error(e);
        }
        return list.stream().filter(entity -> entity.getId() == id).findAny().orElse(null);
    }

    @Override
    public void delete(Vehicle entity) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(FILE, new TypeReference<List<Vehicle>>() {
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

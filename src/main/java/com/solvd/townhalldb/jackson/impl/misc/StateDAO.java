package com.solvd.townhalldb.jackson.impl.misc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.townhalldb.jackson.impl.buildings.PropertyDAO;
import com.solvd.townhalldb.jackson.interfaces.misc.IStateDAO;
import com.solvd.townhalldb.jackson.models.buildings.Dmv;
import com.solvd.townhalldb.jackson.models.buildings.Property;
import com.solvd.townhalldb.jackson.models.misc.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateDAO implements IStateDAO {

    private static final Logger logger = LogManager.getLogger(PropertyDAO.class);
    private static final File FILE = new File("src/main/resources/jsons/states.json");
    List<State> stateList = new ArrayList<State>();

    @Override
    public void create(State state) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            stateList = objectMapper.readValue(FILE, new TypeReference<List<Property>>() {
            });
            stateList.add(state);
            objectMapper.writeValue(FILE, stateList);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void update(State state) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            stateList = objectMapper.readValue(FILE, new TypeReference<List<Dmv>>() {
            });
            stateList.stream()
                    .filter(stateElement -> stateElement.getId() == state.getId())
                    .findAny()
                    .ifPresent(updateState -> updateState.setId(state.getId()));
            objectMapper.writeValue(FILE, stateList);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public State getById(long id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            stateList = objectMapper.readValue(FILE, new TypeReference<List<Property>>() {
            });
        } catch (IOException e) {
            logger.error(e);
        }
        return stateList.stream().filter(state -> state.getId() == id).findAny().orElse(null);
    }

    @Override
    public void delete(State state) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            stateList = objectMapper.readValue(FILE, new TypeReference<List<State>>() {
            });
            stateList.stream()
                    .filter(stateElement -> stateElement.getId() == state.getId())
                    .findAny()
                    .ifPresent(deleteState -> stateList.remove(deleteState));
        } catch (IOException e) {
            logger.error(e);
        }
    }
}

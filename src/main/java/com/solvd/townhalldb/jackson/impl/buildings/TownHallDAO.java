package com.solvd.townhalldb.jackson.impl.buildings;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.townhalldb.jackson.interfaces.buildings.ITownHallDAO;
import com.solvd.townhalldb.jackson.models.buildings.TownHall;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class TownHallDAO implements ITownHallDAO {

    private static final Logger logger = LogManager.getLogger(TownHallDAO.class);
    private static final File FILE = new File("src/main/resources/jsons/townhall.json");
    TownHall townHall = new TownHall();

    @Override
    public void create(TownHall townHall) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            townHall = objectMapper.readValue(FILE, new TypeReference<TownHall>() {
            });
            objectMapper.writeValue(FILE, townHall);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void update(TownHall townHall) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.townHall = objectMapper.readValue(FILE, new TypeReference<TownHall>(){});
            objectMapper.writeValue(FILE, townHall);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public TownHall getById(long id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.townHall = objectMapper.readValue(FILE, new TypeReference<TownHall>(){});
        } catch (IOException e) {
            logger.error(e);
        }
        TownHall returnTownHall = new TownHall();
        returnTownHall.setId(id);
        return returnTownHall;
    }

    @Override
    public void delete(TownHall townHall) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.townHall = objectMapper.readValue(FILE, new TypeReference<TownHall>(){});
            townHall.setId(0);
            townHall.setCounty("");
            townHall.setEmployeeList(Collections.emptyList());
        } catch (IOException e){
            logger.error(e);
        }
    }
}

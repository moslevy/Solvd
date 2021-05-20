package com.solvd.townhalldb.jackson;

import com.solvd.townhalldb.jackson.impl.buildings.TownHallDAO;
import com.solvd.townhalldb.jackson.models.buildings.TownHall;
import com.solvd.townhalldb.jackson.services.VehicleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger logger = LogManager.getLogger(VehicleService.class);

    public static void main(String[] args) {

        TownHallDAO townHallDAO = new TownHallDAO();
        TownHall townHall = new TownHall(200, "Los Angeles");

        townHallDAO.create(townHall);

        townHall.setId(400);
        townHall.setCounty("Columbus");
        townHallDAO.update(townHall);

        townHallDAO.delete(townHall);

        logger.info(townHall.toString());
        System.out.println(townHall.toString());

    }
}

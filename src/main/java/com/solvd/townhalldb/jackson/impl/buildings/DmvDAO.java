package com.solvd.townhalldb.jackson.impl.buildings;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.townhalldb.jackson.interfaces.buildings.IDmvDAO;
import com.solvd.townhalldb.jackson.models.buildings.Dmv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DmvDAO implements IDmvDAO {
    private static final Logger logger = LogManager.getLogger(DmvDAO.class);
    private static final File FILE = new File("src/main/resources/jsons/dmvs.json");
    List<Dmv> dmvList = new ArrayList<Dmv>();

    @Override
    public void create(Dmv dmv) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            dmvList = objectMapper.readValue(FILE, new TypeReference<List<Dmv>>() {
            });
            dmvList.add(dmv);
            objectMapper.writeValue(FILE, dmvList);
        } catch (IOException e) {
            logger.error(e);
        }

    }

    @Override
    public void update(Dmv dmv) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            dmvList = objectMapper.readValue(FILE, new TypeReference<List<Dmv>>(){});
            dmvList.stream()
                    .filter(dmvElement -> dmvElement.getId() == dmv.getId())
                    .findAny()
                    .ifPresent(updateDmv -> updateDmv.setId(dmv.getId()));
            objectMapper.writeValue(FILE, dmvList);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public Dmv getById(long id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            dmvList = objectMapper.readValue(FILE, new TypeReference<List<Dmv>>(){});
        } catch (IOException e) {
            logger.error(e);
        }
        return dmvList.stream().filter(dmv -> dmv.getId() == id).findAny().orElse(null);
    }

    @Override
    public void delete(Dmv dmv) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            dmvList = objectMapper.readValue(FILE, new TypeReference<List<Dmv>>(){});
            dmvList.stream()
                    .filter(dmvElement -> dmvElement.getId() == dmv.getId())
                    .findAny()
                    .ifPresent(deleteDmv -> dmvList.remove(deleteDmv));
        } catch (IOException e){
            logger.error(e);
        }
    }
}

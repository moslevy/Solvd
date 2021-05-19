package com.solvd.townhalldb.jaxb.dao.jaxb.impl.misc;

import com.solvd.townhalldb.jaxb.dao.interfaces.misc.IStateDAO;
import com.solvd.townhalldb.jaxb.models.misc.State;
import com.solvd.townhalldb.jaxb.wrappers.misc.Cities;
import com.solvd.townhalldb.jaxb.wrappers.misc.States;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class StateDAO implements IStateDAO {
    private static final Logger logger = (Logger) LogManager.getLogger(StateDAO.class);
    private static final File FILE = new File("src/main/resources/xmls/jaxb/states.xml");

    @Override
    public void create(State state) {
        States states = new States();
        states.setStateList(unmarshall());
        states.getStateList().add(state);
        marshall(states);
    }

    @Override
    public void update(State state) {
        States states = new States();
        states.setStateList(unmarshall());
        states.getStateList().stream()
                .filter(stateStream -> stateStream.getId() == state.getId())
                .findAny()
                .ifPresent(editState -> editState.setId(state.getId()));
        marshall(states);
    }

    @Override
    public State getById(long id) {
        States states = new States();
        states.setStateList(unmarshall());
        return states.getStateList().stream()
                .filter(state -> state.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void delete(State state) {
        States states = new States();
        states.setStateList(unmarshall());
        states.getStateList().stream()
                .filter(stateStream -> stateStream.getId() == state.getId())
                .findAny()
                .ifPresent(editState -> states.getStateList().remove(editState));
    }

    private static synchronized List<State> unmarshall() {
        States states = new States();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(States.class);
            Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
            states = (States) jaxUnmarshaller.unmarshal(FILE);
        } catch (JAXBException e) {
            logger.error(e);
        }
        return states.getStateList();
    }

    private static synchronized void marshall(States states) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Cities.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(states, FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

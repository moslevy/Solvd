package com.solvd.townhalldb.jaxb.dao.jaxb.impl.buildings;


import com.solvd.townhalldb.jaxb.dao.interfaces.buildings.IDmvDAO;
import com.solvd.townhalldb.jaxb.models.buildings.Dmv;
import com.solvd.townhalldb.jaxb.wrappers.buildings.Dmvs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class DmvDAO implements IDmvDAO {

    private static final Logger logger = (Logger) LogManager.getLogger(DmvDAO.class);
    private static final File FILE = new File("src/main/resources/xmls/jaxb/dmvs.xml");


    @Override
    public void create(Dmv dmv) {
        Dmvs dmvs = new Dmvs();
        dmvs.setDmvList(unmarshall());
        dmvs.getDmvList().add(dmv);
    }

    @Override
    public void update(Dmv dmv) {
        Dmvs dmvs = new Dmvs();
        dmvs.setDmvList(unmarshall());
        dmvs.getDmvList().stream()
                .filter(dmvStream -> dmvStream.getId() == dmv.getId())
                .findAny()
                .ifPresent(editDmv -> editDmv.setId(dmv.getId()));
        marshall(dmvs);
    }

    @Override
    public Dmv getById(long id) {
        Dmvs dmvs = new Dmvs();
        dmvs.setDmvList(unmarshall());
        return dmvs.getDmvList().stream()
                .filter(dmv -> dmv.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void delete(Dmv dmv) {
        Dmvs dmvs = new Dmvs();
        dmvs.setDmvList(unmarshall());
        dmvs.getDmvList().stream()
                .filter(dmvStream -> dmvStream.getId() == dmv.getId())
                .findAny()
                .ifPresent(editDmv -> dmvs.getDmvList().remove(editDmv));
        marshall(dmvs);
    }

    private static synchronized List<Dmv> unmarshall() {
        Dmvs dmvs = new Dmvs();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Dmvs.class);
            Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
            dmvs = (Dmvs) jaxUnmarshaller.unmarshal(FILE);
        } catch (JAXBException e) {
            logger.error(e);
        }
        return dmvs.getDmvList();
    }

    private static synchronized void marshall(Dmvs dmvs) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Dmvs.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(dmvs, FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}

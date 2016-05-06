package univ.rest.controller;

import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.xml.sax.InputSource;
import univ.rest.config.MongoDBJDBC;
import univ.rest.config.ValidateXML;
import univ.rest.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;

@RestController
public class STBController {

    @RequestMapping(value = "/resume")
    public ResponseEntity<STBLiteList> getAllSTBs() {
        STBLiteList stbs = MongoDBJDBC.getMongoSTBList();

        if (stbs.getSTBs().size() > 0) {
            return new ResponseEntity<STBLiteList>(stbs, HttpStatus.OK);
        }

        return new ResponseEntity<STBLiteList>(stbs, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/resume/{id}")
    public ResponseEntity<STB> getSTBById(@PathVariable("id") String id) {
        STB stb = MongoDBJDBC.getMongoSTBList(id);

        if (stb != null) {
            return new ResponseEntity<STB>(stb, HttpStatus.OK);
        }

        return new ResponseEntity(stb, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/depot", headers = "Accept=application/xml")
    public ResponseEntity insertSTB(@RequestBody STB stb) {

        boolean validate = true;
<<<<<<< HEAD:rest/src/main/java/univ/rest/controller/STBController.java
        stb.setId("id static");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(STB.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter xmlStr = new StringWriter();
            jaxbMarshaller.marshal(stb, xmlStr);

            validate = ValidateXML.should_validate_with_DOM(xmlStr);

        } catch (JAXBException e) {
            return new ResponseEntity("Erreur lors de la validation !", HttpStatus.BAD_REQUEST);
        }

        if (validate) {
            if (MongoDBJDBC.insertMongoSTB(stb)) {
=======

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(STB.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter xmlStr = new StringWriter();
            jaxbMarshaller.marshal(stb, xmlStr);

            validate = new ValidateXML().should_validate_with_DOM(xmlStr);

        } catch (JAXBException e) {
            System.out.println(e);
            return new ResponseEntity("Erreur lors de la validation !", HttpStatus.BAD_REQUEST);
        }

        if (validate) {

            if (new MongoDBJDBC().insertMongoSTB(stb)) {
>>>>>>> b1a6984842496d8cff5fe6f94d2a39d0f1fc9af3:src/main/java/univ/rest/controller/STBController.java
                return new ResponseEntity("STB d'id " + stb.getId() + " déposée.", HttpStatus.OK);
            } else {
                return new ResponseEntity("Erreur lors de l'insertion !", HttpStatus.BAD_REQUEST);
            }

        } else {
            return new ResponseEntity("Votre source ne passe pas la validation XSD.", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}

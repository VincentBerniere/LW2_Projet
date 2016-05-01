package univ.rest.controller;

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

import univ.rest.config.MongoDBJDBC;
import univ.rest.model.*;

@RestController
public class STBController {
	
	@RequestMapping(value = "/resume")
    public ResponseEntity<STBLiteList> getAllSTBs()
    {
        STBLiteList stbs = new MongoDBJDBC().getMongoSTBList();

        if (stbs.getSTBs().size()>0) {
            return new ResponseEntity<STBLiteList>(stbs, HttpStatus.OK);
        }

        return new ResponseEntity<STBLiteList>(stbs, HttpStatus.BAD_REQUEST);
    }
     
    @RequestMapping(value = "/resume/{id}")
    public ResponseEntity<STB> getSTBById (@PathVariable("id") int id) 
    {
        STB stb = new MongoDBJDBC().getMongoSTBList(id);

        if (stb != null) {
            return new ResponseEntity<STB>(stb, HttpStatus.OK);
        }

        stb.setClient(null);
        stb.setEquipe(null);
        stb.setFonctionnalite(null);
        return new ResponseEntity(stb, HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/depot", headers="Accept=application/xml")
    public String insertSTB(@RequestBody STB stb) {

        if(new MongoDBJDBC().insertMongoSTB(stb)) {
            return "<h1>STB déposée !</h1>" +
                    "<p>Numéro d'identification : "+new MongoDBJDBC().getMongoSTBListSize()+"</p>";
        } else {
            return "<h1>Erreur lors de l'insertion !</h1>";
        }
    }
}

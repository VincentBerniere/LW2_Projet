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
    public ResponseEntity<STBList> getAllSTBs() 
    {
        STBList stbs = new MongoDBJDBC().getMongoSTBList();

        if (stbs.getSTBs().size()>0) {
            return new ResponseEntity<STBList>(stbs, HttpStatus.OK);
        }

        return new ResponseEntity<STBList>(stbs, HttpStatus.BAD_REQUEST);
    }
     
    @RequestMapping(value = "/resume/{id}")
    public ResponseEntity<STB> getSTBById (@PathVariable("id") int id) 
    {
        STB stb = new MongoDBJDBC().getMongoSTBList(id);

        if (stb != null) {
            return new ResponseEntity<STB>(stb, HttpStatus.OK);
        }
        
        return new ResponseEntity(stb, HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/depot", headers="Accept=application/xml")
    public String insertSTB(@RequestBody STB stb) {
        STBList stbs = new MongoDBJDBC().getMongoSTBList();

        if (stbs.getSTBs().size() == 0) {
            stb.setId(1);
        }
        else {
            stb.setId(new MongoDBJDBC().getMongoSTBList().getSTBs().size()+1);
        }


        if(new MongoDBJDBC().insertMongoSTB(stb) == "") {
            return "<h1>STB déposée !</h1>" +
                    "<p>Numéro d'identification : "+stb.getId()+"</p>";
        } else {
            return "<h1>Erreur lors de l'insertion !</h1><p>"+new MongoDBJDBC().insertMongoSTB(stb)+"</p>";
        }
    }
}

package univ.rest.controller;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import univ.rest.model.STB;
import univ.rest.model.STBList;

@RestController
public class STBController {
	
	@RequestMapping(value = "/STB/resume")
    public ResponseEntity<STBList> getAllSTBs() 
    {
        STBList stbs = new STBList();
         
        STB stb1 = new STB(1,"Amical GIL","2.2", new Date(), "Réseau social pour les étudiants en GIL");
        STB stb2 = new STB(2,"Queazy","1.0", new Date(), "Plateforme de quiz");
        STB stb3 = new STB(3,"Close","1.5", new Date(), "Algo en Fdd");
         
         
        stbs.getSTBs().add(stb1);
        stbs.getSTBs().add(stb2);
        stbs.getSTBs().add(stb3);
        
        return new ResponseEntity<STBList>(stbs, HttpStatus.OK);
    }
     
    @RequestMapping(value = "/STB/resume/{id}")
    public ResponseEntity<STB> getSTBById (@PathVariable("id") int id) 
    {
    	STBList stbs = new STBList();
        
        STB stb1 = new STB(1,"Amical GIL","2.2", new Date(), "Réseau social pour les étudiants en GIL");
        STB stb2 = new STB(2,"Queazy","1.0", new Date(), "Plateforme de quiz");
        STB stb3 = new STB(3,"Close","1.5", new Date(), "Algo en Fdd");
        
        stbs.getSTBs().add(stb1);
        stbs.getSTBs().add(stb2);
        stbs.getSTBs().add(stb3);
        
        STB stb = stbs.getSTBs().get(id);
        if (stb != null) {
            return new ResponseEntity<STB>(stb, HttpStatus.OK);
        }
        
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/STB/insert", headers="Accept=application/xml")
    public @ResponseBody STB insertSTB(@RequestBody STB stb) {
    	return stb;
    }
}

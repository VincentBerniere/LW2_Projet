package univ.rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD:rest/src/main/java/univ/rest/model/STBList.java
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="stbs")
public class STBList implements Serializable {

    @XmlElement(name="stb")
=======
import javax.xml.bind.annotation.*;

@XmlRootElement(name="STBs")
public class STBList implements Serializable {
	private static final long serialVersionUID = 1L;

>>>>>>> b1a6984842496d8cff5fe6f94d2a39d0f1fc9af3:src/main/java/univ/rest/model/STBList.java
    private List<STB> stbs = new ArrayList<STB>();
    
    public List<STB> getSTBs() {
        return stbs;
    }
 
    public void setSTBs(List<STB> stbs) {
        this.stbs = stbs;
    }
}

package univ.rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="STBs")
public class STBList implements Serializable {

    @XmlElement(name="STB")
    private List<STB> stbs = new ArrayList<STB>();
    
    public List<STB> getSTBs() {
        return stbs;
    }
 
    public void setSTBs(List<STB> stbs) {
        this.stbs = stbs;
    }
}

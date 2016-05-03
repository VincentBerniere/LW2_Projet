package univ.rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="STBs")
public class STBList implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private List<STB> stbs = new ArrayList<STB>();
    
    public List<STB> getSTBs() {
        return stbs;
    }
 
    public void setSTBs(List<STB> stbs) {
        this.stbs = stbs;
    }
}

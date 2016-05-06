package univ.rest.model;

import javax.xml.bind.annotation.XmlElement;
<<<<<<< HEAD:rest/src/main/java/univ/rest/model/STBLiteList.java
=======
import javax.xml.bind.annotation.XmlElementWrapper;
>>>>>>> b1a6984842496d8cff5fe6f94d2a39d0f1fc9af3:src/main/java/univ/rest/model/STBLiteList.java
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD:rest/src/main/java/univ/rest/model/STBLiteList.java
@XmlRootElement(name="stbs")
=======
@XmlRootElement(name="STBs")
>>>>>>> b1a6984842496d8cff5fe6f94d2a39d0f1fc9af3:src/main/java/univ/rest/model/STBLiteList.java
public class STBLiteList implements Serializable {

    private List<STBLite> stbs = new ArrayList<STBLite>();

    public List<STBLite> getSTBs() {
        return stbs;
    }

    public void setSTBs(List<STBLite> stbs) {
        this.stbs = stbs;
    }
}
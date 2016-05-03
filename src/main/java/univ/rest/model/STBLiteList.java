package univ.rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 01/05/2016.
 */
@XmlRootElement(name="STBs")
public class STBLiteList implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<STBLite> stbs = new ArrayList<STBLite>();

    public List<STBLite> getSTBs() {
        return stbs;
    }

    public void setSTBs(List<STBLite> stbs) {
        this.stbs = stbs;
    }
}
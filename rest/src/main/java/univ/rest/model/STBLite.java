package univ.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Vincent on 01/05/2016.
 */
@XmlRootElement(name = "STB")
@XmlAccessorType(XmlAccessType.NONE)
public class STBLite {
    @XmlElement
    private String id;
    @XmlElement
    private String titreDuProjet;
    @XmlElement
    private double version;
    @XmlElement
    private String date;
    @XmlElement
    private String description;

    public STBLite(String id, String titre, double version, String date, String description) {
        super();
        this.id = id;
        this.titreDuProjet = titre;
        this.version = version;
        this.date = date;
        this.description = description;
    }
    public STBLite(){

    }
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitre() {
        return titreDuProjet;
    }

    public void setTitre(String titre) {
        this.titreDuProjet = titre;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "STB{" +
                "id=" + id +
                ", titre='" + titreDuProjet + '\'' +
                ", version='" + version + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}

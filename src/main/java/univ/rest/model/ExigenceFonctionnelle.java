package univ.rest.model;

import javax.xml.bind.annotation.*;

/**
 * Created by Vincent on 28/04/2016.
 */
@XmlRootElement(name="ExigenceFonctionnelle")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExigenceFonctionnelle {
    @XmlElement
    private String identifiant;
    @XmlElement
    private String description;
    @XmlAttribute
    private int priorite;

    public ExigenceFonctionnelle(String id, String description, int priorite) {
        super();
        this.identifiant = id;
        this.description = description;
        this.priorite = priorite;
    }

    public ExigenceFonctionnelle() {
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String id) {
        this.identifiant = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    @Override
    public String toString() {
        return "ExigenceFonctionnelle{" +
                "id=" + identifiant +
                ", description='" + description + '\'' +
                ", priorite=" + priorite +
                '}';
    }
}

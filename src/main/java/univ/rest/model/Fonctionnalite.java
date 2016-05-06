package univ.rest.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by Vincent on 28/04/2016.
 */
@XmlRootElement(name="Fonctionnalite")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fonctionnalite {
    @XmlElement
    private String description;
    @XmlElement
    private ArrayList<ExigenceFonctionnelle> exigenceFonctionnelle;
    @XmlAttribute
    private int priorite;

    public Fonctionnalite(String description, ArrayList<ExigenceFonctionnelle> exigenceFonctionnelle, int priorite) {
        super();
        this.description = description;
        this.exigenceFonctionnelle = exigenceFonctionnelle;
        this.priorite = priorite;
    }
    public Fonctionnalite() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<ExigenceFonctionnelle> getExigenceFonctionnelle() {
        return exigenceFonctionnelle;
    }

    public void setExigenceFonctionnelle(ArrayList<ExigenceFonctionnelle> exigenceFonctionnelle) {
        this.exigenceFonctionnelle = exigenceFonctionnelle;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    @Override
    public String toString() {
        return "Fonctionnalite{" +
                "description='" + description + '\'' +
                ", exigenceFonctionnelle=" + exigenceFonctionnelle +
                '}';
    }
}

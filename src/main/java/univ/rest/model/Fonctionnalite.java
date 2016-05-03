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
    @XmlElement
    private String commentaire;

    public Fonctionnalite(String description, String commentaire, ArrayList<ExigenceFonctionnelle> exigenceFonctionnelle) {
        super();
        this.description = description;
        this.commentaire = commentaire;
        this.exigenceFonctionnelle = exigenceFonctionnelle;
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

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Fonctionnalite{" +
                "description='" + description + '\'' +
                ", exigenceFonctionnelle=" + exigenceFonctionnelle +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}

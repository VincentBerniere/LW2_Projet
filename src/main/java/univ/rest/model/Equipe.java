package univ.rest.model;

import javax.xml.bind.annotation.*;

/**
 * Created by Vincent on 28/04/2016.
 */
@XmlRootElement(name="Equipe")
@XmlAccessorType(XmlAccessType.FIELD)
public class Equipe {
    @XmlElement
    private boolean gender;
    @XmlElement
    private String nom;
    @XmlElement
    private String prenom;

    public Equipe(boolean gender, String nom, String prenom) {
        super();
        this.gender = gender;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Equipe() {

    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "gender=" + gender +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}

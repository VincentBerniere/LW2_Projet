package univ.rest.model;

import javax.xml.bind.annotation.*;

/**
 * Created by Vincent on 28/04/2016.
 */
@XmlRootElement(name="Client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {
    @XmlElement
    private String entite;
    @XmlElement
    private String contact;
    @XmlElement
    private int codePostal;

    public Client(String entite, String contact, int codePostal) {
        super();
        this.entite = entite;
        this.contact = contact;
        this.codePostal = codePostal;

    }

    public Client() {}

    public String getEntite() {
        return entite;
    }

    public void setEntite(String entite) {
        this.entite = entite;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        return "Client{" +
                "entite='" + entite + '\'' +
                ", contact='" + contact + '\'' +
                ", codePostal=" + codePostal +
                '}';
    }
}

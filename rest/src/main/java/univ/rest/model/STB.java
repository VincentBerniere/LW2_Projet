package univ.rest.model;

import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.*;

@XmlRootElement (name = "STB")
@XmlAccessorType(XmlAccessType.NONE)
public class STB {
	@XmlElement
	private int id;
	@XmlElement
	private String titreDuProjet;
	@XmlElement
	private double version;
	@XmlElement
	private String date;
	@XmlElement
	private String description;
	@XmlElement
	private Client client;
	@XmlElement
	private ArrayList<Equipe> equipe;
	@XmlElement
	private ArrayList<Fonctionnalite> fonctionnalite;

	public STB(int id, String titre, double version, String date, String description, Client client, ArrayList<Equipe> equipe, ArrayList<Fonctionnalite> fonctionnalite) {
		super();
		this.id = id;
		this.titreDuProjet = titre;
		this.version = version;
		this.date = date;
		this.description = description;
		this.client = client;
		this.equipe = equipe;
		this.fonctionnalite = fonctionnalite;
	}
	public STB(){
        
    }
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ArrayList<Equipe> getEquipe() {
		return equipe;
	}

	public void setEquipe(ArrayList<Equipe> equipe) {
		this.equipe = equipe;
	}

	public ArrayList<Fonctionnalite> getFonctionnalite() {
		return fonctionnalite;
	}

	public void setFonctionnalite(ArrayList<Fonctionnalite> fonctionnalite) {
		this.fonctionnalite = fonctionnalite;
	}

	@Override
	public String toString() {
		return "STB{" +
				"id=" + id +
				", titre='" + titreDuProjet + '\'' +
				", version='" + version + '\'' +
				", date=" + date +
				", description='" + description + '\'' +
				", client=" + client +
				", equipe=" + equipe +
				", fonctionnalite=" + fonctionnalite +
				'}';
	}
}

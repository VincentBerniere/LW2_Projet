package univ.rest.model;

import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.*;

@XmlRootElement (name = "stb")
@XmlAccessorType(XmlAccessType.NONE)
public class STB {
	@XmlElement
	private String id;
	@XmlElement
	private String titreProjet;
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
	@XmlElement
	private String commentaire;

	public STB(String id, String titre, double version, String date, String description, Client client, ArrayList<Equipe> equipe, ArrayList<Fonctionnalite> fonctionnalite, String commentaire) {
		super();
		this.id = id;
		this.titreProjet = titre;
		this.version = version;
		this.date = date;
		this.description = description;
		this.client = client;
		this.equipe = equipe;
		this.fonctionnalite = fonctionnalite;
		this.commentaire = commentaire;
	}
	public STB(){
        
    }
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public String getTitre() {
		return titreProjet;
	}

	public void setTitre(String titre) {
		this.titreProjet = titre;
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

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "STB{" +
				"id=" + id +
				", titre='" + titreProjet + '\'' +
				", version='" + version + '\'' +
				", date=" + date +
				", description='" + description + '\'' +
				", client=" + client +
				", equipe=" + equipe +
				", fonctionnalite=" + fonctionnalite +
				'}';
	}
}

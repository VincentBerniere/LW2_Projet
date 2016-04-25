package univ.rest.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "STB")
@XmlAccessorType(XmlAccessType.NONE)
public class STB {
	@XmlAttribute
	private int id;
	@XmlAttribute
	private String titre;
	@XmlAttribute
	private String version;
	@XmlAttribute
	private Date date;
	@XmlAttribute
	private String description;
	
	public STB(int id, String t,String v,Date d,String desc) {
		super();
		this.id = id;
		titre = t;
		version = v;
		date = d;
		description = desc;
	}
	public STB(){
        
    }
	
	public int getId() {
		return id;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}



	public String getVersion() {
		return version;
	}



	public void setVersion(String version) {
		this.version = version;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
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
        return "STB [id="+id+", titre du projet=" + titre + ", version=" + version
                + ", date=" + date.toString() + ", description=" + description + "]";
    }
}

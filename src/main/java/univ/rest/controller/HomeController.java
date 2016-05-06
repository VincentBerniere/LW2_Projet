<<<<<<< HEAD:rest/src/main/java/univ/rest/controller/HomeController.java
package univ.rest.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import univ.rest.config.MongoDBJDBC;

@RestController
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		String s = "<h1>Projet créé par : Vincent Bernière et Renan Decamps</h1>";

		s += "<p><strong>Nombre de STB stockées : "+MongoDBJDBC.getMongoSTBListSize()+"</strong></p>";

		s += "<table>";
		s += "<thead>"
				+ "<tr>"
					+ "<td>URL</td>"
					+ "<td>Méthode</td>"
					+ "<td>Action</td>"
				+ "</tr>"
			+ "</thead>";
		
		s += "<tbody>";
		s += "<tr>"
				+ "<td>/resume</td>"
				+ "<td>GET</td>"
				+ "<td>Affiche sous forme résumée, la liste des STB enregistrées.</td>"
			+ "</tr>";
		s += "<tr>"
				+ "<td>/resume/n</td>"
				+ "<td>GET</td>"
				+ "<td>Affiche le contenu complet de la STB dont l'identifiant est \"n\".</td>"
			+ "</tr>";
		s += "<tr>"
				+ "<td>/depot</td>"
				+ "<td>POST</td>"
				+ "<td>Dépose une nouvelle STB. Une vérification syntaxique du contenu est effectuée, afin\n" +
				"de n'autoriser que des dépôts corrects (validation XSD par le service).</td>"
			+ "</tr>";
		s += "</tbody>";
		s += "</table>";
		
		return s;
	}
}
=======
package univ.rest.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import univ.rest.config.MongoDBJDBC;

@RestController
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		String s = "<h1>Projet créé par : Vincent Bernière et Renan Decamps</h1>";

		s += "<p><strong>Nombre de STB stockées : "+ MongoDBJDBC.getMongoSTBListSize()+"</strong></p>";

		s += "<table>";
		s += "<thead>"
				+ "<tr>"
					+ "<td>URL</td>"
					+ "<td>Méthode</td>"
					+ "<td>Action</td>"
				+ "</tr>"
			+ "</thead>";
		
		s += "<tbody>";
		s += "<tr>"
				+ "<td>/resume</td>"
				+ "<td>GET</td>"
				+ "<td>Affiche sous forme résumée, la liste des STB enregistrées.</td>"
			+ "</tr>";
		s += "<tr>"
				+ "<td>/resume/n</td>"
				+ "<td>GET</td>"
				+ "<td>Affiche le contenu complet de la STB dont l'identifiant est \"n\".</td>"
			+ "</tr>";
		s += "<tr>"
				+ "<td>/depot</td>"
				+ "<td>POST</td>"
				+ "<td>Dépose une nouvelle STB. Une vérification syntaxique du contenu est effectuée, afin\n" +
				"de n'autoriser que des dépôts corrects (validation XSD par le service).</td>"
			+ "</tr>";
		s += "</tbody>";
		s += "</table>";
		
		return s;
	}
}
>>>>>>> b1a6984842496d8cff5fe6f94d2a39d0f1fc9af3:src/main/java/univ/rest/controller/HomeController.java

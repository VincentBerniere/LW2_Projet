package univ.rest.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		String s = "<table>";
		
		s += "<thead>"
				+ "<tr>"
					+ "<td>URL</td>"
					+ "<td>Méthode</td>"
					+ "<td>Action</td>"
				+ "</tr>"
			+ "</thead>";
		
		s += "<tbody>";
		s += "<tr>"
				+ "<td>/STB1/resume</td>"
				+ "<td>GET</td>"
				+ "<td>renvoie un flux XML contenant la liste des STB</td>"
			+ "</tr>";
		s += "<tr>"
				+ "<td>/STB1/resume/id</td>"
				+ "<td>GET</td>"
				+ "<td>renvoie un flux XML décrivant le détail de la STB d’identifiant Id</td>"
			+ "</tr>";
		s += "<tr>"
				+ "<td>/STB1/insert</td>"
				+ "<td>POST</td>"
				+ "<td>reçoit un flux XML décrivant une STB, crée l'objet correspondant "
				+ "et retourne son nouvel identifiant au format XML</td>"
			+ "</tr>";
		s += "</tbody>";
		s += "</table>";
		
		return s;
	}
}

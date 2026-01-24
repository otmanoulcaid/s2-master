package org.mql.biblio.web.actions;

import java.util.List;

import org.mql.biblio.business.BiblioService;
import org.mql.biblio.config.ApplicationContext;
import org.mql.biblio.models.Author;
import org.mql.biblio.web.Model;
//sous couche intermidiaire avec la couche metier
/*
 * Class d'action =Controller (SpringBoot)
 * =>Classe POJO :Plain Old Java Object
 */

public class AuthorAction {
	//connection avec le metier et comment lui donner une valeur , on l'a externaliser 
	private BiblioService service;
	
	public AuthorAction() {
		service = ApplicationContext.getService();
	}
//Methodes d'action:
	// .../biblio/authors-list
	public String authorsList(Model model)// ne jamais ajouter un objet httprequest
	{
		System.out.println(">> getAullauthors");
		List<Author> authors= service.authors();
		model.add("authors", authors);
		model.add("message", "Liste de tous les auteurs");

		return "authors-list";
	}

	
//End-Points Rest: Points Terminaux rest(points termines)
	// .../biblio/api/authors
	 public List<Author> authorList(){
		 return service.authors();
	 }
}



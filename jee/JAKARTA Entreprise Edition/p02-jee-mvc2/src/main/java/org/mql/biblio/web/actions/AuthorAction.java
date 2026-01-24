package org.mql.biblio.web.actions;

import java.util.List;

import org.mql.biblio.business.Biblioservice;
import org.mql.biblio.config.ApplicationContext;
import org.mql.biblio.models.Author;
import org.mql.biblio.web.Model;

/*
 * classe daction : Controller ( spring boot )
 * classe POJO : Plan old java object
 */
// classe daction : permettra d'accéder tous les services d'Author : sera lintermediaire entre le controller et le metier
public class AuthorAction {
	private Biblioservice service;

	public AuthorAction() {
		service = ApplicationContext.getService();
	}

	// méthode d'action
	// probleme qui se pose type de retour de la methode d'action :
	// dependant de raisonnement :
	// rest api : raisonner objet ( retourner list dauthors )
	// vue : retourner string ( chemin de la vue qui s'appelle outcome )
	// si on fait de la TDD , il faut faire ca ( sysout par ex to test our
	// architecture so far ) ( on commence par le minimum et on le teste , puis on
	// fait le refactoring pour rajouter le metier , toujours commencer par le
	// minimum et tester que ca marche apres le remplir cest de la TDD

	// accessible via .../biblio/authors-list
	public String authorsList(Model model) {
		System.out.println(">> getAllAuthors()");
		List<Author> authors = service.authors();
		// deux models de type : liste des auteurs et model de type string (message)
		model.add("authors", authors);
		model.add("message", "Liste de tous les auteurs");
		// convention des noms ainsi pour les uri , miniscule separé par -
		return "authors-list";
	}

	// End-Points REST : Points terminaux REST
	// .../biblio/api/authors
	public List<Author> authorsList() {
		return service.authors();
	}

}

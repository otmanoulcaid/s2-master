package org.mql.biblio.web;

import java.util.Hashtable;

// la servlet lit les donnees de la requte et fait les traitements en faisnt appel a la couche metier , qui va retouner des resultats , le composant servlet va les stockets dans l'objet model
//on servit de modele pour: generer une reponse http au format html,
//la servlet fait appel a la jsp , qui a besoin de generer le code html , il a besoin de recuperer  ces resultas pour cette gestion, 
//donc il fait appel au modele pour obtenir les resultats, eta partir de ces donnees il genere le code html
public class Model {
 private Hashtable<String, Object> models;
 
	public Model() {
		models= new Hashtable<String, Object>();
	}
	
	public void add(String name, Object model) {
		models.put(name, model);
	}
	
	public Object get(String name) {
		return models.get(name);
	}
}

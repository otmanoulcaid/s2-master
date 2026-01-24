package org.mql.biblio.web;

import java.util.Hashtable;

//	cest l'intermediaire entre le metier et la classe daction
//	utility class to pass data between the controller and views
public class Model {
	private Hashtable<String, Object> models;

	public Model() {
		models = new Hashtable<String, Object>();
	}

	public void add(String name, Object model) {
		models.put(name, model);
	}

	public Object get(String name) {
		return models.get(name);
	}

}

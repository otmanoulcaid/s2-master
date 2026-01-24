package org.mql.java.web;

import java.util.Hashtable;

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

package org.mql.dp.creational.builder;

public class DesignPattern {
	private int id;
	private String nom;
	private String category;
	private String intent;
	
	public DesignPattern() {
		
	}
	
	

	public DesignPattern(int id, String nom, String category, String intent) {
		super();
		this.id = id;
		this.nom = nom;
		this.category = category;
		this.intent = intent;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}

	@Override
	public String toString() {
		return nom + "[ category=" + category + ", intent=" + intent + "]";
	}
}

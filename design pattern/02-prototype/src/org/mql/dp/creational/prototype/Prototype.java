package org.mql.dp.creational.prototype;

//cloneable 
//redefinir
//public 
//try catch
//type de retour
//si il ya des objet agreger il faut reprendre le comportement de la methode clone

public class Prototype implements Cloneable{
	
	private int id = 1;
	private String name= "name";
	Date date;
	
	public Prototype() {
		date = new Date();
	}
	
	public Prototype(int id, String name, Date date) {
		super();
		date = new Date();
		this.id = id;
		this.name = name;
		this.date = date;
	}



	@Override
	public Prototype clone() //augmenter le niveau de visibilité de protected au public
	{
		
		try {
			Prototype p = (Prototype)super.clone();
//			p.id = id
//			p.name = name
			p.date = date.clone();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "Prototype [id=" + id + ", name=" + name + ", date = " + date + "]";
	}

	public Prototype(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}

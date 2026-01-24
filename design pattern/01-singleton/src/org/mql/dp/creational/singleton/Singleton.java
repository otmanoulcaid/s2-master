package org.mql.dp.creational.singleton;

public class Singleton {

	private int id;
	private String name;
	private static Singleton instance = new Singleton();;
	
//	static {
//		instance = new Singleton();
//	}

	private Singleton() {
		
	}
	
	public Singleton(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public  static Singleton getInstance()
	{
		/*
		if (instance == null) //lazy initialisation
			instance = new Singleton();
		*/
		return instance;
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
	
	
	
}

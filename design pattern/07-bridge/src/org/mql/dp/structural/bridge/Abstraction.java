package org.mql.dp.structural.bridge;

public class Abstraction {
		private Implementor implementor;
	
	public Abstraction() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Abstraction(Implementor implementor) {
		super();
		this.implementor = implementor;
	}

	public void add()
	{
		//ajout d'un element
		log("Ajout d'un element");
	}
	
	public void remove()
	{
		//supression d'un element
		log("supression d'un element");
	}
	
	public void set()
	{
		//modification d'un element
		log("modification d'un element");
	}

	public void log(String message)
	{
		if (implementor != null) implementor.log(message);
	}



	public void setImplementor(Implementor implementor) {
		this.implementor = implementor;
	}
	
	
}

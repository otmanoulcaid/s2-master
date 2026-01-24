package org.mql.dp.structural.composite;

import org.mql.dp.structural.composite.factory.Factory;

public abstract class Component {
	private String name;
	protected Factory factory;

	public Component(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void add(Component component)
	{
		
	}
	
	public Component remove(int index)
	{
		return null;
	}
	
	public Component get(int index)
	{
		return null;
	}
	
	public int size()
	{
		return 0;
	}
	
	public abstract void operation();
	public abstract Object construct();
	public abstract void setFactory(Factory factory);
}

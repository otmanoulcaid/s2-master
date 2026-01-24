package org.mql.dp.structural.bridge;

public class User extends Thread {
	String name;
	Abstraction abstraction;
	
	public User(String name, Abstraction abstraction)
	{
		this.name = name;
		this.abstraction = abstraction;
	}
	
	@Override
	public void run()
	{
		for (int i = 0; i < 20; i++)
		{
			int choice = (int)(Math.random() * 100);
			if (choice < 30)
				abstraction.add();
			else if (choice < 75)
				abstraction.remove();
			else
				abstraction.set();
		}
	}
}

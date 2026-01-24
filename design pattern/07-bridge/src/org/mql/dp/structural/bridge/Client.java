package org.mql.dp.structural.bridge;

import java.io.Serializable;

public class Client {

	private Abstraction abstraction;
	
	public Client() {
//		abstraction = new Abstraction();
		abstraction = new RefindAbstraction();
		config02();
		exp01();
	}
	
	void config01()
	{
		abstraction.setImplementor(new ConsoleImplementor());
	}
	
	void config02()
	{
		abstraction.setImplementor(new FileImplementor("logs.txt"));
	}
	
	void exp01()
	{
		User user = new User("anass", abstraction);
		user.start();
	}
	
	public static void main(String[] args) {
		new Client();
	}
	
	
	
}


//Single reponsibility
//open close
//liskov principle interface plutot que class
//i : interface segregation // frtet waldiha dak l'interface
//D : dependency inversion


package org.mql.dp.creational.singleton;

import java.awt.Toolkit;

public class Client {

	public Client() {
		exp01();
		knownUses();
	}
	
	public void exp01() {
		
		Singleton s1 =  Singleton.getInstance();
		Singleton s2 =  Singleton.getInstance();
		
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s1);
		
	}
	
	void knownUses() {// utilisation remarquable

		Toolkit tk1 = Toolkit.getDefaultToolkit();
		Toolkit tk2 = Toolkit.getDefaultToolkit();
		System.out.println("tk1 = " + tk1);
		System.out.println("tk2 = " + tk2);

	}
	
	public static void main(String[] args) {
		new Client();
	}

	//
}

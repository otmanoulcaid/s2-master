package org.mql.dp.creational.prototype;

public class Client {
	
	public Client() {
		exp01();
	}
	
	public void exp01()
	{
		Prototype p1 = new Prototype();
		Prototype p2 = p1.clone();
		System.out.println("p1 = " + p1);
		System.out.println("p2 = " + p2);
		
		p2.setId(0);
		p2.setName("p1");

		p1.setDate( new Date(1,2,3));
		System.out.println("p1 = " + p1);
		System.out.println("p2 = " + p2);
	}

	void KnownUse()
	{
		/*
		 * instanciation des objects de javascript
		 * 
		function Point()
		{
			
		}
		
		p1 = new Point(); <=> p1 = Object.create(Point.prototype())
		*/
	}

	public static void main(String[] args) {
		new Client();
	}
	
}

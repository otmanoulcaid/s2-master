package org.mql.dp.structuracl.adapter;

public class Client {
	
	public Client() {
	}
	
	public void handle(Object targets[])
	{
		System.out.println(" -- solution classiques -- ");
		for (Object target : targets)
		{
			if (target instanceof A)
				((A)target).print();
			else if (target instanceof B)
				((B)target).log();
			else if (target instanceof C)
				((C)target).display();
		}
	}
	
	public void handle(Target [] targets)
	{
		System.out.println("-- solution dp adaptor : --");
		for (Target target : targets)
			target.log();
	}
}

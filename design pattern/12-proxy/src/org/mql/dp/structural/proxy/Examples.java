package org.mql.dp.structural.proxy;

public class Examples {
	Client clients [];
	private Subject subject;
	
	public Examples() {
		init();
		exp01();
		createClients();
	}
	
	void init() 
	{
		subject = new RealSubject();
		
	}
	
	void exp01()
	{
		subject = new SynchronizationProxy(subject);
	}
	
	void createClients()
	{
		String roles [] = {"admin", "manager", "user"};
		clients = new Client[roles.length];
		for (int i = 0; i < roles.length; i++)
		{
			clients[i] = new Client(roles[i], subject);
			clients[i].start();
		}
		waitClient();
	}

	void waitClient()
	{
		for (Client client : clients)
		{
			try {
				client.join();
			} catch (Exception e) {}
		}
	}
	
	void prinResult()
	{
		System.out.println("");
	}
	
	public static void main(String[] args) {
		new Examples();
	}
}
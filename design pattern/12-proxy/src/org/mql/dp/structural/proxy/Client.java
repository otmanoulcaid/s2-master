package org.mql.dp.structural.proxy;

public class Client extends Thread {
	
	private Subject subject;

	public Client(String role, Subject subject) {
		super();
		this.subject = subject;
	}

	@Override
	public void run() {
		for (int i = 0; i< 10; i++)
		{
			subject.insert(item());
			pause();
		}
		subject.update(index(), item());
		pause();
		for (int i = 0; i < 3; i++)
		{
			subject.delete(index());
			pause();
		}
	}
	
	private String item()
	{
		String s = "";
		for (int i = 0; i < 3; i++)
			s+= (char)((int)(Math.random() * 26 +  'A'));
		return s;
	}
	
	private int index()
	{
		return (int)(Math.random() * subject.size());
		
	}
	
	private void pause()
	{
		try {
			Thread.sleep(100);
		} catch (Exception e) {}
	}
}

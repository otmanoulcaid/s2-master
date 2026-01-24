package org.mql.dp.structural.bridge;

public class ConsoleImplementor implements Implementor {

	public ConsoleImplementor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void log(String message) {
		System.out.println(" -- " + message);
	}
	
	
}

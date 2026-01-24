package org.mql.dp.structural.bridge;

public class Ressources implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("Ressource is closed");
	}
	
}

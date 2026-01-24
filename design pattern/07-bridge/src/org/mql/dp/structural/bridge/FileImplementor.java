package org.mql.dp.structural.bridge;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileImplementor implements Implementor {
	private String folder = "ressources/logs/";
	private String target;

	public FileImplementor(String target) {
		this.target = target;
		new File(folder).mkdirs();
	}

	@Override
	public void log(String message) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String row = "#" + message + "@" +  now.format(formatter);
		//try with ressources d'apres quelle JDK 7 //on communique les ressources AutoClosable (interface qui fournie le service close())
		try (
				PrintWriter out = new PrintWriter(new FileOutputStream(new File(folder + target), true));
//				Ressources ressource = new Ressources()
		)
		{
			out.println(row);
		}
		catch (Exception e) {
			System.err.println("Error" + e.getMessage());
		}
	}
	
	
}

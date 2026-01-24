package org.mql.dp.creational.builder;

import java.io.BufferedReader;
import java.io.FileReader;

public class Director {
	private String source = "ressources/design-patterns.txt";
	private Builder builder;
	
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	public Object build(String keyword)
	{
		try {
			BufferedReader in = new BufferedReader(new FileReader(source));
			builder.init();
			String row;
			while ((row = in.readLine()) != null)
			{
				String [] t = row.split(";");
				for (int i = 0; i < t.length; i++)
					t[i].trim();
				builder.setRow(t);
				builder.filter(keyword);
			}
			builder.construct();
			in.close();
			return builder.getResult();
		}
		catch (Exception e)
		{
			System.out.println(" error : " + e.getMessage());
			return null;
		}
	}
}

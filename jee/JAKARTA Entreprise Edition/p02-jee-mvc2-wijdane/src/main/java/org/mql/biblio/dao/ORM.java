package org.mql.biblio.dao;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.models.Author;

/*
 * Object Relational Mapper
 * services de mapping 
 * 
 * La classe ORM est utilisée pour mapper (convertir) des données tabulaires vers des objets Java.
 *  Elle isole la logique de transformation de données, rendant ton code plus propre, plus clair et plus maintenable,
 *   en suivant l’idée des ORM frameworks comme Hibernate (mais ici, de façon artisanale).
 *   
 */ 


public class ORM {

	public ORM() {
		// TODO Auto-generated constructor stub
	}
	
	public static Author getAuthor(String... row) {
		return new Author(getInt(row[0]), row[1], getInt(row[2]));
				
	}
	
	public static List<Author> getAuthors(String data[][]) {//recupre les donnees depuis une matrice
		List<Author> authors= new Vector<Author>();
//		for(String row []:data) {
		for(int i=1; i<data.length; i++) {
			Author a = getAuthor(data[i]);
			if(a != null) {
				authors.add(getAuthor(data[i]));
				
			}
		}
		return authors;
	}
	
	public static int getInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return -1;
		}
	}
}

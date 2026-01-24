package org.mql.biblio.dao;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.models.Author;

public class ORM {

	public ORM() {
	}

	public static Author getAuthor(String... row) {
		return new Author(getInt(row[0]), row[1], getInt(row[2]));
	}

	public static List<Author> getAuthors(String data[][]) {
		List<Author> authors = new Vector<Author>();
		for (int i = 1; i < data.length; i++) {
			authors.add(getAuthor(data[i]));
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

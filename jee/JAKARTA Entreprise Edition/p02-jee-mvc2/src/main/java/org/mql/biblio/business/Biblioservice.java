package org.mql.biblio.business;

import java.util.List;

import org.mql.biblio.models.Author;

public interface Biblioservice {
	public boolean addAuthor(Author author);
	public List<Author> authors();
	

}

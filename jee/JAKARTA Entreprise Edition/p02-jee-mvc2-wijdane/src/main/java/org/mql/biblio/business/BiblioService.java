package org.mql.biblio.business;

import java.util.List;

import org.mql.biblio.models.Author;

public interface BiblioService {
	public boolean addAuthor(Author author);
	public Author selectAuthorById(int id);
	public boolean deleteAuthorById(int id);
	public List<Author> authors();
}

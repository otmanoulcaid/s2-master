package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.models.Author;

public interface AuthorDao {
	public boolean insert(Author author);
	public boolean update(Author author);
	public boolean delete(int id);
	public Author select(int id);
	public List<Author> selectAll();


}

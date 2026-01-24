package org.mql.biblio.dao;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.models.Author;

public class AuthorDaoMock implements AuthorDao{
	private List<Author> authors;
	
	public AuthorDaoMock() {
		authors = new Vector<Author>();
		authors.add(new Author(101,"James Gosling",1955));
		authors.add(new Author(102,"Eric Gamma",1961));
		authors.add(new Author(103,"Tim Berners-Lee",1955));

	}

	@Override
	public boolean insert(Author author) {
		return authors.add(author);
	}

	@Override
	public boolean update(Author author) {
		for(Author author1:authors) {
			if(author.getId()==author.getId()) {
				int id=author.getId();
				authors.set(id, author);
				return true;
			}}
		return false;
	}

	@Override
	public boolean delete(int id) {
		for(Author author:authors) {
			if(author.getId()==id) {
				authors.remove(author);
				return true;
			}
		}		return false;
	}

	@Override
	public Author select(int id) {
		for(Author author:authors) {
			if(author.getId()==id) {
				return author;
			}
		}
		return null;
	}

	@Override
	public List<Author> selectAll() {
		return authors;
	}
}

package org.mql.biblio.dao;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.models.Author;

public class AuthorDaoMock implements AuthorDao{
	private List<Author> authors ; 

	public AuthorDaoMock() {
		authors = new Vector<Author>();
		authors.add(new Author(101 , "James Goslin" , 1955));
		authors.add(new Author(102 , "Erich Gamma" , 1961));
		authors.add(new Author(103 , "Tim Berners-Lee" , 1955));
	}

	@Override
	public boolean insert(Author author) {
		return authors.add(author);
	}

	@Override
	public boolean update(Author author) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Author select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> selectAll() {
		return authors ; 
	}
	
	
}

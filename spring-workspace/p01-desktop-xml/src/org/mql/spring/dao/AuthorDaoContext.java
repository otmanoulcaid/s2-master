package org.mql.spring.dao;

import java.util.List;

import org.mql.spring.models.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDaoContext implements AuthorDao{
	private List<Author> authors;
	
	public AuthorDaoContext() {
	}
	
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@Override
	public List<Author> selectAll() {
		return authors;
	}
}



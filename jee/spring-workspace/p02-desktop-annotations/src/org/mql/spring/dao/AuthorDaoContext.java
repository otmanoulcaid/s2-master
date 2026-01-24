package org.mql.spring.dao;

import java.util.List;

import org.mql.spring.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDaoContext implements AuthorDao{
	@Autowired
	private List<Author> authors;
	
	public AuthorDaoContext() {
	}
	
	@Override
	public List<Author> selectAll() {
		return authors;
	}
	
	
}

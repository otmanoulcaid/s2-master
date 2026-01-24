package org.mql.spring.dao;

import java.util.List;

import org.mql.spring.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository//par defaut il cree un bean de celle classe avec un nom minuscule
public class AuthorDaoContext implements AuthorDao {
	@Autowired
	public List<Author> authors;
	
	public AuthorDaoContext() {
	}
	
	@Override
	public List<Author> selectAll() {
		// TODO Auto-generated method stub
		return authors;
	}

}

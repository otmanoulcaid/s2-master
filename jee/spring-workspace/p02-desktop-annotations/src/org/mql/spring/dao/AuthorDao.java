package org.mql.spring.dao;

import java.util.List;

import org.mql.spring.models.Author;

public interface AuthorDao {
	public List<Author> selectAll();
}

package org.mql.spring.business;

import java.util.List;

import org.mql.spring.dao.AuthorDao;
import org.mql.spring.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiblioServiceDefault implements BiblioService {
	
	@Autowired
	private AuthorDao authorDao;

	@Override
	public List<Author> getAllAuthors() {

		return authorDao.selectAll();
	}
}


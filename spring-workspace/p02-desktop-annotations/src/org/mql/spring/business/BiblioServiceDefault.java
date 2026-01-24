package org.mql.spring.business;

import java.util.List;

import org.mql.spring.dao.AuthorDao;
import org.mql.spring.models.Author;
import org.springframework.stereotype.Service;

@Service
public class BiblioServiceDefault implements BiblioService {
	private AuthorDao authorDao;
	
	//Implicit Autowiring (on doit avoir un seul constructeur pas plus)
	public BiblioServiceDefault(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}
	
	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	@Override
	public List<Author> getAllAuthors() {
		return authorDao.selectAll();
	}
}

package org.mql.biblio.business;

import java.util.List;

import org.mql.biblio.dao.AuthorDao;
import org.mql.biblio.models.Author;

public class biblioServiceDefault implements BiblioService{
	
	//Dependecy Injection // principe (SOLI<D>) renforce le principe de couplage faible
	private AuthorDao authorDao;

	public biblioServiceDefault(AuthorDao authorDao) {
		super();
		this.authorDao = authorDao;
	}

	@Override
	public boolean addAuthor(Author author) {
		return authorDao.insert(author);
	}

	@Override
	public List<Author> authors() {
		return authorDao.selectAll();
	}

	@Override
	public Author selectAuthorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAuthorById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

package org.mql.spring.business;

import java.util.List;

import org.mql.spring.dao.AuthorDao;
import org.mql.spring.models.Author;
import org.mql.spring.models.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class BiblioServiceDefault implements BiblioService {
	
	//par injection de dependence
	private AuthorDao authorDao;
	
	//Implicit Autowiring valable si ll n'y a pas un constructeur sans parametres
	public BiblioServiceDefault(AuthorDao authorDao) {
		this.authorDao=authorDao;
	}
	
	@Override
	public List<Author> getAllAuthors() {
		return authorDao.selectAll();
	}

	@Override
	public Author getAuthorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> getAuthorsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> getAuthorsByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Document> getAllDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Document> getDocumentsByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Document> getDocumentsByYearInterval(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

}

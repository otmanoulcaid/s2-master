package org.mql.spring.business;

import java.util.List;

import org.mql.spring.models.Author;
import org.mql.spring.models.Document;

public interface BiblioService {
	public List<Author> getAllAuthors();
	public Author getAuthorById(int id);
	public List<Author> getAuthorsByName(String name);
	public List<Author> getAuthorsByKeyword(String keyword);
	public List<Document> getAllDocuments();
	public Document getDocumentByIsbn(String isbn);
	public List<Document> getDocumentsByKeyword(String keyword);
	public List<Document> getDocumentsByYearInterval(int min,int max);
	
	
}

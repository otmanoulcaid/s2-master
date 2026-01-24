package org.mql.spring.business;

import java.util.List;
import java.util.Optional;

import org.mql.spring.models.Author;
import org.mql.spring.models.Document;
import org.mql.spring.repositories.AuthorRepository;
import org.mql.spring.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service //on desactive @service sur biblioServiceDefault car un seul service qu'on a 
public class BiblioServiceJpa implements BiblioService {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public Author getAuthorById(int id) {
		 Optional<Author> author = authorRepository.findById(id);
		 if(author.isPresent()) return author.get();
		 return null;
		
		  
	}

	@Override
	public List<Author> getAuthorsByName(String name) {
		return authorRepository.findByName(name);
	}

	@Override
	public List<Author> getAuthorsByKeyword(String keyword) {
		return authorRepository.findByKeyword(keyword);
	}

	@Override
	public List<Document> getAllDocuments() {
		return documentRepository.findAll();
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
		return documentRepository.findByDateIntervale(min, max);
	}

}

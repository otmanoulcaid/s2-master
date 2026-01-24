package org.mql.biblio.business;

import java.util.List;

import org.mql.biblio.dao.AuthorDao;
import org.mql.biblio.models.Author;

// le service metier est une facade qui permet la dependancy inversion , l'abstraction..
public class BiblioserviceDefault implements Biblioservice {
	// dependancy inversion principle by depending on the AuthorDao interface (abstraction) rather than a specefic implementation 
	private AuthorDao authorDao;

	public BiblioserviceDefault(AuthorDao authorDao) {
		super();
		this.authorDao = authorDao;
	}

	// délegation de travail ( c'est pas toujours le cas )
	@Override
	public boolean addAuthor(Author author) {
		return authorDao.insert(author);
	}

	@Override
	public List<Author> authors() {
		return authorDao.selectAll();
	}

}

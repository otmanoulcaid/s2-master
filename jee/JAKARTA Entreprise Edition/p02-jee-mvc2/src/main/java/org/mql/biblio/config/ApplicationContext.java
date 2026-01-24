package org.mql.biblio.config;

import org.mql.biblio.business.Biblioservice;
import org.mql.biblio.business.BiblioserviceDefault;
import org.mql.biblio.dao.AuthorDao;
import org.mql.biblio.dao.AuthorDaoJDBC;
import org.mql.biblio.dao.AuthorDaoMock;
import org.mql.biblio.web.actions.AuthorAction;
import org.mql.biblio.dao.jdbc.DataSource;
import org.mql.biblio.dao.jdbc.Database;
import org.mql.biblio.dao.jdbc.MySQLDataSource;

public class ApplicationContext {
	private static Biblioservice service;

	// static pour assurer l'unicité  (we can use singleton later)
	// biblio service is instanciated once and shared across the app
	static {
		// Wiring :
		// AuthorDao authorDao = new AuthorDaoMock();
		DataSource ds = new MySQLDataSource("biblio");
		AuthorDao authorDao = new AuthorDaoJDBC(new Database(ds));
		service = new BiblioserviceDefault(authorDao);
	}

	public ApplicationContext() {

	}

	public static Biblioservice getService() {
		return service;
	}
}

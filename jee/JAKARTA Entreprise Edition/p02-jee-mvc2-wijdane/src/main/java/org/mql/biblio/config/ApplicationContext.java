package org.mql.biblio.config;

import org.mql.biblio.business.BiblioService;
import org.mql.biblio.business.biblioServiceDefault;
import org.mql.biblio.dao.AuthorDao;
import org.mql.biblio.dao.AuthorDaoJdbc;
import org.mql.biblio.dao.jdbc.DataSource;
import org.mql.biblio.dao.jdbc.Database;
import org.mql.biblio.dao.jdbc.MySQLDataSource;

//import org.mql.biblio.dao.AuthorDaoMock;
/*Wiring (Configuration externe) : externalisation et garantit la cohérence des données ,
 * l'unicité, l'abstraction et la centralisation des configurations.
*/

public class ApplicationContext {
	private static org.mql.biblio.business.BiblioService service;

	static {
     	DataSource ds= new MySQLDataSource("biblio");
     	Database db= new Database(ds);
     	AuthorDao authordao= new AuthorDaoJdbc(db);
        service= new biblioServiceDefault(authordao);
	}

	public static BiblioService getService() {
		return service;
	}
}

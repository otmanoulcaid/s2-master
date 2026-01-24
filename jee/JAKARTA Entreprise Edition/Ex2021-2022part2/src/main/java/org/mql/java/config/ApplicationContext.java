package org.mql.java.config;



import org.mql.java.business.EmailService;
import org.mql.java.business.EmailServiceDefault;
import org.mql.java.dao.EmailDao;
import org.mql.java.dao.EmailDaoImplementation;
import org.mql.jdbc.DataSource;
import org.mql.jdbc.Database;
import org.mql.jdbc.MySQLDataSource;



public class ApplicationContext {
	private static EmailService service;
	
	static {
		DataSource ds=new MySQLDataSource("messagerie_db");
		Database db=new Database(ds);
		EmailDao emailDao=new EmailDaoImplementation(db);
		service=new EmailServiceDefault(emailDao);
		
	}
	
	public ApplicationContext() {
		// TODO Auto-generated constructor stub
	}
	public static EmailService getService() {
		return service;
	}
	

}

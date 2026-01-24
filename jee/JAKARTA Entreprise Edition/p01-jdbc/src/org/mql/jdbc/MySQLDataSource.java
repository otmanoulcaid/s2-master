package org.mql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDataSource extends DataSource{
	
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_BRIDGE = "jdbc:mysql:";
	

	
	public MySQLDataSource(String source, String host, String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, source, host, user, password);
	}
	
	public MySQLDataSource(String source, String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, source, "localhost", user, password);
	}

	
	public MySQLDataSource(String source, String user) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, source, "localhost", user, "");
	}
	

	
	public MySQLDataSource(String source) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, source, "localhost", "root", "");
	}
	
	public MySQLDataSource() {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "mysql", "localhost", "root", "");
	}
	
	@Override
	public Connection getConnection() {
		try {
			Class.forName(getDriver());
			String url = getBridge() + "//" + getHost() + "/" + getSource();
			Connection db = DriverManager.getConnection(url, getUser(), getPassword());
			System.out.println("conexion etablie...");
			return db;
		}
		catch (Exception e) {
			System.out.println("erreur : " + e.getMessage());
			return null;
		}
	}

}

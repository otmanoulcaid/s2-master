package org.mql.biblio.dao.jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Database {
	private DataSource dataSource;
	private Connection db;

	public Database(DataSource dataSource) {
		this.dataSource = dataSource;
		db = dataSource.getConnection();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	// statement : moteur d'éxecution de requetes sql
	// 3 types de requetes : DDL , DML , DCL
	// in DML two types select in catego 1 (recherche / query ) and catego 2 (
	// update : insert , delete , update )
	// executequery for select , executeupdate for update dml type
	// and execute for ddl (create , alter , drop)
	// preference dutilser lexecute qui correspond au type de requete
	// even if we have possibility to use execute for insert for example
	// but its not as precise ..

	public String[][] query(String request) {
		try {
			Statement sql = db.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = sql.executeQuery(request);
			int rows, cols;

			rs.last();
			rows = rs.getRow();
			rs.beforeFirst();

			// rows is a data thing but cols is structure data (structure de la table), or
			// meta data so we can jst use metadata
			ResultSetMetaData rsm = rs.getMetaData();
			cols = rsm.getColumnCount();

			String data[][] = new String[rows + 1][cols]; // +1 for an extra row at the beginning to display cols names
			for (int i = 0; i < cols; i++) {
				data[0][i] = rsm.getColumnName(i + 1);
			}

			int row = 0;
			while (rs.next()) {
				row++;
				for (int col = 0; col < cols; col++) {
					data[row][col] = rs.getString(col + 1);
				}
			}
			sql.close();
			return data;
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}

	public String[][] select(String tableName) {
		String request = "SELECT * FROM " + tableName;
		return query(request);
	}

	public String[][] selectByKeyword(String tableName, String key, Object value) {
		String request = "SELECT * FROM " + tableName + " WHERE " + key + " LIKE '%" + value + "%'";
		return query(request);
	}

	// La suite de méthode select()...

	// other : raisonner couche (3couches ) et mapping

	// refactoring to improve la chaine: we should think abt string builder , string
	// buffer
	// recatoring to improve mapping???flux/ introspection.. we should think abt
	public boolean insert(String tableName, Object... row) {
		String query = "INSERT INTO " + tableName + " Values('" + row[0] + "'";
		for (int i = 1; i < row.length; i++) {
			query += ", '" + row[i] + "'";
		}
		query += ")";
		try {
			Statement sql = db.createStatement();
			int result = sql.executeUpdate(query);
			if (result == 1) {
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return false;
		}
	}

	public boolean insert(String tableName, Object model) {
		try {
			Field fields[] = model.getClass().getDeclaredFields();
			Object row[] = new Object[fields.length];
			for (int i = 0; i < row.length; i++) {
				fields[i].setAccessible(true);
				row[i] = fields[i].get(model);
				fields[i].setAccessible(false);
			}
			return insert(tableName, row);
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return false;
		}
	}

	// for mysql 5 : com.mysql.jdbc.Driver
	// and for 8 : com.mysql.cj.jdbc.Driver
//		private String driver = "com.mysql.jdbc.Driver";
//		// bridge http is http: , bridge ftp is ftp: , bridge of mysql is jdbc:mysql:
//		// etc...
//		private String bridge = "jdbc:mysql:";
//		private String source = "biblio";
//		private String host = "localhost";
//		private String user = "root";
//		private String password = "";

	// on choisit linterface Connection ( la specefication jdbc pour ne pas dependre
	// à mysql ou autre implemetation )

//	try {
//				// on a la possibilité dutiliser ( exploiter et implementer ) :
//				// javax.sql.DataSource
//				Class.forName(driver);
//				String url = bridge + "//" + host + "/" + source;
//				db = DriverManager.getConnection(url, user, password);
//				System.out.println("Connexion bien établie!");
//
//			} catch (Exception e) {
//				System.out.println("Erreur : " + e.getMessage());
//			}

	
//		public void testSelect() {
//			try {
//				Statement sql = db.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//				ResultSet rs = sql.executeQuery("SELECT * FROM Authors");
//				while (rs.next()) {
//					System.out.println(rs.getString(1) + " - " + rs.getString(2));
//				}
//				sql.close();
//			} catch (Exception e) {
//				System.out.println("Erreur : " + e.getMessage());
//			}
//		}

}

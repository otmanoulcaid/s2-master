package org.mql.biblio.dao.jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.ResultSetMetaData;

public class Database {
	private DataSource datasource;
//	on implemente avec l'interface et non pas la classe 
	private Connection db;
	
	public Database(DataSource datasource) {
		this.datasource=datasource;
		db=datasource.getConnection();
	}
	
	public void setDataSource(DataSource datasource) {
		this.datasource=datasource;
		db=datasource.getConnection();
	
	}
	
	public DataSource getDataSource() {
		return datasource;
	
	}
//	query = requete select
	public String[][] query(String request) {
		try {
			Statement sql=db.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=sql.executeQuery(request);
			//crrer la matrice, sachant le nbr de lgne et col
			int rows, cols;
			//pour recuper la valeur derniere qui contient le dernier row(index) 
			rs.last();
			rows=rs.getRow();
			rs.beforeFirst();
			
			ResultSetMetaData rsm = rs.getMetaData(); //les colonnes sont des metadata(structure de donnees)
			cols=rsm.getColumnCount();
			String data[][] = new String[rows+1][cols];
			for(int i=0; i<cols; i++) {
				data[0][i]= rsm.getColumnName(i+1);
			}
			int row=0;
			while(rs.next()) {
				row++;
				//parcourir les cols de resultset
				for(int col = 0; col<cols; col++) {
					data[row][col]=rs.getString(col+1);//refactoring total de la fonction testselect qui etait avant et qui fait l;extarcion manuellemnt
				}
			}
			sql.close();
			return data;
		}
	catch(Exception e) {
		System.out.println("Erreur : "+ e.getMessage());
		return null;
	}
	}
	//un service
	public String[][] select(String tableName) {
		String request="SELECT * FROM " + tableName;
		return query(request);
	}
	public String[][] selectByKeyword(String tableName, String key, Object value) {
		String request="SELECT * FROM " + tableName + " WHERE "+ key + " LIKE '%"+ value + "%'";
		return query(request);
	}
	//La suite des metehodes select()..........
	
	//refactoring1=stringbuffer/stringbuilder
	//refactoring2 = avec flux 
	public boolean insert(String tableName, Object... row) {//avec donnnes primitives
		String query="INSERT INTO " + tableName + " VALUES('"+ row[0] + "'";//transformer en quelques choses qui se base sur le mapping(donnes doivent etre separes par virgule)
		for(int i= 1; i< row.length; i++) {
			query += ", '" + row[i] + "'"; 
		}
		query +=")";
		try {
			Statement sql=db.createStatement();
			int result=sql.executeUpdate(query);
			if(result==1) return true;
			return false;
			
		}catch(Exception e) {
			System.out.println("Erreur : "+ e.getMessage());
			return false;
		}
	}
	public boolean insert(String tableName, Object model) {// on suppose que les champs sont de type simple et que les donnees ont la meme ordre, et ont les memes noms
		try {
			Field fields[] = model.getClass().getDeclaredFields();
			Object row[] = new Object[fields.length];
			for(int i=0; i< row.length; i++) {
				fields[i].setAccessible(true);
				row[i]=fields[i].get(model);
				fields[i].setAccessible(false);
			}
			return insert(tableName, row);
		}catch(Exception e) {
			System.out.println("Erreur :" + e.getMessage());
			return false;
		}
	}
	
	
}

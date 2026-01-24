package org.mql.jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Database {

	private DataSource dataSource;
	private Connection db;
	
	public Database(DataSource dataSource)
	{
		this.dataSource = dataSource;
		db = dataSource.getConnection();
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		db = dataSource.getConnection();
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public String [][] query(String request)
	{
		try {
			Statement sql = db.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet set = sql.executeQuery(request); //ResultSet est un curseur 
			set.last();
			int rows = set.getRow(), cols;
			ResultSetMetaData rsmd = set.getMetaData();
			cols = rsmd.getColumnCount();
			String [][] result = new String [rows + 1][cols];
			for (int i = 0 ; i < cols; i++)
				result[0][i] = rsmd.getColumnLabel(i + 1);
			
			int row = 0;
			set.beforeFirst();
			while (set.next())
			{
			 	row++;
			 	for (int col = 0; col<cols; col++)			 	
			 		result[row][col] = set.getString(col +1);
			}
			sql.close();
			return result;
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}
	
	public String [][] select (String tableName)
	{
		String request = "SELECT * FROM " + tableName + ";";
		return query(request);
	}
	
	public String [][] selectByKeyword (String tableName, String key, Object value)
	{
		String request = "SELECT * FROM " + tableName + " WHERE " + key + " LIKE '%" + value + "%';";
		return query(request);
	}
	
	public String [][] selectByField (String tableName, String field, Object value)
	{
		String request = "SELECT * FROM " + tableName + " WHERE " + field + " = " + value + ";";
		return query(request);
	}
	
	//la suite des methodes de select()...
	
	private boolean executeStatement(String query)
	{
		try
		{
			Statement sql = db.createStatement();
			int result = sql.executeUpdate(query);
			return result == 1;
		}
		catch(Exception e)
		{
			System.out.println("erruer : " + e.getMessage());
			return false;
		}
	}
	
	public boolean insert(String table, Object... row)
	{
		String query = "INSERT INTO " + table + " VALUES('"  + row[0] + "'";
		for (int i = 1; i < row.length ; i++)
			query += ", '" + row[i] + "'";
		query += ");";
		System.out.println(query);
		return executeStatement(query);
	}
	

	public boolean insert(String table, Object row)
	{
		try {
			Field [] field = row.getClass().getDeclaredFields();
			Object rows [] = new Object[field.length];
			for (int i = 0; i < field.length; i++) {
				field[i].setAccessible(true);
					rows[i] = field[i].get(row);
				field[i].setAccessible(false);
			}
			return insert(table, rows);
		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
		}
		
		return false;
	}
	
	public boolean update(String table, String [] keys, String [] values, String field,  Object value)
	{
		String query = "UPDATE " + table +  " SET ";
		int i = 0; // used in the instruction out of the for loop
		for (i = 0; i < keys.length - 1 && i < values.length - 1; i++)
			query += keys[i] + " = " + values[i] + ", ";
		query += keys[i] + " = " + values[i];
		query += " WHERE " + field + " = " + value + ";";
		
		return executeStatement(query);
	}
	
	public boolean delete(String table, String field, Object value)
	{
		String query = "DELETE FROM " + table + " WHERE " + field + " = " + value + ";";
		return executeStatement(query);
	}
	
}

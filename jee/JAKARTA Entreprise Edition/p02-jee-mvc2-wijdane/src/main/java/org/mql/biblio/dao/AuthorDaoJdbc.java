package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.dao.jdbc.Database;
import org.mql.biblio.models.Author;


public class AuthorDaoJdbc implements AuthorDao{
    
	private Database db;
	private String tableName ="Authors";
	
	public AuthorDaoJdbc(Database db) {		
		this.db=db;
	}
	
	public void setTableName(String tableName) {
		this.tableName=tableName;
	}
	
	@Override
	public boolean insert(Author author) {
		return db.insert("authors", author);
	}
	@Override
	public boolean update(Author author) {
		return false;
	}
	
	@Override
	public boolean delete(int id) {
		return false;
		
	}
	@Override
	public Author select(int id) {
		return null;
	}
	
	@Override
	public List<Author> selectAll() {
	 
	    String[][] data = db.select(tableName);
	    return ORM.getAuthors(data);
	   
	}


}

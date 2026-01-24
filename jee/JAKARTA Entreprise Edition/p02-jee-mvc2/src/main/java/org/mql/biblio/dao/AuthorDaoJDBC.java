package org.mql.biblio.dao;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.dao.jdbc.Database;
import org.mql.biblio.models.Author;

public class AuthorDaoJDBC implements AuthorDao {
	private Database db;
	private String tableName = "Authors";

	public AuthorDaoJDBC(Database db) {
		this.db = db;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public boolean insert(Author author) {
		return db.insert(tableName, author.getId(), author.getName(), author.getYearBorn());
	}

	@Override
	public boolean update(Author author) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Author select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> selectAll() {
		List<Author> authors = new Vector<>();
		String[][] data = db.select(tableName);
		return ORM.getAuthors(data);
	}

}

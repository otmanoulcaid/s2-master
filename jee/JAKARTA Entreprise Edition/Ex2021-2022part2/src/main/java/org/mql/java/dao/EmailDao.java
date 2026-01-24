package org.mql.java.dao;

import java.util.List;

import org.mql.java.models.Email;

public interface EmailDao {
	public List<Email> selectAll();

}

package org.mql.exam.config;

import org.mql.exam.business.DefaultStudentService;
import org.mql.exam.business.StudentService;
import org.mql.exam.dao.StudentDao;
import org.mql.exam.dao.StudentDefaultDao;
import org.mql.exam.dao.jdbc.DataSource;
import org.mql.exam.dao.jdbc.Database;
import org.mql.exam.dao.jdbc.MySQLDataSource;

public class Context {

	private static DefaultStudentService studentService;
	
	static {
		DataSource ds = new MySQLDataSource();
		Database db = new Database(ds);
		StudentDao dao = new StudentDefaultDao(db);
		studentService = new DefaultStudentService(dao);
	}
	
	public static StudentService getService() {
		return studentService;
	}
}

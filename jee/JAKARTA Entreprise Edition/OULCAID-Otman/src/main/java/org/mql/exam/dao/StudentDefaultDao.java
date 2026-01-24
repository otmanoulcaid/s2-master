package org.mql.exam.dao;

import org.mql.exam.dao.jdbc.Database;
import org.mql.exam.models.Student;

public class StudentDefaultDao implements StudentDao {

	private Database mysql;

	public StudentDefaultDao(Database mysql) {
		super();
		this.mysql = mysql;
	}

	@Override
	public Student getStudent(int id) {
		return mysql.getById(id);
	}

	@Override
	public String [][] getStudents() {
		return mysql.select("student");
	}

	@Override
	public void deleteStudent(int id) {
		mysql.delete();
		
	}

	@Override
	public void updateStudent(Student student) {
		mysql.update(student);
	}

	@Override
	public void addStudent(Student student) {
		mysql.insert("Student", student);
		
	}
}

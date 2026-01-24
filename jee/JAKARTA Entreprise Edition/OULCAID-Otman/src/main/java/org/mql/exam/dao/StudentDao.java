package org.mql.exam.dao;

import org.mql.exam.models.Student;

public interface StudentDao {
	Student getStudent(int id);
	String [][] getStudents();
	void deleteStudent(int id);
	void updateStudent(Student student);
	void addStudent(Student student);
}

package org.mql.exam.business;

import org.mql.exam.models.Student;

public interface StudentService {
	Student getStudent(int id);
	String [][] getStudents();
	void deleteStudent(int id);
	void updateStudent(Student student);
	void addStudent(Student student);
}

package org.mql.devops.dao;

import java.util.List;
import java.util.Vector;

import org.mql.devops.models.Student;

public class MockStudentDAO implements StudentDAO {
    private List<Student> students = new Vector<>();

    public MockStudentDAO() {
        students.add(new Student(1, "Ali", "Bennani", "ali.bennani@example.com", "2000-01-01"));
        students.add(new Student(2, "Sara", "Bennani", "sara.bennani@example.com", "1999-12-12"));
    }

	@Override
	public List<Student> getAllStudent() {
		return students;
	}
}

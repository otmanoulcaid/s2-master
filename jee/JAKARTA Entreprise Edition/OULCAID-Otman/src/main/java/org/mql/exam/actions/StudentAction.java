package org.mql.exam.actions;

import java.util.List;

import org.mql.exam.dao.ORM;
import org.mql.exam.models.Student;
import org.mql.exam.config.Context;
import org.mql.exam.business.StudentService;

public class StudentAction {

	private StudentService studentService;

	public StudentAction() {
		studentService = Context.getService();
	}

	public List<Student> getStudents()
	{
		return ORM.getStudent(studentService.getStudents());
	}
}

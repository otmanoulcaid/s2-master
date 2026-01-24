package org.mql.exam.business;

import org.mql.exam.dao.StudentDao;
import org.mql.exam.models.Student;

public class DefaultStudentService implements StudentService{
	
	private StudentDao dao;

	public DefaultStudentService(StudentDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public Student getStudent(int id) {
		return dao.getStudent(id);
	}

	@Override
	public String[][] getStudents() {
		return dao.getStudents();
	}

	@Override
	public void deleteStudent(int id) {
		dao.deleteStudent(id);
	}

	@Override
	public void updateStudent(Student student) {
		dao.updateStudent(student);
	}

	@Override
	public void addStudent(Student student) {
		dao.addStudent(student);
	}

}

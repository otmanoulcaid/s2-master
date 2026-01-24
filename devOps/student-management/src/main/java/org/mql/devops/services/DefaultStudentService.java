package org.mql.devops.services;

import java.util.List;

import org.mql.devops.dao.StudentDAO;
import org.mql.devops.models.Student;

public class DefaultStudentService implements StudentService {

	StudentDAO studentDao;
	
	public DefaultStudentService() {
		// TODO Auto-generated constructor stub
	}
	
	public DefaultStudentService(StudentDAO studentDao) {
		super();
		this.studentDao = studentDao;
	}

	public StudentDAO getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> getAllStudent() {
		return this.studentDao.getAllStudent();
	}
	
}

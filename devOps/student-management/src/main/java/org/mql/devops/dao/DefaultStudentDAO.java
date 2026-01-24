package org.mql.devops.dao;

import java.util.List;
import java.util.Vector;

import org.mql.devops.models.Student;
import org.mql.parser.XMLNode;

public class DefaultStudentDAO implements StudentDAO {
	
	private XMLNode xmlParser;
	
	public DefaultStudentDAO() {
		// TODO Auto-generated constructor stub
	}

	public DefaultStudentDAO(XMLNode xmlParser) {
		super();
		this.xmlParser = xmlParser;
	}

	@Override
	public List<Student> getAllStudent() {
		 List<Student> students = new Vector<>();

	        XMLNode[] studentNodes = xmlParser.children();

	        for (XMLNode node : studentNodes) {
	            int id = Integer.parseInt(node.child("id").getValue());
	            String firstName = node.child("firstName").getValue();
	            String lastName = node.child("lastName").getValue();
	            String email = node.child("email").getValue();
	            String birthDate = node.child("birthDate").getValue();

	            Student student = new Student(id, firstName, lastName, email, birthDate);
	            students.add(student);
	        }

	        return students;
	    }

}

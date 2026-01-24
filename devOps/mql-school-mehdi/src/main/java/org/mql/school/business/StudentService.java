package org.mql.school.business;

import java.util.List;
import java.util.UUID;

import org.mql.school.business.exceptions.StudentNotFoundException;
import org.mql.school.model.Student;

public interface StudentService {
  Student getStudentById(UUID id) throws StudentNotFoundException;

  List<Student> getAllStudents();

  void addStudent(Student student);
}

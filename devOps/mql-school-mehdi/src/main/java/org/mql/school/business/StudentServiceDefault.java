package org.mql.school.business;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.mql.school.business.exceptions.StudentNotFoundException;
import org.mql.school.dao.StudentDao;
import org.mql.school.model.Student;

public class StudentServiceDefault implements StudentService {
  private StudentDao dao;

  public StudentServiceDefault(StudentDao dao) {
    this.dao = dao;
  }

  @Override
  public Student getStudentById(UUID id) throws StudentNotFoundException {
    // dao is mockito instance
    // returned the optional decided by mockito config
    Optional<Student> optionalStudent = dao.selectStudentById(id);

    // NULL pointer exception if student is null
    // System.out.println("Student id", student.email());

    if (optionalStudent.isEmpty()) {
      throw new StudentNotFoundException();
    }

    return optionalStudent.get();
  }

  @Override
  public List<Student> getAllStudents() {
    return dao.selectAllStudents();
  }

  @Override
  public void addStudent(Student student) {
    dao.insertStudent(student);
  }

}

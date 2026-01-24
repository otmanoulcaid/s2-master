package org.mql.school.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.mql.school.model.Student;

public interface StudentDao {
  List<Student> selectAllStudents();

  Optional<Student> selectStudentById(UUID id);

  void insertStudent(Student student);
}

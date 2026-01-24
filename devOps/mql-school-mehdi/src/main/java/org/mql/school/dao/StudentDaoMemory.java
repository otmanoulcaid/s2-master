package org.mql.school.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.mql.school.dao.database.Database;
import org.mql.school.model.Student;

public class StudentDaoMemory implements StudentDao {

  @Override
  public List<Student> selectAllStudents() {
    return Database.students;
  }

  @Override
  public Optional<Student> selectStudentById(UUID id) {
    // return Database.students
    // .stream()
    // .filter(student -> student.id().equals(id))
    // .findFirst()

    for (Student student : Database.students) {
      if (student.id().equals(id)) {
        return Optional.of(student);
      }
    }

    return Optional.empty();
  }

  @Override
  public void insertStudent(Student student) {
    Database.students.add(student);
  }

}

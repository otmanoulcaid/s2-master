package org.mql.school.fixtures.fakes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.mql.school.dao.StudentDao;
import org.mql.school.fixtures.database.TestDatabase;
import org.mql.school.model.Student;

public class StudentDaoFake implements StudentDao {

  @Override
  public List<Student> selectAllStudents() {
    return TestDatabase.students;
  }

  @Override
  public Optional<Student> selectStudentById(UUID id) {
    // return Database.students
    // .stream()
    // .filter(student -> student.id().equals(id))
    // .findFirst()

    for (Student student : TestDatabase.students) {
      if (student.id().equals(id)) {
        return Optional.of(student);
      }
    }

    return Optional.empty();
  }

  @Override
  public void insertStudent(Student student) {
    TestDatabase.students.add(student);
  }
}

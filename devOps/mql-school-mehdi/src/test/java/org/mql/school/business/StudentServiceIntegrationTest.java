package org.mql.school.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mql.school.business.exceptions.StudentNotFoundException;
import org.mql.school.dao.StudentDao;
import org.mql.school.dao.StudentDaoMemory;
import org.mql.school.model.Student;

public class StudentServiceIntegrationTest {

  StudentDao dao = new StudentDaoMemory();

  StudentServiceDefault service = new StudentServiceDefault(dao);

  @Test
  void shouldReturnCorrectStudentWhenGivenId() throws StudentNotFoundException {
    // Arrange
    UUID studentId = UUID.fromString("336a0ca4-29f0-4ebf-a52d-bedd1f73b96f");

    Student correctStudent = new Student(studentId, "Reda", "reda@gmail.com");
    service.addStudent(correctStudent);

    // Act
    Student student = service.getStudentById(studentId);

    // Assert
    assertEquals("reda@gmail.com", student.email());

  }

  @AfterEach
  void cleanTests() {
    // delete all added data by this tes
  }

}

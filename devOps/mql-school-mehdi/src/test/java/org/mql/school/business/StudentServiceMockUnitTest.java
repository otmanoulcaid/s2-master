package org.mql.school.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mql.school.business.exceptions.StudentNotFoundException;
import org.mql.school.dao.StudentDao;
import org.mql.school.model.Student;

public class StudentServiceMockUnitTest {
  StudentService service;
  StudentDao dao;

  @BeforeEach
  void init() {
    // new something
    dao = Mockito.mock();

    service = new StudentServiceDefault(dao);
  }

  @Test
  void shouldReturnCorrectStudentWhenGivenId() throws StudentNotFoundException {
    // Arrange
    UUID studentId = UUID.fromString("336a0ca4-29f0-4ebf-a52d-bedd1f73b96f");

    Mockito.when(dao.selectStudentById(studentId))
        .thenReturn(Optional.of(new Student(studentId, "El Mehdi", "reda@gmail.com")));

    // Act
    Student student = service.getStudentById(studentId);

    // Assert
    assertEquals("reda@gmail.com", student.email());
  }
}

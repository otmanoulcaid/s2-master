package org.mql.school.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mql.school.business.exceptions.StudentNotFoundException;
import org.mql.school.config.TestWiring;
import org.mql.school.model.Student;

public class StudentServiceFakeUnitTest {

  @Test
  void shouldReturnCorrectStudentWhenGivenId() throws StudentNotFoundException {
    // Arrange
    StudentService service = TestWiring.service;

    // Act
    Student student = service.getStudentById(UUID.fromString("336a0ca4-29f0-4ebf-a52d-bedd1f73b96f"));

    // Assert
    assertEquals("reda@gmail.com", student.email());
  }
}

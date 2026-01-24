package org.mql.school.Database;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mql.school.config.Wiring;
import org.mql.school.model.Student;
import org.mql.school.service.StudentService;

public class StudentServiceTest {
    @Test 
    public void shouldReturnCorrectStudentWhenGivenId() {
        // Arrange
        StudentService studentService = Wiring.getStudentService();

        // Act
        Student student = studentService.getStudentById(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));

        // Assert
        assertEquals("reda@example.com", student.email());
    }
}

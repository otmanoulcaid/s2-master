package org.mql.devops.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mql.devops.dao.MockStudentDAO;
import org.mql.devops.models.Student;

public class DefaultStudentServiceTest {
    private DefaultStudentService service;

    @Test
    public void testGetAllStudents() {
    	service = new DefaultStudentService(new MockStudentDAO());

        List<Student> students = service.getAllStudent();

        assertEquals(2, students.size());
    }
}

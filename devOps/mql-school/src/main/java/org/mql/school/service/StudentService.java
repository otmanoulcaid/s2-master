package org.mql.school.service;

import java.util.List;
import java.util.UUID;

import org.mql.school.model.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(UUID id);
    void addStudent(Student student);
}

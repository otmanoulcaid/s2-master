package org.mql.school.dao;

import java.util.List;
import java.util.UUID;

import org.mql.school.model.Student;

public interface StudentDao {
    List<Student> selectAllStudent();
    Student selectStudentById(UUID id);
    public void addStudent(Student student);
}

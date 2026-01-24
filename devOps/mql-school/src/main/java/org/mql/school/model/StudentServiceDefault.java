package org.mql.school.model;

import java.util.List;
import java.util.UUID;

import org.mql.school.dao.StudentDao;
import org.mql.school.service.StudentService;
import org.mql.school.service.exceptions.StudentException;

public class StudentServiceDefault  implements StudentService{
    private StudentDao studentDao;

    public StudentServiceDefault(StudentDao studentDao)
    {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.selectAllStudent();
    }

    @Override
    public Student getStudentById(UUID id) {
        Student student = studentDao.selectStudentById(id);
        if (student == null)
            throw new StudentException("Student not found");
        return student;
    }

    @Override
    public void addStudent(Student student) {
        if (student == null)
            throw new StudentException("Student is null");
        studentDao.addStudent(student);
    }
}


// publication (RMI)
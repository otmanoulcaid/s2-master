package org.mql.school.dao;

import java.util.List;
import java.util.UUID;

import org.mql.school.model.Student;

public  class StudentDaoMemeory implements StudentDao {
    @Override
    public List<Student> selectAllStudent() {
        return Database.getStudents();
    }

    @Override
    public Student selectStudentById(UUID id) {
        // return Database.getStudents()
        //         .stream()
        //         .filter(s -> s.id().equals(id))
        //         .findFirst()
        //         .get();
        for (Student st : Database.getStudents())
            if (st.id().equals(id))
                return st;
        return null;
    }

    @Override
    public void addStudent(Student student)
    {
        Database.add(student);
    }
}
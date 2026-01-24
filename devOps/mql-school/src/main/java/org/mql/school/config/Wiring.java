package org.mql.school.config;

import org.mql.school.dao.StudentDaoMemeory;
import org.mql.school.model.StudentServiceDefault;
import org.mql.school.service.StudentService;

public class Wiring {
    private  static final StudentService studentService = new StudentServiceDefault(new StudentDaoMemeory());

    public static StudentService getStudentService() {
        return studentService;
    }
}

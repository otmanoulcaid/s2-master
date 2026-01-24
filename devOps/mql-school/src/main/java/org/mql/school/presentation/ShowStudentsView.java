package org.mql.school.presentation;

import java.util.List;

import org.mql.school.config.Wiring;
import org.mql.school.model.Student;
import org.mql.school.service.StudentService;

public class ShowStudentsView implements View {
    
    public void show() {
        StudentService studentService = Wiring.getStudentService();
        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("List of students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}

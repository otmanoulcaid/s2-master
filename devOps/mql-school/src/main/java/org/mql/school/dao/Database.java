package org.mql.school.dao;

import java.util.List;
import java.util.UUID;
import java.util.Vector;

import org.mql.school.model.Student;
    
public class Database {
    static List<Student> students;
    
    static {
            students = new Vector<>();
            students.add(new Student(UUID.fromString("133525d2-c356-4adc-9aed-402a5d8d7be9"), "John Doe", "john@example.com"));
            students.add(new Student(UUID.fromString("30707aff-b699-4485-b92c-4871c7488ab5"), "Jane Smith", "jane@example.com"));
            students.add(new Student(UUID.fromString("69868b6c-2f1d-4a8b-b93d-f016133999c7"), "Alice Johnson", "alice@example.com"));
        }

    public static List<Student> getStudents() {
        return students;
    }

    public static void add(Student student) {
        students.add(student);
    }

}

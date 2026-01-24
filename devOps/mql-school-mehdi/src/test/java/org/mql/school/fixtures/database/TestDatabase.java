package org.mql.school.fixtures.database;

import java.util.List;
import java.util.UUID;
import java.util.Vector;

import org.mql.school.model.Student;

public class TestDatabase {

  public static List<Student> students = new Vector<>();

  static {
    // students = new Vector<>();

    students.add(new Student(UUID.fromString("9e7bf226-1fb3-440c-b521-5f771709f79b"), "El Mehdi", "mehdi@gmail.com"));
    students.add(new Student(UUID.fromString("336a0ca4-29f0-4ebf-a52d-bedd1f73b96f"), "Reda", "reda@gmail.com"));
    students
        .add(new Student(UUID.fromString("04308c96-9742-4ba9-a98c-420fb2c6cb93"), "Mohammed", "mohammed@gmail.com"));

  }
}

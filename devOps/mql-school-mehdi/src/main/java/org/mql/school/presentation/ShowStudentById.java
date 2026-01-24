package org.mql.school.presentation;

import java.util.UUID;

import org.mql.school.business.StudentService;
import org.mql.school.business.exceptions.StudentNotFoundException;
import org.mql.school.config.Wiring;
import org.mql.school.model.Student;

public class ShowStudentById implements View {

  @Override
  public void show() {
    StudentService service = Wiring.service;

    try {
      Student student = service.getStudentById(UUID.fromString("04308c96-9742-4ba9-a98c-420fb2c6cb93"));
      System.out.println("Student");
      System.out.println(student);
    } catch (StudentNotFoundException e) {
      System.out.println("An error has accured");
    }
  }

}

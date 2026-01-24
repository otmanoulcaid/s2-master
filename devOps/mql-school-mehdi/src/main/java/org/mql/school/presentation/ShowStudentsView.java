package org.mql.school.presentation;

import org.mql.school.business.StudentService;
import org.mql.school.config.Wiring;

public class ShowStudentsView implements View {

  @Override
  public void show() {
    StudentService service = Wiring.service;

    System.out.println("Students");
    System.out.println(service.getAllStudents());
  }

}

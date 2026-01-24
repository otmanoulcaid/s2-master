package org.mql.school.config;

import org.mql.school.business.StudentService;
import org.mql.school.business.StudentServiceDefault;
import org.mql.school.fixtures.fakes.StudentDaoFake;

public class TestWiring {
  public static final StudentService service = new StudentServiceDefault(new StudentDaoFake());
}

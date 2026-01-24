package org.mql.school.config;

import org.mql.school.business.StudentService;
import org.mql.school.business.StudentServiceDefault;
import org.mql.school.dao.StudentDaoMemory;

public class Wiring {
  public static final StudentService service = new StudentServiceDefault(new StudentDaoMemory());
}

public package business;

import dto.LoginRequest;
import model.Student;

interface ESchoolService {
    public void signup(Student student);

    public Student login(LoginRequest request);
}
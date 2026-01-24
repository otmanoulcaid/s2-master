package business;

import dto.LoginRequest;
import model.Student;

public class ESchoolServiceDefault implements ESchoolService {

    @Override
    public void signup(Student student)
    {
        System.out.println(student);
    }

    public Student login(LoginRequest request)
    {
        return null;
    }
    
}
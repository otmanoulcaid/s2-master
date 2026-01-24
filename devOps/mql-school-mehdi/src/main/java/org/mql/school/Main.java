package org.mql.school;

import org.mql.school.presentation.ShowStudentById;
import org.mql.school.presentation.ShowStudentsView;
import org.mql.school.presentation.View;

public class Main {
    public static void main(String[] args) {
        View view = new ShowStudentById();
        view.show();
    }
}
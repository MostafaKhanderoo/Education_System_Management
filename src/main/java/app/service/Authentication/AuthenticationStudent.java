package app.service.Authentication;

import app.entity.Admin;
import app.entity.Student;

public class AuthenticationStudent {
    private static Student loggedInStudent;

    public static void setLoggedStudent(Student student){
        loggedInStudent = student;
    }

    public static Student getLoggedInStudent (){
        return loggedInStudent;
    }

    public static void logout(){
        loggedInStudent = null;
    }
}

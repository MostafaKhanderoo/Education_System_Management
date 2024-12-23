package app.service.Authentication;

import app.entity.Admin;
import app.entity.Teacher;

public class AuthenticationTeacher {
    private static Teacher loggedInTeacher;

    public static void setLoggedTeacher(Teacher teacher){
        loggedInTeacher = teacher;
    }

    public static Teacher getLoggedInTeacher (){
        return loggedInTeacher;
    }

    public static void logout(){
        loggedInTeacher = null;
    }
}

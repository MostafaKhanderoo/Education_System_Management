package app.service.Authentication;

import app.entity.Admin;

public class AuthenticationAdmin {
    private static Admin loggedInAdmin;

    public static void setLoggedAdmin(Admin admin){
        loggedInAdmin = admin;
    }

    public static Admin getLoggedInAdmin (){
        return loggedInAdmin;
    }

    public static void logout(){
        loggedInAdmin = null;
    }

}

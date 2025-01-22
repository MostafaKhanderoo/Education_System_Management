package app.ui;

import app.repository.impl.TeacherRepositoryImpl;
import app.service.impl.TeacherServiceImpl;

import java.util.Scanner;

public class TeacherUI {
final  private  static Scanner scanner = new Scanner(System.in);
final private static TeacherRepositoryImpl teacherRepository = new TeacherRepositoryImpl();
final private static TeacherServiceImpl teacherService =  new TeacherServiceImpl(teacherRepository);
    public  static  void teacherMenu(){
        System.out.println("teacher login");
        System.out.print("enter your personnelCode: ");
        Long personnelCode =scanner.nextLong();
        System.out.println("enter your password");
        String password =scanner.next();

        var test= teacherService.login(personnelCode,password);

        while (test){
            System.out.println("1.see my lessons added");
            System.out.println("2.set a course for students");
            System.out.println("3.update profile");
            System.out.println("4.logout");

        }


    }
}

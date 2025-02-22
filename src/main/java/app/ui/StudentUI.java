package app.ui;

import app.entity.StudentLesson;
import app.repository.impl.LessonRepositoryImpl;
import app.repository.impl.StudentCourseRepositoryImpl;
import app.repository.impl.StudentRepositoryImpl;
import app.service.Authentication.AuthenticationStudent;
import app.service.impl.LessonServiceImpl;
import app.service.impl.StudentCourseServiceImpl;
import app.service.impl.StudentServiceImpl;

import java.util.Scanner;

public class StudentUI {
    final private static LessonRepositoryImpl lessonRepository = new LessonRepositoryImpl();
    final private static LessonServiceImpl lessonService = new LessonServiceImpl(lessonRepository);
    final private static StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
    final private static StudentServiceImpl studentService = new StudentServiceImpl(studentRepository);
    final private static StudentCourseRepositoryImpl studentCourseRepository =new StudentCourseRepositoryImpl();
    final private static StudentCourseServiceImpl studentCourseService =new StudentCourseServiceImpl(studentCourseRepository);
    final private static Scanner scanner = new Scanner(System.in);

    public static void studentMenu() {
        boolean studentLog = true;
        System.out.print("enter your studentNumber: ");
        Long studentNumber = scanner.nextLong();
        System.out.print("enter your password: ");
        String password = scanner.next();

        while (studentLog && studentService.login(studentNumber, password)) {
            System.out.println(AuthenticationStudent.getLoggedInStudent().getFirstname());
            System.out.println("1.List of Available lessons");
            System.out.println("2.choose lesson");
            System.out.println("3.my lessons");
            System.out.println("4.change username and password");
            System.out.println("5.logout");
            System.out.print("choose: ");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println(lessonService.AllLesson());
                    System.out.println();
                    break;
                case 2:
                    chooseLesson();
                    break;
                case 3:
                    seeLessonsStudent();

                    break;
                case 4:changeUsernameAndPassword();
                    break;
                case 5:
                    studentLog =false;
                   break;
                default:
                    System.out.println("error invalid number");

            }

        }
    }
    static void changeUsernameAndPassword(){
        System.out.print("enter new username: ");
        String username = scanner.next();
        System.out.print("enter new password: ");
        String password = scanner.next();

        studentService.changeUsernameAndPassword(username,password);
        System.out.println("username and password changed");
        System.out.println();
    }

    static void seeLessonsStudent() {
        System.out.println("yor Lessons: ");
        var studentNumber = AuthenticationStudent.getLoggedInStudent().getStudentNumber();
        System.out.println(studentCourseService.seeLessonByStudentNumber(studentNumber));
        System.out.println();
    }
    static void chooseLesson(){
        System.out.println(lessonService.AllLesson());
        System.out.println();
        System.out.print("choose lesson Number: ");
        Long lessonNumber = scanner.nextLong();
        studentCourseService.chooseLessonForStudent(lessonNumber);
    }
}

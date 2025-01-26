package app.ui;

import app.repository.impl.StudentCourseRepositoryImpl;
import app.repository.impl.StudentRepositoryImpl;
import app.repository.impl.TeacherRepositoryImpl;
import app.service.Authentication.AuthenticationTeacher;
import app.service.impl.StudentCourseServiceImpl;
import app.service.impl.StudentServiceImpl;
import app.service.impl.TeacherServiceImpl;

import java.util.Scanner;

public class TeacherUI {
    final private static Scanner scanner = new Scanner(System.in);
    final private static TeacherRepositoryImpl teacherRepository = new TeacherRepositoryImpl();
    final private static TeacherServiceImpl teacherService = new TeacherServiceImpl(teacherRepository);
    final private static StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
    final private static StudentServiceImpl studentService = new StudentServiceImpl(studentRepository);
    final private static StudentCourseRepositoryImpl studentCourseRepository = new StudentCourseRepositoryImpl();
    final private static StudentCourseServiceImpl studentCourseService = new StudentCourseServiceImpl(studentCourseRepository);

    public static void teacherMenu() {
        System.out.println("teacher login");
        System.out.print("enter your personnelCode: ");
        Long personnelCode = scanner.nextLong();
        System.out.println("enter your password");
        String password = scanner.next();

        var teacherLog = teacherService.login(personnelCode, password);

        while (teacherLog) {

            System.out.println(AuthenticationTeacher.getLoggedInTeacher().getFirstname());

            System.out.println("1.see my lessons added");
            System.out.println("2.see student of my lesson");
            System.out.println("3.set a course for students");
            System.out.println("4.update username or password");
            System.out.println("5.logout");
            System.out.print("choose: ");
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    System.out.println(teacherService.lessonsOfTeacher());
                    break;
                case 2:
                    seeStudentByLessonNumber();
                    break;
                case 3:
                    setScoreForStudent();
                    break;
                case 4:
                    updateUsernameAdnPassword();
                case 5:
                    teacherLog = false;
                    break;
                default:
                    System.out.println("invalid number!  ");

            }
            return;

        }


    }

    static void updateUsernameAdnPassword() {
        System.out.print("enter new username: ");
        String username = scanner.next();
        System.out.print("enter new password");
        String password = scanner.next();

        teacherService.changeUsernameAndPassword(username, password);
        System.out.println("username and password changed!");
        System.out.println();
    }

    static void setScoreForStudent() {
        System.out.println(teacherService.lessonsOfTeacher());
        System.out.print("choose a lesson number for set score :");
        Long lessonNumber = scanner.nextLong();
        var studentOfLesson = studentCourseService.seeStudentByLessonNumber(lessonNumber);
        System.out.println(studentOfLesson);
        System.out.print("choose a student for set score: ");
        Long studentNumber = scanner.nextLong();
        System.out.print("OK now enter the number of 0 to 20 for set score: ");
        Double score = scanner.nextDouble();
        studentCourseService.setScoreForStudentByTeacher(lessonNumber, studentNumber, score);
    }

    static void seeStudentByLessonNumber() {
        System.out.println(teacherService.lessonsOfTeacher());
        System.out.println();
        System.out.print("choose lessonNumber to see Student: ");
        Long lessonNumber = scanner.nextLong();
        var studentOfLesson = studentCourseService.seeStudentByLessonNumber(lessonNumber);
        System.out.println(studentOfLesson);
    }
}

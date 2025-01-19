package app.ui;

import app.Main;
import app.entity.Student;
import app.entity.Teacher;
import app.enumeration.Degree;
import app.enumeration.Expertise;
import app.repository.impl.AdminRepositoryImpl;
import app.repository.impl.LessonRepositoryImpl;
import app.repository.impl.StudentRepositoryImpl;
import app.repository.impl.TeacherRepositoryImpl;
import app.service.Authentication.AuthenticationAdmin;
import app.service.impl.AdminServiceImpl;
import app.service.impl.LessonServiceImpl;
import app.service.impl.StudentServiceImpl;
import app.service.impl.TeacherServiceImpl;

import java.util.Scanner;

public class AdminUI {
    private static StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
    private static StudentServiceImpl studentService = new StudentServiceImpl(studentRepository);
    private static LessonRepositoryImpl lessonRepository = new LessonRepositoryImpl();
    private static LessonServiceImpl lessonService = new LessonServiceImpl(lessonRepository);
    private static TeacherRepositoryImpl teacherRepository = new TeacherRepositoryImpl();
    private static TeacherServiceImpl teacherService = new TeacherServiceImpl(teacherRepository);
    private static AdminRepositoryImpl adminRepository = new AdminRepositoryImpl();
    private static AdminServiceImpl adminService = new AdminServiceImpl(adminRepository);
    private static Scanner scanner = new Scanner(System.in);
    private static boolean onlineAdmin = true;
    private static Teacher teacher = new Teacher();


    public static void adminMenu() {
        if (onlineAdmin) {
            System.out.println("Welcome Login page");
            System.out.print("username: ");
            String username = scanner.nextLine();
            System.out.print("password: ");
            String password = scanner.nextLine();
            adminService.login(username, password);
            System.out.println();
            System.out.println("Welcome " + AuthenticationAdmin.getLoggedInAdmin().getAdminName());

        } else {
            onlineAdmin = false;
        }
        boolean onlineAdmin1 = true;
        System.out.println("1.Teachers Management Menu");
        System.out.println("2.Students Management Menu");
        System.out.println("3.Lessons Management Menu");
        System.out.println("4.Logout");
        System.out.print("choose: ");
        while (onlineAdmin1) {

            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    teacherManagementMenu();
                    break;
                case 2:
                    studentManagementMenu();

                    break;
                case 3:
                    lessonManagementMenu();
                    break;
                case 4:
                    onlineAdmin1 = false;
                    // Main.isExist =false;
                    break;
                default:

                    System.out.println("invalid number");
            }

            // Student Management Menu
        }

    }

    private static void addNewTeacher() {
        Teacher teacher = new Teacher();
        System.out.print("firstname: ");
        String firstname = scanner.nextLine();
        System.out.print("lastname: ");
        String lastname = scanner.nextLine();
        System.out.print("username: ");
        String username = scanner.nextLine();
        System.out.print("password: ");
        String password = scanner.nextLine();
        System.out.print("phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("email: ");
        String email = scanner.nextLine();
        System.out.print("nationalCode: ");
        String nationalCode = scanner.nextLine();
        Expertise expertise;
        Degree degree;

        Long personnelCode = scanner.nextLong();
        teacher.setFirstname(firstname);
        teacher.setLastname(lastname);
        teacher.setUsername(username);
        teacher.setPassword(password);
        teacher.setPhoneNumber(phoneNumber);
        teacher.setEmail(email);
        teacher.setNationalCode(nationalCode);
        System.out.print("Expertise: ");
        teacher.setExpertise(Expertise.ENGINEERING);
        System.out.print("Degree: ");
        teacher.setDegree(Degree.TEST1);
        teacher.setPersonnelCode(personnelCode);
        teacherService.save(teacher);
    }

    private static void teacherManagementMenu() {
        System.out.println("1.See All Teacher");
        System.out.println("2.Add New Teacher");
        System.out.println("3.Delete Teacher");
        System.out.println("4.Update Teacher Profile");
        System.out.print("choose: ");
        int input = scanner.nextInt();
        Boolean onlineInTeacherMenu = true;
        while (onlineInTeacherMenu) {
            switch (input) {
                case 1:
                    System.out.println(teacherService.showAllTeacher());
                    onlineInTeacherMenu = false;
                    break;
                case 2:
                    addNewTeacher();
                    onlineInTeacherMenu = false;


                    break;
                default:
                    System.out.println("invalid number");
            }
        }
    }

    //static  void addNewStudent(){
//    Student student = new Student();
//    String firstname = scanner.nextLine();
//    String lastName = scanner.nextLine();
//    student.setFirstname();
//}
    static void deleteStudent() {
        System.out.println(studentService.findAll());
        System.out.println();
        System.out.println();
        System.out.print("enter student id: ");
        Long id = scanner.nextLong();
        studentService.deleteById(id);
    }

    private static void studentManagementMenu() {
        System.out.println("1.See All students");
        System.out.println("2.Add New student");
        System.out.println("3.Delete student");
        System.out.println("4.Update student Profile");
        System.out.println("5.log out");
        System.out.print("choose: ");
        boolean onlineInStudentMenu = true;
        int input = scanner.nextInt();
        while (onlineInStudentMenu) {
            switch (input) {
                case 1:
                    studentService.findAll();
                case 2:
                    break;

                case 3:
                    deleteStudent();
                    break;

                default:
                    System.out.println("invalid number!!");
                    onlineInStudentMenu = false;
            }

        }
    }

    private static void lessonManagementMenu() {
        System.out.println("1.See All lessons");
        System.out.println("2.Add New lesson");
        System.out.println("3.Delete lesson");
        System.out.println("4.Update lesson Profile");
        System.out.println("5.log out");
        System.out.print("choose: ");

        boolean onlineInLessonMenu = true;
        int input = scanner.nextInt();
        while (onlineInLessonMenu) {
            switch (input) {
                case 1:
                    lessonService.AllLesson();
                    break;
                case 2:
                    //lessonService.save();
                    break;
                case 3:
                    break;

                default:
                    System.out.println("invalid number");


            }
        }
    }
}

package app.ui;

import app.entity.Lesson;
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

import java.time.LocalDateTime;
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

        while (onlineAdmin1) {
            System.out.println("1.Teachers Management Menu");
            System.out.println("2.Students Management Menu");
            System.out.println("3.Lessons Management Menu");
            System.out.println("4.Logout");
            System.out.print("choose: ");
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
        String firstname = scanner.next();
        System.out.print("lastname: ");
        String lastname = scanner.next();
        System.out.print("username: ");
        String username = scanner.next();
        System.out.print("password: ");
        String password = scanner.next();
        System.out.print("phoneNumber: ");
        String phoneNumber = scanner.next();
        System.out.print("email: ");
        String email = scanner.next();
        System.out.print("nationalCode: ");
        String nationalCode = scanner.next();
        Expertise expertise;
        Degree degree;
        System.out.print("personnelCode: ");
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

    static void removeTeacher() {
        System.out.println(teacherService.showAllTeacher());
        System.out.println("choose one teacher by personnelCode");
        Long personnelCode = scanner.nextLong();
        teacherService.deleteTeacher(personnelCode);
    }

    private static void updateTeacher() {
        System.out.println(teacherService.showAllTeacher());
        System.out.println();
        System.out.print("enter personnelCode teacher to update");
        Long personnelCode = scanner.nextLong();
        Teacher teacher = new Teacher();
        System.out.print("firstname: ");
        String firstname = scanner.next();
        System.out.print("lastname: ");
        String lastname = scanner.next();
        System.out.print("username: ");
        String username = scanner.next();
        System.out.print("password: ");
        String password = scanner.next();
        System.out.print("phoneNumber: ");
        String phoneNumber = scanner.next();
        System.out.print("email: ");
        String email = scanner.next();
        System.out.print("nationalCode: ");
        String nationalCode = scanner.next();
        Expertise expertise;
        Degree degree;
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
        teacherService.update(personnelCode, teacher);
    }

    private static void teacherManagementMenu() {
        System.out.println("1.See All Teacher");
        System.out.println("2.Add New Teacher");
        System.out.println("3.Delete Teacher");
        System.out.println("4.add lesson for Teacher");
        System.out.println("5.Update Teacher Profile");
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
                case 3:
                    removeTeacher();
                    onlineInTeacherMenu = false;
                    break;
                case 4:
                    setLessonForTeacher();
                    onlineInTeacherMenu = false;
                    break;
                case 5:
                    updateTeacher();
                    onlineInTeacherMenu = false;
                    break;
                default:
                    System.out.println("invalid number");
            }
        }
    }

    static void setLessonForTeacher() {
        System.out.println(lessonService.AllLesson());
        System.out.println();
        System.out.print("choose one lesson by id: ");
        Long lessonId = scanner.nextLong();
        System.out.println(teacherService.showAllTeacher());
        System.out.println();
        System.out.print("choose one teacher by id: ");
        Long teacherId = scanner.nextLong();
        lessonService.setTeacherForLesson(lessonId, teacherId);
        System.out.println("added");

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
        Long studentNumber = scanner.nextLong();
        studentService.deleteByStudentNumber(studentNumber);
    }

    static void seeLessonsOfStudent() {
        System.out.println(studentService.findAll());
        System.out.println();
        System.out.print("enter student studentNumber: ");
        Long studentNumber = scanner.nextLong();
        System.out.println("lessons of student");
        System.out.println(studentService.seeLessonByStudentNumber(studentNumber));
    }

    static void seeStudentsOfLessonNumber() {
        System.out.println(lessonService.AllLesson());
        System.out.println();
        System.out.print("enter lessonNumber");
        Long lessonNumber = scanner.nextLong();
        System.out.println(studentService.seeStudentByLessonNumber(lessonNumber));
    }

    static void addNewStudent() {
        System.out.println("create new student profile");
        Student student = new Student();
        System.out.print("firstName: ");
        String firstName = scanner.next();
        System.out.print("lastName: ");
        String lastName = scanner.next();
        System.out.print("username: ");
        String username = scanner.next();
        System.out.print("password: ");
        String password = scanner.next();
        System.out.print("phoneNumber: ");
        String phoneNumber = scanner.next();
        System.out.print("email: ");
        String email = scanner.next();
        System.out.print("nationalCode: ");
        String nationalCode = scanner.next();
        System.out.print("studentNumber: ");
        Long studentNumber = scanner.nextLong();
        student.setStudentNumber(studentNumber);
        student.setUsername(username);
        student.setNationalCode(nationalCode);
        student.setEmail(email);
        student.setFirstname(firstName);
        student.setPhoneNumber(phoneNumber);
        student.setPassword(password);
        student.setLastname(lastName);
        studentService.save(student);
        System.out.println("student saved");


    }

    static void updateStudent() {
        System.out.println("update student profile");
        Student student = new Student();
        System.out.println(studentService.findAll());
        System.out.print("enter studentNumber to update");
        Long studentNumber = scanner.nextLong();
        System.out.print("firstName: ");
        String firstName = scanner.next();
        System.out.print("lastName: ");
        String lastName = scanner.next();
        System.out.print("username: ");
        String username = scanner.next();
        System.out.print("password: ");
        String password = scanner.next();
        System.out.print("phoneNumber: ");
        String phoneNumber = scanner.next();
        System.out.print("email: ");
        String email = scanner.next();
        System.out.print("nationalCode: ");
        String nationalCode = scanner.next();
        student.setUsername(username);
        student.setNationalCode(nationalCode);
        student.setEmail(email);
        student.setFirstname(firstName);
        student.setPhoneNumber(phoneNumber);
        student.setPassword(password);
        student.setLastname(lastName);
        studentService.update(studentNumber, student);
        System.out.println("student updated");


    }


    private static void studentManagementMenu() {
        System.out.println("1.See All students");
        System.out.println("2.Add New student ");
        System.out.println("3.Delete student");
        System.out.println("4.see lessons Of student");
        System.out.println("5.see students Of lesson");
        System.out.println("6.Update student Profile");
        System.out.println("5.log out");
        System.out.print("choose: ");
        boolean onlineInStudentMenu = true;
        int input = scanner.nextInt();
        while (onlineInStudentMenu) {
            switch (input) {
                case 1:
                    System.out.println(studentService.findAll());
                    onlineInStudentMenu = false;
                    break;
                case 2:
                    addNewStudent();
                    onlineInStudentMenu = false;
                    break;

                case 3:
                    deleteStudent();
                    onlineInStudentMenu = false;
                    break;
                case 4:
                    seeLessonsOfStudent();
                    onlineInStudentMenu = false;
                    break;
                case 5:
                    seeStudentsOfLessonNumber();
                    onlineInStudentMenu = false;
                    break;
                case 6:

                    updateStudent();
                    onlineInStudentMenu = false;
                    break;

                default:
                    System.out.println("invalid number!!");
                    onlineInStudentMenu = false;
            }

        }
    }

    static void createNewLesson() {
        Lesson lesson = new Lesson();
        System.out.print("lessonName: ");
        String lessonName = scanner.next();
        System.out.print("util: ");
        int util = scanner.nextInt();
        System.out.print("capacity: ");
        int capacity = scanner.nextInt();
        System.out.print("LessonNumber: ");
        Long lessonNumber = scanner.nextLong();
        lesson.setLessonName(lessonName);
        lesson.setCapacity(capacity);
        lesson.setUtil(util);
        lesson.setLessonNumber(lessonNumber);
        lesson.setStartLessonTime(LocalDateTime.now());
        lessonService.save(lesson);
        System.out.println("lesson saved");
    }

    static void removeLesson() {
        System.out.println(lessonService.AllLesson());
        System.out.println();
        System.out.print("enter lessonNumber to delete: ");
        Long lessonNumber = scanner.nextLong();
        lessonService.deleteLesson(lessonNumber);

    }

    static void updateLessonProfile() {
        Lesson lesson = new Lesson();
        System.out.println(lessonService.AllLesson());

        System.out.print("enter lesson Number to update ");
        Long lessonNumber = scanner.nextLong();

        System.out.print("lessonName: ");
        String lessonName = scanner.next();
        System.out.print("util: ");
        int util = scanner.nextInt();
        System.out.print("capacity: ");
        int capacity = scanner.nextInt();

        lesson.setLessonName(lessonName);
        lesson.setCapacity(capacity);
        lesson.setUtil(util);
        lesson.setLessonNumber(lessonNumber);
        lesson.setStartLessonTime(LocalDateTime.now());
        lessonService.updateLesson(lessonNumber, lesson);
        System.out.println("lesson saved");
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
                    System.out.println(lessonService.AllLesson());
                    System.out.println();
                    onlineInLessonMenu = false;
                    break;

                case 2:
                    createNewLesson();
                    onlineInLessonMenu = false;
                    break;
                case 3:
                    removeLesson();
                    onlineInLessonMenu = false;
                    break;
                case 4:
                    updateLessonProfile();
                    onlineInLessonMenu = false;
                    break;
                case 5:
                    onlineInLessonMenu = false;
                default:
                    System.out.println("invalid number");

            }return;
        }
    }
}

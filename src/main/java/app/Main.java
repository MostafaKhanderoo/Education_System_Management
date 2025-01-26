package app;

import app.entity.Lesson;
import app.repository.impl.AdminRepositoryImpl;
import app.repository.impl.LessonRepositoryImpl;
import app.repository.impl.StudentRepositoryImpl;
import app.repository.impl.TeacherRepositoryImpl;
import app.service.impl.AdminServiceImpl;
import app.service.impl.LessonServiceImpl;
import app.service.impl.StudentServiceImpl;
import app.service.impl.TeacherServiceImpl;
import app.ui.AdminUI;
import app.ui.StudentUI;
import app.ui.TeacherUI;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    private static Scanner scanner
            = new Scanner(System.in);
    public static boolean isExist = true;
    private static int input;
    private static StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
    private static StudentServiceImpl studentService = new StudentServiceImpl(studentRepository);
    private static LessonRepositoryImpl lessonRepository = new LessonRepositoryImpl();
    private static LessonServiceImpl lessonService = new LessonServiceImpl(lessonRepository);
    private static TeacherRepositoryImpl teacherRepository = new TeacherRepositoryImpl();
    private static TeacherServiceImpl teacherService = new TeacherServiceImpl(teacherRepository);
    private static AdminRepositoryImpl adminRepository = new AdminRepositoryImpl();
    private static AdminServiceImpl adminService = new AdminServiceImpl(adminRepository);

    public static void main(String[] args) {



//  Lesson lesson = new Lesson();
//  lesson.setLessonNumber(1234l);
//  lesson.setLessonName("homeless2");
//  lesson.setUtil(2);
//  lesson.setCapacity(20);
//  System.out.println("1 set for month 2 set by day");
//  lesson.setStartLessonTime(LocalDateTime.now());
//  int s = scanner.nextInt();
//  switch (s){
//      case 1:
//          lesson.setStartLessonTime(LocalDateTime.now().plusMonths(2));
//          break;
//      case 2:
//          lesson.setStartLessonTime(LocalDateTime.now().plusDays(10));
//          break;
//      default:
//          System.out.println("not errror");
//  }
 // lessonService.save(lesson);


//
//
//        Student student =  new Student();
//        student.setFirstname("mostafa");
//        student.setEmail("mostafa@gmail.com");
//        student.setLastname("khanderoo");
//        student.setPassword("4321");
//        student.setPhoneNumber("0912");
//        student.setUsername("mostafa");
//        student.setNationalCode("432111");
//        student.setStudentNumber(333l);
//        StudentLesson studentLesson =  new StudentLesson();


//
//        studentService.chooseLessonForStudent(321l,studentLesson);
//        System.out.println(AuthenticationStudent.getLoggedInStudent().getFirstname());

//        studentService.findAll();
//        lessonService.AllLesson();
//        teacherService.showAllTeacher();
//        adminService.selectAllAdmin();
//        Lesson lesson  =new Lesson();
//        lesson.setLessonName("computer");
//        lesson.setLessonNumber(432l);
//        lesson.setCapacity(31);
//        lesson.setUtil(3);
//        lesson.setStartLessonTime(LocalDateTime.now());
//lessonService.setTeacherForLesson(4l,3l);


        //  lessonService.save(lesson);

//       adminService.selectAllAdmin();
        //System.out.println(adminService.login("Admin1","12342"));
//       Admin admin= new Admin();
//       admin.setAdminName("reza");
//       admin.setUsername("Admin3");
//       admin.setPassword("1234");
//       adminService.save(admin);
        //adminService.findByUsername("");
        //  System.out.println( adminService.findByUsername("Admin1"));
        //  System.out.println(adminService.selectAllAdmin());
//        teacherService.showAllTeacher();
//        Teacher teacher = new Teacher("ostad2","ostad2","ostad2","12345678","0919","ali2@gmail.com","123456", Expertise.ENGINEERING, Degree.TEST2,666666l);
//
//        teacherService.save(teacher);
//


        System.out.println("1.Admin");
        System.out.println("2.teacher");
        System.out.println("3.Student");
        System.out.println("4.close app");
        System.out.print("choose: ");
        input = scanner.nextInt();
        while (isExist) {
            switch (input) {
                case 1:
                    AdminUI.adminMenu();
                    break;
                case 2:
                    TeacherUI.teacherMenu();
                    break;
                case 3:
                    StudentUI.studentMenu();
                    break;
                case 4:
                    isExist=false;
                    System.out.println("app closed!");
                    break;
                default:
                    System.out.println("invalid number");

            }return;

    }




//        Admin admin = new Admin();
//        admin.setAdminName("mosi");
//        admin.setUsername("admin");
//        admin.setPassword("1234");
//        adminService.save(admin);
    }
}

//lessonService.setTeacherForLesson(1l,3l);
//    }
//        static LessonRepositoryImpl lessonRepository = new LessonRepositoryImpl();
//        static LessonServiceImpl lessonService = new LessonServiceImpl(lessonRepository);
//
//
//
//}
//
//    public static void main(String[] args) {
//
//        System.out.println("test main");
//        AdminRepositoryImpl adminRepository = new AdminRepositoryImpl();
//        AdminServiceImpl adminService = new AdminServiceImpl(adminRepository);
//        Lesson lesson = new Lesson();
//        lesson.setLessonName("amalll");
//        lessonService.save(lesson);
//    Admin admin = new Admin("mostafa", "1234");
//
// adminService.save(admin);
//      StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
//        StudentServiceImpl studentService = new StudentServiceImpl(studentRepository);
//
// Student student = new Student("mamad","mamamdi","mm","mm","091123","mamama@gmail.com","12343",2L);
//  studentService.save(student);
//        var test = studentService.findById(1L);
//
// System.out.println(studentService.findAll());
//studentService.deleteById(2L);
//        Student studentUpp = new Student("saed343", "khanderoo1223", "seead", "saeed1223", "0933", "seed@gmail.com", "2345", 4L);
//        studentService.update(1l, studentUpp);
//studentService.isExistStudent("saeed");
//   studentService.findAll();
///**
// * @param sseeso
// *
// * @return todo test code
// *
// */
//}


package app;

import app.entity.Admin;
import app.entity.Lesson;
import app.entity.Student;
import app.repository.impl.AdminRepositoryImpl;
import app.repository.impl.LessonRepositoryImpl;
import app.repository.impl.StudentRepositoryImpl;
import app.service.AdminService;
import app.service.impl.AdminServiceImpl;
import app.service.impl.LessonServiceImpl;
import app.service.impl.StudentServiceImpl;

public class Main {
    static LessonRepositoryImpl lessonRepository = new LessonRepositoryImpl();
    static LessonServiceImpl lessonService = new LessonServiceImpl(lessonRepository);

    public static void main(String[] args) {

        System.out.println("test main");
        AdminRepositoryImpl adminRepository = new AdminRepositoryImpl();
        AdminServiceImpl adminService = new AdminServiceImpl(adminRepository);
        Lesson lesson = new Lesson();
        lesson.setLessonName("amalll");
        lessonService.save(lesson);
        //    Admin admin = new Admin("mostafa", "1234");

        // adminService.save(admin);
        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
        StudentServiceImpl studentService = new StudentServiceImpl(studentRepository);

        // Student student = new Student("mamad","mamamdi","mm","mm","091123","mamama@gmail.com","12343",2L);
        //  studentService.save(student);
        var test = studentService.findById(1L);

        // System.out.println(studentService.findAll());
//studentService.deleteById(2L);
        Student studentUpp = new Student("saed343", "khanderoo1223", "seead", "saeed1223", "0933", "seed@gmail.com", "2345", 4L);
        studentService.update(1l, studentUpp);
//studentService.isExistStudent("saeed");
        //   studentService.findAll();
///**
// * @param sseeso
// *
// * @return todo test code
// *
// */
    }
}

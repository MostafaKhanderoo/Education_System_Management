package app;

import app.entity.Admin;
import app.entity.Student;
import app.repository.impl.AdminRepositoryImpl;
import app.repository.impl.StudentRepositoryImpl;
import app.service.AdminService;
import app.service.impl.AdminServiceImpl;
import app.service.impl.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("test main");
        AdminRepositoryImpl adminRepository = new AdminRepositoryImpl();
        AdminServiceImpl adminService = new AdminServiceImpl(adminRepository);

        Admin admin = new Admin("mostafa", "1234");

        adminService.save(admin);
        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
        StudentServiceImpl studentService = new StudentServiceImpl(studentRepository);

        Student student = new Student("ali","ahmadi","ali","123456","093000","ali@gmail.com","123456",1L);
        studentService.save(student);
///**
// * @param sseeso
// *
// * @return todo test code
// *
// */
    }
}

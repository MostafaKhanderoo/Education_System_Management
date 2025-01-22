package app.service.impl;

import app.cfg.SessionFactoryInstance;
import app.entity.Student;
import app.entity.StudentLesson;
import app.repository.StudentRepository;
import app.repository.impl.StudentRepositoryImpl;
import app.service.Authentication.AuthenticationStudent;
import app.service.StudentService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepositoryImpl studentRepository;

    @Override
    public Student save(Student student) {
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                studentRepository.save(session, student);
                session.getTransaction().commit();
                return student;
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RuntimeException(e.getMessage());

            }
        }
    }

    @Override
    public Student findById(Long id) {
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {

            return studentRepository.findById(session, id).orElseThrow(RuntimeException::new);

        }
    }

    @Override
    public void deleteByStudentNumber(Long studentNumber) {
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                studentRepository.deleteByStudentNumber(session, studentNumber);
                session.getTransaction().commit();

            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RuntimeException(e.getMessage());
            }

        }
    }

    @Override
    public List<Student> findAll() {

        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            List<Student> students = studentRepository.findAll(session);
            System.out.println("test service");
            return students;
        }
    }


    @Override
    public Student update(Long studentNumber,Student student) {


        try (var session = SessionFactoryInstance.sessionFactory.openSession()){
            try {
                session.beginTransaction();

                student.setId(studentNumber);
                studentRepository.update(session,studentNumber ,student);
                session.getTransaction().commit();

                return student;

            } catch (Exception e) {

                session.getTransaction().rollback();
                throw new RuntimeException(e.getMessage());
            }
        }
    }
    public boolean login(Long studentNumber, String password){
        try(var session =SessionFactoryInstance.sessionFactory.openSession()){
            try {
                session.beginTransaction();
                studentRepository.login(session,studentNumber,password);
              var logStudent=  AuthenticationStudent.getLoggedInStudent();
                session.getTransaction().commit();
                return true;
            }catch (Exception e){
                throw new RuntimeException(e.getMessage());

            }


        }
    }
    public void chooseLessonForStudent(Long lessonNumber){
        try(var session =SessionFactoryInstance.sessionFactory.openSession()){
          try{
              session.beginTransaction();

              studentRepository.chooseCourseForStudent(session,lessonNumber);
              session.getTransaction().commit();


          }catch (Exception e ){
              session.getTransaction().rollback();
              throw new RuntimeException(e.getMessage());
          }
        }
    }
    public List<StudentLesson> seeStudentByLessonNumber(Long lessonNumber) {
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            return studentRepository.seeStudentByLessonId(session, lessonNumber);
        }
    }

    public List<StudentLesson> seeLessonByStudentNumber(Long studentNumber){
        try(var session =SessionFactoryInstance.sessionFactory.openSession()){
            return studentRepository.seeLessonByStudentId(session,studentNumber);
        }
    }


//    public boolean isExistStudent(String username) {
//        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
//            return studentRepository.isExist(session, username);
//
//        }
//    }

}
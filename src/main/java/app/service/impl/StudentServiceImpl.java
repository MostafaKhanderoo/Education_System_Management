package app.service.impl;

import app.cfg.SessionFactoryInstance;
import app.entity.Student;
import app.repository.StudentRepository;
import app.repository.impl.StudentRepositoryImpl;
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
    public void deleteById(Long id) {
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                studentRepository.deleteById(session, id);
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
    public Student update(Long id,Student student) {


        try (var session = SessionFactoryInstance.sessionFactory.openSession()){
            try {
                session.beginTransaction();

                student.setId(id);
                studentRepository.update(session,id ,student);
                session.getTransaction().commit();

                return student;

            } catch (Exception e) {

                session.getTransaction().rollback();
                throw new RuntimeException(e.getMessage());
            }
        }
    }

//    public boolean isExistStudent(String username) {
//        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
//            return studentRepository.isExist(session, username);
//
//        }
//    }

}
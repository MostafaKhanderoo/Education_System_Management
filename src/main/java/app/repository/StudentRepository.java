package app.repository;

import app.entity.Student;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Student save(Session session,Student student);
    Optional<Student> findById(Session session, Long id);
    void deleteByStudentNumber(Session session,Long studentNumber);
    List<Student>findAll(Session session);
    Student update(Session session,Long id,Student student);
    boolean login(Session session,Long studentNumber,String password);



}

package app.repository.impl;

import app.entity.Student;
import app.repository.StudentRepository;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public Student save(Session session, Student student) {
       session.persist(student);
       return student;

    }

    @Override
    public Optional<Student> findById(Session session, Long id) {
        session.byId(Student.class).loadOptional(id);

        return null;
    }

    @Override
    public void deleteById(Session session, Long id) {
            session.detach(id);
    }

    @Override
    public List<Student> findAll(Session session) {
        return null;
    }

    @Override
    public Student update(Session session, Student student) {
        return null;
    }
}

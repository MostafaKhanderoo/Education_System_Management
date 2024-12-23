package app.repository.impl;

import app.entity.Teacher;
import app.repository.TeacherRepository;
import org.hibernate.Session;

import java.util.List;

public class TeacherRepositoryImpl implements TeacherRepository {
    @Override
    public Teacher save(Session session, Teacher teacher) {
        session.persist(teacher);
        return teacher;
    }

    @Override
    public Teacher findById(Session session, Long id) {
        return null;
    }

    @Override
    public void deleteById(Session session, Long id) {

    }

    @Override
    public List<Teacher> findAll(Session session) {
        return null;
    }

    @Override
    public Teacher update(Session session, Teacher teacher) {
        return null;
    }
}

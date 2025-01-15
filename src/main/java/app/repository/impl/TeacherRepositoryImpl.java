package app.repository.impl;

import app.entity.Student;
import app.entity.Teacher;
import app.repository.TeacherRepository;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class TeacherRepositoryImpl implements TeacherRepository {
    @Override
    public Teacher save(Session session, Teacher teacher) {
        session.persist(teacher);
        return teacher;
    }

    @Override
    public Optional<Teacher> findById(Session session, Long id) {
        return Optional.of(session.get(Teacher.class,id));
    }

    @Override
    public void deleteById(Session session, Long id) {
            session.createMutationQuery("delete from Teacher a where a.id = :id").setParameter("id",id).executeUpdate();
    }

    @Override
    public List<Teacher> findAll(Session session) {
        var studentList = session.createMutationQuery("from Student");
        return (List<Teacher>) studentList;
    }

    @Override
    public Teacher update(Session session,Long id, Teacher teacher) {
        teacher.setId(id);
        session.merge(teacher);
        return null;
    }
}

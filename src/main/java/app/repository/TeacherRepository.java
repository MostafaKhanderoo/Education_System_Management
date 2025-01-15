package app.repository;

import app.entity.Student;
import app.entity.Teacher;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository {
    Teacher save(Session session, Teacher teacher);
    Optional<Teacher> findById(Session session, Long id);
    void deleteById(Session session,Long id);
    List<Teacher> findAll(Session session);
    Teacher update(Session session,Long id,Teacher teacher);
}

package app.repository.impl;

import app.entity.Lesson;
import app.entity.Student;
import app.entity.StudentLesson;
import app.entity.Teacher;
import app.repository.TeacherRepository;
import app.service.Authentication.AuthenticationTeacher;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;

import java.time.LocalDateTime;
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
        return Optional.of(session.get(Teacher.class, id));
    }



    @Override
    public void deleteByPersonnelCode(Session session, Long personnelCode) {
        session.createMutationQuery("delete from Teacher a where a.personnelCode = :personnelCode").setParameter("personnelCode", personnelCode).executeUpdate();
    }

    @Override
    public List<Teacher> findAll(Session session) {
        List<Teacher> teacherList = session.createQuery("from Teacher", Teacher.class).list();
        return teacherList;
    }

    @Override
    public Teacher update(Session session, Long personnelCode, Teacher teacher) {
        teacher.setPersonnelCode(personnelCode);
        session.merge(teacher);
        return teacher;
    }


    public boolean login(Session session, Long personnelCode, String password) {
        try {
            var teacher = session.createQuery("from Teacher a where a.personnelCode =:personnelCode", Teacher.class).setParameter("personnelCode", personnelCode).getSingleResult();
            if (teacher.getPersonnelCode().equals(personnelCode) && (teacher.getPassword().equals(password))) {
                AuthenticationTeacher.setLoggedTeacher(teacher);
                return true;

            } else
                System.out.println("personnelCode or password is wrong!");

            return false;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        }


    public List<Lesson> lessonsForTeacher(Session session, Long personnelCode) {
        List<Lesson> lessonsOfTeacher = session.createQuery("from  Lesson a where a.teacher.personnelCode = :personnelCode", Lesson.class).setParameter("personnelCode", personnelCode).list();
        return lessonsOfTeacher;
    }


    public void changeUsernameAmdPassword(Session session,Long personnelCode, String username,String password){
        var student= session.createQuery("from Teacher a where a.personnelCode = :personnelCode",Teacher.class).setParameter("personnelCode",personnelCode).getSingleResult();
        student.setUsername(username);
        student.setPassword(password);
    }



}

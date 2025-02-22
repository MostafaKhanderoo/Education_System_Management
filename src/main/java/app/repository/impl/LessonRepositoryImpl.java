package app.repository.impl;

import app.entity.Lesson;
import app.entity.Teacher;
import app.repository.LessonRepository;
import app.service.Authentication.AuthenticationTeacher;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class LessonRepositoryImpl implements LessonRepository {
    @Override
    public Lesson addNewLesson(Session session, Lesson lesson) {
        session.persist(lesson);
        return lesson;
    }

    @Override
    public void deleteLessen(Session session, Long lessonNumber) {
        session.createMutationQuery("delete from Lesson a where a.lessonNumber = :lessonNumber ").setParameter("lessonNumber",lessonNumber).executeUpdate();
    }

    @Override
    public Lesson update(Session session, Long lessonNumber, Lesson lesson) {
        lesson.setLessonNumber(lessonNumber);
        session.merge(lesson);
        return lesson;
    }

    @Override
    public List<Lesson> ShowAllLessonAvailable(Session session) {
         List<Lesson> lessons = session.createQuery("from Lesson ",Lesson.class).list();
         return lessons;
    }

    @Override
    public Optional<Lesson> showLessonById(Session session, Long id) {
        //var lessons= session.createMutationQuery(" from Lesson a where a.id= :id").setParameter("id",id);
        return Optional.of(session.get(Lesson.class,id));
    }

    @Override
    public List<Lesson> showLessonByName(Session session, String name) {

        return null;
    }
    public  void setLessonForTeacher(Session session,Long lessonNumber, Long personnelCode){
try {
    var lesson = session.createQuery("from  Lesson a where a.lessonNumber =:lessonNumber",Lesson.class).setParameter("lessonNumber",lessonNumber).getSingleResult();
    var teacher =session.createQuery("from Teacher  a where a.personnelCode = :personnelCode",Teacher.class).setParameter("personnelCode",personnelCode).getSingleResult();
    lesson.setTeacher(teacher);

}catch (Exception e){
throw new RuntimeException(e.getMessage());
}
    }

}

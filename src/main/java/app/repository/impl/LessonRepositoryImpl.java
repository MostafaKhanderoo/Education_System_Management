package app.repository.impl;

import app.entity.Lesson;
import app.entity.Teacher;
import app.repository.LessonRepository;
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
    public  void setLessonForTeacher(Session session,Long lessonId, Long teacherId){
        var lesson = session.get(Lesson.class,lessonId);
        var teacher =session.get(Teacher.class,teacherId);
         lesson.setTeacher(teacher);
    }

}

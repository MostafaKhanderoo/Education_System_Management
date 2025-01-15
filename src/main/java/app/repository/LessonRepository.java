package app.repository;

import app.entity.Lesson;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public interface LessonRepository {
    Lesson addNewLesson(Session session ,Lesson lesson);
    void deleteLessen(Session session,Long id);
    Lesson update(Session session,Long id ,Lesson lesson);
    List<Lesson>ShowAllLessonAvailable(Session session);
   Optional <Lesson> showLessonById(Session session, Long id);
    List<Lesson>showLessonByName(Session session,String name);


}

package app.repository;

import app.entity.Lesson;
import org.hibernate.Session;

public interface LessonRepository {
    Lesson save(Session session ,Lesson lesson);

}

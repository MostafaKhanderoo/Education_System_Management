package app.repository.impl;

import app.entity.Lesson;
import app.repository.LessonRepository;
import org.hibernate.Session;

public class LessonRepositoryImpl implements LessonRepository {
    @Override
    public Lesson save(Session session, Lesson lesson) {
        session.persist(lesson);
        return lesson;
    }
}

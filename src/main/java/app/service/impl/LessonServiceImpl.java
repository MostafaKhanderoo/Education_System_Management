package app.service.impl;

import app.cfg.SessionFactoryInstance;
import app.entity.Lesson;
import app.repository.impl.LessonRepositoryImpl;
import app.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
private final LessonRepositoryImpl lessonRepository;
    @Override
    public Lesson save(Lesson lesson) {
        try(var session= SessionFactoryInstance.sessionFactory.openSession()){
            try {
                session.beginTransaction();
                lessonRepository.save(session,lesson);
                session.getTransaction().commit();
                return lesson;
            }catch (Exception e){
                session.getTransaction().rollback();
                throw  new RuntimeException(e.getMessage());

            }

        }

    }
}

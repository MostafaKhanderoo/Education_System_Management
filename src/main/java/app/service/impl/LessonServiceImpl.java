package app.service.impl;

import app.cfg.SessionFactoryInstance;
import app.entity.Lesson;
import app.repository.impl.LessonRepositoryImpl;
import app.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
private final LessonRepositoryImpl lessonRepository;
    @Override
    public Lesson save(Lesson lesson) {
        try(var session= SessionFactoryInstance.sessionFactory.openSession()){
            try {
                session.beginTransaction();
                lessonRepository.addNewLesson(session,lesson);
                session.getTransaction().commit();
                return lesson;
            }catch (Exception e){
                session.getTransaction().rollback();
                throw  new RuntimeException(e.getMessage());

            }

        }

    }

    @Override
    public void deleteLesson(Long id) {
        try(var session = SessionFactoryInstance.sessionFactory.openSession()){
            try {
                session.beginTransaction();
                lessonRepository.deleteLessen(session,id);
                session.getTransaction().commit();

            }catch (Exception e){
                session.getTransaction().rollback();
                throw new RuntimeException(e.getMessage());
            }
        }

    }

    @Override
    public List<Lesson> AllLesson() {

        try(var session = SessionFactoryInstance.sessionFactory.openSession()){
            List<Lesson>lessons = lessonRepository.ShowAllLessonAvailable(session);
            return lessons;

        }

    }

    @Override
    public Lesson LessonById(Long id) {
        try(var session = SessionFactoryInstance.sessionFactory.openSession()){

            return  lessonRepository.showLessonById(session,id).orElseThrow(RuntimeException::new);
        }

    }
public void setTeacherForLesson(Long lessonId,Long teacherId){
      try(var session=  SessionFactoryInstance.sessionFactory.openSession()){
          try {
              session.beginTransaction();
              lessonRepository.setLessonForTeacher(session, lessonId ,teacherId);
              session.getTransaction().commit();
          }catch (Exception e ){
              session.getTransaction().rollback();
              throw new RuntimeException(e.getMessage());
          }
      }

}

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
       try(var session=SessionFactoryInstance.sessionFactory.openSession()){
         try {
             session.beginTransaction();
             lessonRepository.update(session,id,lesson);
             session.getTransaction().commit();
             return lesson;
         }catch (Exception e){
             session.getTransaction().rollback();
             throw new RuntimeException(e.getMessage());

         }
       }
    }
}

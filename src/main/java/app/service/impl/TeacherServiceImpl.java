package app.service.impl;

import app.cfg.SessionFactoryInstance;
import app.entity.Teacher;
import app.repository.impl.TeacherRepositoryImpl;
import app.service.TeacherService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
private final TeacherRepositoryImpl teacherRepository;
    @Override
    public Teacher save(Teacher teacher) {
      try(var session = SessionFactoryInstance.sessionFactory.openSession()){
          try {
              session.beginTransaction();
              teacherRepository.save(session,teacher);
              session.getTransaction().commit();
              return teacher;
          }catch (Exception e){
              session.getTransaction().rollback();
              throw new RuntimeException(e.getMessage());
          }
      }
    }
}

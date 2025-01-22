package app.service.impl;

import app.cfg.SessionFactoryInstance;
import app.entity.Lesson;
import app.entity.Teacher;
import app.repository.impl.TeacherRepositoryImpl;
import app.service.Authentication.AuthenticationTeacher;
import app.service.TeacherService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Teacher update(Long personnelCode, Teacher teacher) {
        try(var session = SessionFactoryInstance.sessionFactory.openSession()){
            try {
                session.beginTransaction();
                teacherRepository.update(session,personnelCode,teacher);
                session.getTransaction().commit();
                return teacher;
            }catch (Exception e){
                session.getTransaction().rollback();
                throw new RuntimeException(e.getMessage());

            }

        }

    }

    @Override
    public void deleteTeacher(Long personnelCode) {
        try(var session = SessionFactoryInstance.sessionFactory.openSession()){
            try{
                session.beginTransaction();
                teacherRepository.deleteByPersonnelCode(session,personnelCode);
                session.getTransaction().commit();

            }catch (Exception e ){
                session.getTransaction().rollback();
                throw new RuntimeException(e.getMessage());

            }
        }

    }

    @Override
    public Teacher findTeacherById(Long id) {
        try(var session = SessionFactoryInstance.sessionFactory.openSession()){
            return  teacherRepository.findById(session,id).orElseThrow(RuntimeException::new);

        }

    }

    @Override
    public List<Teacher> showAllTeacher() {
        try(var session = SessionFactoryInstance.sessionFactory.openSession()) {

            return teacherRepository.findAll(session);

        }
    }
    public Boolean login(Long personalCode,String password){
        try(var session =SessionFactoryInstance.sessionFactory.openSession()){
          try{
              session.beginTransaction();
              teacherRepository.login(session,personalCode,password);
                session.getTransaction().commit();
                return true;
          }catch (Exception e){
              throw new RuntimeException(e.getMessage());
          }

        }
    }
    public List<Lesson>lessonsOfTeacher(){
        try(var session= SessionFactoryInstance.sessionFactory.openSession()){
         var personnelCode=   AuthenticationTeacher.getLoggedInTeacher().getPersonnelCode();
          return teacherRepository.lessonsForTeacher(session,personnelCode);
        }
    }
}

package app.service.impl;

import app.cfg.SessionFactoryInstance;
import app.entity.StudentLesson;
import app.repository.impl.StudentCourseRepositoryImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class StudentCourseServiceImpl {
    private final StudentCourseRepositoryImpl studentCourseRepository;
    public void chooseLessonForStudent(Long lessonNumber){
        try(var session = SessionFactoryInstance.sessionFactory.openSession()){
            try{
                session.beginTransaction();

                studentCourseRepository.chooseCourseForStudent(session,lessonNumber);
                session.getTransaction().commit();


            }catch (Exception e ){
                session.getTransaction().rollback();
                throw new RuntimeException(e.getMessage());
            }
        }
    }
    public List<StudentLesson> seeStudentByLessonNumber(Long lessonNumber) {
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            return studentCourseRepository.seeStudentByLessonNumber(session, lessonNumber);
        }
    }
    public List<StudentLesson> seeLessonByStudentNumber(Long studentNumber){
        try(var session =SessionFactoryInstance.sessionFactory.openSession()){
            return studentCourseRepository.seeLessonByStudentNumber(session,studentNumber);
        }
    }
    public StudentLesson setScoreForStudentByTeacher(Long lessonNumber,Long studentNumber,Double score){
        try(var session =SessionFactoryInstance.sessionFactory.openSession()){
            try {
                session.beginTransaction();
                var studentSetScore= studentCourseRepository.setScoreForStudentByTeacher(session,lessonNumber,score,studentNumber);
                session.getTransaction().commit();
                return studentSetScore;
            }catch (Exception e){
                session.getTransaction().rollback();
                throw new RuntimeException(e.getMessage());

            }


        }
    }

}

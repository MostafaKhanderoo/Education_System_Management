package app.repository.impl;

import app.entity.Lesson;
import app.entity.Student;
import app.entity.StudentLesson;
import app.service.Authentication.AuthenticationStudent;
import app.service.Authentication.AuthenticationTeacher;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;

public class StudentCourseRepositoryImpl {
    public Boolean chooseCourseForStudent(Session session, Long lessonNumber) {
        var lessonChooses = session.createQuery("from Lesson a where a.lessonNumber = :lessonNumber", Lesson.class).setParameter("lessonNumber", lessonNumber).getSingleResult();
        var loginStudent = AuthenticationStudent.getLoggedInStudent();
        StudentLesson studentLesson = new StudentLesson();
        boolean isAfter = lessonChooses.getStartLessonTime().isAfter(LocalDateTime.now());
        boolean capacityIsFull = lessonChooses.getCapacity() >= 0;
        if (isAfter) {
            if (capacityIsFull) {
                studentLesson.setStudent(loginStudent);
                studentLesson.setLesson(lessonChooses);
                session.merge(studentLesson);
                lessonChooses.setCapacity(lessonChooses.getCapacity() - 1);
                return true;

            }else {
                System.out.println("capacity is full");
                return false;
            }

        }else {
            System.out.println("lesson has been started");

            return false;
        }
    }

    public List<StudentLesson> seeStudentByLessonNumber(Session session, Long lessonNumber) {
        var studentLessons = session.createQuery("select student from  StudentLesson a where a.lesson.lessonNumber = :lessonNumber", StudentLesson.class).setParameter("lessonNumber", lessonNumber).list();
        return studentLessons;
    }

    public List<StudentLesson> seeLessonByStudentNumber(Session session, Long studentNumber) {
        var studentLessons = session.createQuery("select lesson.lessonName from  StudentLesson a where a.student.studentNumber = :studentNumber", StudentLesson.class).setParameter("studentNumber", studentNumber).list();
        return studentLessons;
    }
    public StudentLesson setScoreForStudentByTeacher(Session session, Long lessonNumber, Double score, Long studentNumber) {
        try {


            String hql = "from StudentLesson a " +
                    "where a.lesson.lessonNumber = :lessonNumber " +
                    "and a.student.studentNumber = :studentNumber";

            StudentLesson studentLesson = session.createQuery(hql, StudentLesson.class)
                    .setParameter("lessonNumber", lessonNumber)
                    .setParameter("studentNumber", studentNumber)
                    .getSingleResult();


            System.out.println("Setting score for lessonNumber: " + lessonNumber + ", studentNumber: " + studentNumber);
            if (studentLesson.getLesson().getTeacher().getPersonnelCode().equals(AuthenticationTeacher.getLoggedInTeacher().getPersonnelCode())) {
                if (studentLesson.getLesson().getStartLessonTime().isBefore(LocalDateTime.now())) {
                    studentLesson.setScore(score);
                    return studentLesson;
                } else {
                    System.out.println("this lesson not start");
                    return null;
                }

            } else {
                System.out.println("this lesson is not for this teacher ");
                return null;
            }


        } catch (NoResultException e) {
            System.err.println("No StudentLesson found for lessonNumber: " + lessonNumber + " and studentNumber: " + studentNumber);
            return null;
        } catch (Exception e) {
            System.err.println("An error occurred while setting the score: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
    public List<Student> AllStudentForLessonATeacher(Session session, Long personnelCode) {
        return session.createQuery("select student from StudentLesson a where a.lesson.teacher.personnelCode = :personnelCode", Student.class).setParameter("personnelCode", personnelCode).list();
    }
}

package app.repository.impl;

import app.entity.Lesson;
import app.entity.Student;
import app.entity.StudentLesson;
import app.repository.StudentRepository;
import app.service.Authentication.AuthenticationStudent;
import app.service.impl.StudentServiceImpl;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.ToString;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@ToString
public class StudentRepositoryImpl implements StudentRepository {
    StudentRepositoryImpl studentRepository;
    StudentServiceImpl studentService;

    @Override
    public Student save(Session session, Student student) {
        session.persist(student);
         return student;

    }

    @Override
    public Optional<Student> findById(Session session, Long id) {
        //session.get(Student.class,id);
        return Optional.of(session.get(Student.class, id));


    }

    @Override
    public void deleteByStudentNumber(Session session, Long studentNumber) {
        session.createMutationQuery("delete from Student a where a.studentNumber = :studentNumber").setParameter("studentNumber", studentNumber).executeUpdate();
    }

    @Override
    public List<Student> findAll(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> rootEntry = cq.from(Student.class);
        CriteriaQuery<Student> all = cq.select(rootEntry);

        TypedQuery<Student> allQuery = session.createQuery(all);
        return allQuery.getResultList();

    }

    @Override
    public Student update(Session session, Long studentNumber, Student student) {

        student.setStudentNumber(studentNumber);
        session.merge(student);

        return student;
    }

    @Override
    public boolean login(Session session, Long studentNumber, String password) {
        var student = session.createQuery("from Student a where a.studentNumber =:studentnumber", Student.class).setParameter("studentnumber", studentNumber).getSingleResult();
        if (student.getStudentNumber().equals(studentNumber) && (student.getPassword().equals(password))) {
            AuthenticationStudent.setLoggedStudent(student);
            return true;
        } else
            System.out.println("Student number or password is wrong!");
        return false;
    }



    public void changeUsernameAmdPassword(Session session,Long studentNumber, String username,String password){
var student= session.createQuery("from Student a where a.studentNumber = :studentNumber",Student.class).setParameter("studentNumber",studentNumber).getSingleResult();
student.setUsername(username);
student.setPassword(password);
    }
}


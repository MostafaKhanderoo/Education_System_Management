package app.repository.impl;

import app.entity.Student;
import app.repository.StudentRepository;
import app.service.impl.StudentServiceImpl;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.ToString;
import org.hibernate.Session;
import org.postgresql.core.Query;

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
      return Optional.of(session.get(Student.class,id));


    }

    @Override
    public void deleteById(Session session, Long id) {
            session.createMutationQuery("delete from Student a where a.id = :id").setParameter("id",id).executeUpdate();
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
    public Student update(Session session,Long id, Student student) {

        student.setId(id);
        session.merge(student);

        return student;
    }
}

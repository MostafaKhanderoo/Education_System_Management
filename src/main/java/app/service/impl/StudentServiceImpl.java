package app.service.impl;

import app.cfg.SessionFactoryInstance;
import app.entity.Student;
import app.repository.StudentRepository;
import app.repository.impl.StudentRepositoryImpl;
import app.service.StudentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private  final StudentRepositoryImpl studentRepository;
    @Override
    public Student save(Student student) {
        try(var session =  SessionFactoryInstance.sessionFactory.openSession()){
            try {
                session.beginTransaction();
                studentRepository.save(session, student);
                session.getTransaction().commit();
                return student;
            }catch (Exception e){
                session.getTransaction().rollback();
                throw new RuntimeException(e.getMessage());

            }
        }
    }
}

package app.service;

import app.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student save(Student student);
    Student findById(Long id);
    void deleteById(Long id);
    List<Student>findAll();
    Student update(Long id,Student student);
}

package app.service;

import app.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    Teacher save (Teacher teacher);
    Teacher update(Long id ,Teacher teacher);
    void deleteTeacher(Long id);
    Teacher findTeacherById(Long id );
    List<Teacher> showAllTeacher();


}

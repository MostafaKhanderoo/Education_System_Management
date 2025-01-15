package app.service;

import app.entity.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonService {
    Lesson save (Lesson lesson);
    void deleteLesson(Long id);
    List<Lesson>AllLesson();
    Lesson LessonById(Long id);
    Lesson updateLesson(Long id ,Lesson lesson );
}
